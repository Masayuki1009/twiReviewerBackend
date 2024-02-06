package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.dto.PopularTwitterer;
import com.example.dto.TotalSummary;

@Repository
public class TwittererRepository {
                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  @Autowired
                  public TwittererRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }
                  // 上記のやり方をコンストラインインジェクションと呼ぶ。
                  // final指定で変更不可にできる

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<TotalSummary> TOTAL_SUMMARY_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      TotalSummary.class);
                  private static final RowMapper<PopularTwitterer> POPULAR_TWITTERER_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      PopularTwitterer.class);

                  // 詳細画面の上部に関連するデータを取得(総合評価点はここで取得)
                  public TotalSummary findTotalSummary(Integer twittererId, Integer totalvalueCategoryId) {

                                    String sql = "SELECT t.name, t.account_id, rcasl.average_score AS averageTotalValue "
                                                                        + "FROM twitterer t "
                                                                        + "INNER JOIN review_category_average_score_list rcasl ON t.id = rcasl.twitterer_id "
                                                                        + "WHERE t.id = :id AND rcasl.review_category_id = :total_value_category_id";
                                    SqlParameterSource param = new MapSqlParameterSource().addValue("id", twittererId)
                                                                        .addValue("total_value_category_id", totalvalueCategoryId);
                                    return template.queryForObject(sql, param, TOTAL_SUMMARY_ROW_MAPPER);
                  }

                  // 高評価ツイッタラーのデータ取得、総合得点も取得
                  public List<PopularTwitterer> findPopularTwitterers(Integer totalvalueCategoryId) {

                                    String sql = "SELECT t.id, t.name, t.account_id AS accountId, rcasl.average_score AS averageTotalValue "
                                                                        +
                                                                        "FROM twitterer t "
                                                                        +
                                                                        "INNER JOIN review_category_average_score_list rcasl ON t.id = rcasl.twitterer_id "
                                                                        +
                                                                        "WHERE rcasl.review_category_id = :total_value_category_id "
                                                                        +
                                                                        "ORDER BY rcasl.average_score DESC LIMIT 5";
                                    // Listを返すメソッド
                                    SqlParameterSource param = new MapSqlParameterSource().addValue(
                                                                        "total_value_category_id",
                                                                        totalvalueCategoryId);
                                    return template.query(sql, param, POPULAR_TWITTERER_ROW_MAPPER);
                  }

}

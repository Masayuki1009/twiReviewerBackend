package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.ReviewCategoryAverageScoreList;

@Repository
public class ReviewCategoryAverageScoreListRepository {
                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  // Dependency Injection
                  @Autowired
                  public ReviewCategoryAverageScoreListRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }
                  // 上記のやり方をコンストラインインジェクションと呼ぶ。
                  // final指定で変更不可にできる

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<ReviewCategoryAverageScoreList> REVIEW_CATEGORY_AVERAGE_SCORE_LIST_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      ReviewCategoryAverageScoreList.class);

                  // チャート表示対象のカテゴリリスト一覧を取得
                  public List<ReviewCategoryAverageScoreList> findReviewCategoryAverageScoreListRepository(
                                                      Integer twittererId, Integer firstChartCategoryId,
                                                      Integer lastChartCategoryId) {
                                    String sql = "SELECT average_score FROM review_category_average_score_list WHERE twitterer_id = :id AND review_category_id BETWEEN :first_chart_category_id AND :last_chart_category_id";
                                    SqlParameterSource param = new MapSqlParameterSource().addValue("id", twittererId)
                                                                        .addValue("first_chart_category_id", firstChartCategoryId)
                                                                        .addValue("last_chart_category_id", lastChartCategoryId);
                                    return template.query(sql, param, REVIEW_CATEGORY_AVERAGE_SCORE_LIST_ROW_MAPPER);
                  }

}

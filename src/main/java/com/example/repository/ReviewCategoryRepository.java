package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.ReviewCategory;

@Repository
public class ReviewCategoryRepository {
                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  // DI
                  @Autowired
                  public ReviewCategoryRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }
                  // 上記のやり方をコンストラインインジェクションと呼ぶ。
                  // final指定で変更不可にできる

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<ReviewCategory> REVIEW_CATEGORY_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      ReviewCategory.class);

                  // チャート表示対象のカテゴリ名称取得
                  public List<ReviewCategory> findReviewCategoryName(Integer firstChartCategoryId,
                                                      Integer lastChartCategoryId) {
                                    String sql = "SELECT category_name FROM review_category WHERE id BETWEEN :first_id AND :last_id";
                                    SqlParameterSource param = new MapSqlParameterSource().addValue(
                                                                        "first_id", firstChartCategoryId)
                                                                        .addValue("last_id", lastChartCategoryId);
                                    return template.query(sql, param, REVIEW_CATEGORY_ROW_MAPPER);
                  }
}

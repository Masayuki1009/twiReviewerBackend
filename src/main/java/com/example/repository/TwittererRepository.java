package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.PopularTwitterer;

@Repository
public class TwittererRepository {

                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  // Dependency Injection
                  @Autowired
                  public TwittererRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }

                  // 上記のやり方をコンストラインインジェクションと呼ぶ。
                  // final指定で変更不可にできる

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<PopularTwitterer> POPULAR_TWITTERER_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      PopularTwitterer.class);

                  public List<PopularTwitterer> findPopularTwitterers() {
                                    String sql = "SELECT t.name, t.account_id AS accountId, tr.average_total_value AS averageTotalValue "
                                                                        +
                                                                        "FROM twitterer t INNER JOIN total_review tr ON t.id = tr.twitterer_id "
                                                                        +
                                                                        "ORDER BY tr.average_total_value DESC LIMIT 5";

                                    return template.query(sql, POPULAR_TWITTERER_ROW_MAPPER);
                  }
}

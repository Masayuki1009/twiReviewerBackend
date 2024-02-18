package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

@Repository
public class CommentRepository {
                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  @Autowired
                  public CommentRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }
                  // 上記のやり方をコンストラインインジェクションと呼ぶ。
                  // final指定で変更不可にできる

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<Comment> COMMENT_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      Comment.class);

                  // [修正候補]必要に応じて取得数limit設ける
                  public List<Comment> getTwitterCommentList(Integer twittererId) {
                                    String sql = "SELECT post_time, posted_name, humor, tweet_frequency, buss_power, humanity, originality, total_score, comment "
                                                                        + "FROM comment "
                                                                        + "WHERE twitterer_id = :twitterer_id";

                                    SqlParameterSource param = new MapSqlParameterSource().addValue(
                                                                        "twitterer_id",
                                                                        twittererId);

                                    return template.query(sql, param, COMMENT_ROW_MAPPER);

                  }
}

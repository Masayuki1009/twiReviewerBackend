package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.ServerConfig;

import io.github.cdimascio.dotenv.Dotenv;

@Repository
public class ServerConfigRepository {
                  // JDBCの操作を簡素化(namedParameter(名前付きplaceholder)使える)
                  private final NamedParameterJdbcTemplate template;

                  @Autowired
                  public ServerConfigRepository(NamedParameterJdbcTemplate template) {
                                    this.template = template;
                  }

                  // セット（ResultSet）の各行をオブジェクトにマッピングする
                  private static final RowMapper<ServerConfig> SERVER_CONFIG_ROW_MAPPER = new BeanPropertyRowMapper<>(
                                                      ServerConfig.class);

                  public List<ServerConfig> getServerConfigDataList() {
                                    Dotenv dotenv = Dotenv.load();// 環境変数管理
                                    Integer startId = Integer.parseInt(dotenv.get("START_ID"));
                                    Integer lastId = Integer.parseInt(dotenv.get("LAST_ID"));

                                    String sql = "SELECT parameter FROM server_config WHERE id BETWEEN :start_id AND :last_id";

                                    SqlParameterSource param = new MapSqlParameterSource().addValue(
                                                                        "start_id", startId)
                                                                        .addValue("last_id", lastId);
                                    return template.query(sql, param, SERVER_CONFIG_ROW_MAPPER);
                  }
}

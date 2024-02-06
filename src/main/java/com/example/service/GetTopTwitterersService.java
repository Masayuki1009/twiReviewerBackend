package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ServerConfig;
import com.example.dto.PopularTwitterer;
import com.example.repository.ServerConfigRepository;
import com.example.repository.TwittererRepository;

@Service
public class GetTopTwitterersService {

                  // コンストラインインジェクション。final指定で変更不可
                  private final TwittererRepository twittererRepository;
                  private final ServerConfigRepository serverConfigRepository;

                  @Autowired
                  public GetTopTwitterersService(TwittererRepository twittererRepository,
                                                      ServerConfigRepository serverConfigRepository) {
                                    this.twittererRepository = twittererRepository;
                                    this.serverConfigRepository = serverConfigRepository;
                  }

                  public List<PopularTwitterer> getTopTwitterers() {
                                    List<ServerConfig> serverconfigDataList = serverConfigRepository
                                                                        .getServerConfigDataList();
                                    // 総合評価のカテゴリid
                                    Integer totalvalueCategoryId = Integer.parseInt(
                                                                        serverconfigDataList.get(0).getParameter());
                                    return twittererRepository.findPopularTwitterers(totalvalueCategoryId);
                  }
}

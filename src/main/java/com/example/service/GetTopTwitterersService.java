package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PopularTwitterer;
import com.example.repository.GetTopTwitterersRepository;

@Service
public class GetTopTwitterersService {

                  // コンストラインインジェクション。final指定で変更不可
                  private final GetTopTwitterersRepository twittererRepository;

                  @Autowired
                  public GetTopTwitterersService(GetTopTwitterersRepository twittererRepository) {
                                    this.twittererRepository = twittererRepository;
                  }

                  public List<PopularTwitterer> getTopTwitterers() {
                                    return twittererRepository.findPopularTwitterers();
                  }
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PopularTwitterer;
import com.example.repository.TwittererRepository;

@Service
public class TwittererService {

                  // コンストラインインジェクション。final指定で変更不可
                  private final TwittererRepository twittererRepository;

                  @Autowired
                  public TwittererService(TwittererRepository twittererRepository) {
                                    this.twittererRepository = twittererRepository;
                  }

                  public List<PopularTwitterer> getTopTwitterers() {
                                    return twittererRepository.findPopularTwitterers();
                  }
}

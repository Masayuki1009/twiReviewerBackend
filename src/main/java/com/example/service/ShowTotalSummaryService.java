package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ReviewCategory;
import com.example.domain.ReviewCategoryAverageScoreList;
import com.example.domain.ServerConfig;
import com.example.dto.TotalSummary;
import com.example.repository.ReviewCategoryAverageScoreListRepository;
import com.example.repository.ReviewCategoryRepository;
import com.example.repository.ServerConfigRepository;
import com.example.repository.TwittererRepository;

@Service
public class ShowTotalSummaryService {
                  private final ReviewCategoryAverageScoreListRepository reviewCategoryAverageScoreListRepository;
                  private final ReviewCategoryRepository reviewCategoryRepository;
                  private final TwittererRepository twittererRepository;
                  private final ServerConfigRepository serverConfigRepository;

                  @Autowired
                  public ShowTotalSummaryService(ReviewCategoryAverageScoreListRepository reviewCategoryAverageScoreListRepository,
                                                      ReviewCategoryRepository reviewCategoryRepository,
                                                      TwittererRepository twittererRepository,
                                                      ServerConfigRepository serverConfigRepository) {
                                    this.reviewCategoryAverageScoreListRepository = reviewCategoryAverageScoreListRepository;
                                    this.reviewCategoryRepository = reviewCategoryRepository;
                                    this.twittererRepository = twittererRepository;
                                    this.serverConfigRepository = serverConfigRepository;
                  }

                  public TotalSummary findTotalSummary(String twittererId) {
                                    Integer id = Integer.parseInt(twittererId);

                                    List<ServerConfig> serverconfigDataList = serverConfigRepository
                                                                        .getServerConfigDataList();
                                    // 総合評価のカテゴリid
                                    Integer totalvalueCategoryId = Integer.parseInt(
                                                                        serverconfigDataList.get(0).getParameter());
                                    // チャート関連カテゴリのid最小値
                                    Integer firstChartCategoryId = Integer.parseInt(
                                                                        serverconfigDataList.get(1).getParameter());
                                    // チャート関連カテゴリのid最大値
                                    Integer lastChartCategoryId = Integer.parseInt(
                                                                        serverconfigDataList.get(2).getParameter());

                                    // 名前、総合評価取得、アカウント名取得
                                    TotalSummary totalSummary = twittererRepository.findTotalSummary(id,
                                                                        totalvalueCategoryId);

                                    // チャートに関連するカテゴリ名称取得
                                    List<ReviewCategory> reviewCategoryList = reviewCategoryRepository
                                                                        .findReviewCategoryName(firstChartCategoryId,
                                                                                                            lastChartCategoryId);
                                    // 各カテゴリの平均スコア取得
                                    List<ReviewCategoryAverageScoreList> reviewCategoryAverageScoreList = reviewCategoryAverageScoreListRepository
                                                                        .findReviewCategoryAverageScoreListRepository(
                                                                                                            id,
                                                                                                            firstChartCategoryId,
                                                                                                            lastChartCategoryId);

                                    totalSummary.setName(totalSummary.getName());
                                    totalSummary.setAccountId(totalSummary.getAccountId());
                                    totalSummary.setAverageTotalValue(totalSummary.getAverageTotalValue());
                                    totalSummary.setReviewCategoryNameList(reviewCategoryList);
                                    totalSummary.setReviewCategoryAverageScoreList(reviewCategoryAverageScoreList);
                                    return totalSummary;
                  }
}

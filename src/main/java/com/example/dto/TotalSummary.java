package com.example.dto;

import java.util.List;

import com.example.domain.ReviewCategory;
import com.example.domain.ReviewCategoryAverageScoreList;

public class TotalSummary {

                  // twitterer
                  private String name;
                  private String accountId;

                  // total_value 総合評価
                  private Double averageTotalValue;
                  private List<ReviewCategory> reviewCategoryNameList;
                  // 各カテゴリの平均点
                  private List<ReviewCategoryAverageScoreList> reviewCategoryAverageScoreList;

                  public String getName() {
                                    return name;
                  }

                  public void setName(String name) {
                                    this.name = name;
                  }

                  public String getAccountId() {
                                    return accountId;
                  }

                  public void setAccountId(String accountId) {
                                    this.accountId = accountId;
                  }

                  public Double getAverageTotalValue() {
                                    return averageTotalValue;
                  }

                  public void setAverageTotalValue(Double averageTotalValue) {
                                    this.averageTotalValue = averageTotalValue;
                  }

                  public List<ReviewCategory> getReviewCategoryNameList() {
                                    return reviewCategoryNameList;
                  }

                  public void setReviewCategoryNameList(List<ReviewCategory> reviewCategoryNameList) {
                                    this.reviewCategoryNameList = reviewCategoryNameList;
                  }

                  public List<ReviewCategoryAverageScoreList> getReviewCategoryAverageScoreList() {
                                    return reviewCategoryAverageScoreList;
                  }

                  public void setReviewCategoryAverageScoreList(
                                                      List<ReviewCategoryAverageScoreList> reviewCategoryAverageScoreList) {
                                    this.reviewCategoryAverageScoreList = reviewCategoryAverageScoreList;
                  }

                  @Override
                  public String toString() {
                                    return "TotalSummary [name=" + name + ", accountId=" + accountId
                                                                        + ", averageTotalValue=" + averageTotalValue
                                                                        + ", reviewCategoryNameList="
                                                                        + reviewCategoryNameList
                                                                        + ", reviewCategoryAverageScoreList="
                                                                        + reviewCategoryAverageScoreList + "]";
                  }

}

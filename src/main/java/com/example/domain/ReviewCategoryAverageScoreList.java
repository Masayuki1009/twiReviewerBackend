package com.example.domain;

public class ReviewCategoryAverageScoreList {
                  private Long id;
                  private Long reviewCategoryId;
                  private Long twittererId;
                  private Double averageScore;

                  // Getters and Setters
                  public Long getId() {
                                    return id;
                  }

                  public void setId(Long id) {
                                    this.id = id;
                  }

                  public Long getReviewCategoryId() {
                                    return reviewCategoryId;
                  }

                  public void setReviewCategoryId(Long reviewCategoryId) {
                                    this.reviewCategoryId = reviewCategoryId;
                  }

                  public Long getTwittererId() {
                                    return twittererId;
                  }

                  public void setTwittererId(Long twittererId) {
                                    this.twittererId = twittererId;
                  }

                  public Double getAverageScore() {
                                    return averageScore;
                  }

                  public void setAverageScore(Double averageScore) {
                                    this.averageScore = averageScore;
                  }
}

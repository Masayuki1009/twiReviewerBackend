package com.example.domain;

public class TotalReview {
                  private Long id;
                  private Long twittererId;
                  private Double averageTotalValue;
                  private Integer reviewCount;

                  // Getters and Setters
                  public Long getId() {
                                    return id;
                  }

                  public void setId(Long id) {
                                    this.id = id;
                  }

                  public Long getTwittererId() {
                                    return twittererId;
                  }

                  public void setTwittererId(Long twittererId) {
                                    this.twittererId = twittererId;
                  }

                  public Double getAverageTotalValue() {
                                    return averageTotalValue;
                  }

                  public void setAverageTotalValue(Double averageTotalValue) {
                                    this.averageTotalValue = averageTotalValue;
                  }

                  public Integer getReviewCount() {
                                    return reviewCount;
                  }

                  public void setReviewCount(Integer reviewCount) {
                                    this.reviewCount = reviewCount;
                  }
}

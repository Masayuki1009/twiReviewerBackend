package com.example.domain;

public class Review {
                  private Long id;
                  private Long twittererId;
                  private Long reviewCategoryId;
                  private int value;
                  private int reviewCount;

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

                  public Long getReviewCategoryId() {
                                    return reviewCategoryId;
                  }

                  public void setReviewCategoryId(Long reviewCategoryId) {
                                    this.reviewCategoryId = reviewCategoryId;
                  }

                  public int getValue() {
                                    return value;
                  }

                  public void setValue(int value) {
                                    this.value = value;
                  }

                  public int getReviewCount() {
                                    return reviewCount;
                  }

                  public void setReviewCount(int reviewCount) {
                                    this.reviewCount = reviewCount;
                  }
}

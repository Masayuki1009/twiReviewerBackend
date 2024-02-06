package com.example.domain;

public class TwittererCategoryList {
                  private Long id;
                  private Long twittererId;
                  private Long twittererCategoryId;
                  private String currentTopicYoutuber;

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

                  public Long getTwittererCategoryId() {
                                    return twittererCategoryId;
                  }

                  public void setTwittererCategoryId(Long twittererCategoryId) {
                                    this.twittererCategoryId = twittererCategoryId;
                  }

                  public String getCurrentTopicYoutuber() {
                                    return currentTopicYoutuber;
                  }

                  public void setCurrentTopicYoutuber(String currentTopicYoutuber) {
                                    this.currentTopicYoutuber = currentTopicYoutuber;
                  }
}

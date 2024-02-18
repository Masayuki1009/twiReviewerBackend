package com.example.domain;

import java.time.LocalDateTime;

public class Comment {
                  private Long id;
                  private Long twittererId;
                  private LocalDateTime postTime;
                  private String postedName;
                  private Integer humor;
                  private Integer tweetFrequency;
                  private Integer bussPower;
                  private Integer humanity;
                  private Integer originality;
                  private Integer totalScore;
                  private String comment;

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

                  public LocalDateTime getPostTime() {
                                    return postTime;
                  }

                  public void setPostTime(LocalDateTime postTime) {
                                    this.postTime = postTime;
                  }

                  public String getPostedName() {
                                    return postedName;
                  }

                  public void setPostedName(String postedName) {
                                    this.postedName = postedName;
                  }

                  public Integer getHumor() {
                                    return humor;
                  }

                  public void setHumor(Integer humor) {
                                    this.humor = humor;
                  }

                  public Integer getTweetFrequency() {
                                    return tweetFrequency;
                  }

                  public void setTweetFrequency(Integer tweetFrequency) {
                                    this.tweetFrequency = tweetFrequency;
                  }

                  public Integer getBussPower() {
                                    return bussPower;
                  }

                  public void setBussPower(Integer bussPower) {
                                    this.bussPower = bussPower;
                  }

                  public Integer getHumanity() {
                                    return humanity;
                  }

                  public void setHumanity(Integer humanity) {
                                    this.humanity = humanity;
                  }

                  public Integer getOriginality() {
                                    return originality;
                  }

                  public void setOriginality(Integer originality) {
                                    this.originality = originality;
                  }

                  public Integer getTotalScore() {
                                    return totalScore;
                  }

                  public void setTotalScore(Integer totalScore) {
                                    this.totalScore = totalScore;
                  }

                  public String getComment() {
                                    return comment;
                  }

                  public void setComment(String comment) {
                                    this.comment = comment;
                  }

}

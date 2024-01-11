package com.example.dto;

public class PopularTwitterer {
                  private String name;
                  private String accountId;
                  private String image;
                  private Double averageTotalValue;

                  // Getters
                  public String getName() {
                                    return name;
                  }

                  public String getAccountId() {
                                    return accountId;
                  }

                  public String getImage() {
                                    return image;
                  }

                  public Double getAverageTotalValue() {
                                    return averageTotalValue;
                  }

                  // Setters
                  public void setName(String name) {
                                    this.name = name;
                  }

                  public void setAccountId(String accountId) {
                                    this.accountId = accountId;
                  }

                  public void setImage(String image) {
                                    this.image = image;
                  }

                  public void setAverageTotalValue(Double averageTotalValue) {
                                    this.averageTotalValue = averageTotalValue;
                  }
}

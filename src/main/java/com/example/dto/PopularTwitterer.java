package com.example.dto;

public class PopularTwitterer {
                  private String id;
                  private String name;
                  private String accountId;
                  private String image;
                  private Double averageTotalValue;

                  public String getId() {
                                    return id;
                  }

                  public void setId(String id) {
                                    this.id = id;
                  }

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

                  @Override
                  public String toString() {
                                    return "PopularTwitterer [id=" + id + ", name=" + name + ", accountId=" + accountId
                                                                        + ", image=" + image + ", averageTotalValue="
                                                                        + averageTotalValue + "]";
                  }
}

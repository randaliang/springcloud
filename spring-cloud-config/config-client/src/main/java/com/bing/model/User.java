package com.bing.model;

import java.util.Date;

/**
 * Created by szt on 2016/11/18.
 */
public class User {
  private String id;
  private String name;
  private Date createdTime;

  public User() {
  }

  public User(String id, String name, Date createdTime) {
    this.id = id;
    this.name = name;
    this.createdTime = createdTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }
}

package com.example.swcoaching.member;

public class Member {
  private final Long id;
  private final String username;
  private final String password;
  private final String name;
  private final String remark;

  public Member(Long id, String username, String password, String name, String remark) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.remark = remark;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getRemark() {
    return remark;
  }
}
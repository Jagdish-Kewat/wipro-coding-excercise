package com.coding.test.domain;

public class Course {
  int id;
  String name;
  int duration;
  String durationType;
  int deleted;

  public int getDeleted() {
    return deleted;
  }

  public void setDeleted(int deleted) {
    this.deleted = deleted;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getDurationType() {
    return durationType;
  }

  public void setDurationType(String durationType) {
    this.durationType = durationType;
  }
}

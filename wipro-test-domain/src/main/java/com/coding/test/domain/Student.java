package com.coding.test.domain;

import java.util.List;

public class Student {
  int id;
  String name;
  List<Course> coursesList;
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
  public List<Course> getCourses() {
    return coursesList;
  }
  public void setCourses(List<Course> coursesList) {
    this.coursesList = coursesList;
  }
}

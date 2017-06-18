package com.coding.test.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universities")
public class UniversityEntity {
  @Id int id;
  int universityId;
  String name;
  @OneToMany @JoinColumn(name = "courseId", referencedColumnName = "id") 
  List<CourseEntity> courses;
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

  public int getUniversityId() {
    return universityId;
  }

  public void setUniversityId(int universityId) {
    this.universityId = universityId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CourseEntity> getCourses() {
    return courses;
  }

  public void setCourses(List<CourseEntity> courses) {
    this.courses = courses;
  }
}

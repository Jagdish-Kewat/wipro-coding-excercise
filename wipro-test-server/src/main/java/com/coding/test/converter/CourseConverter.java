package com.coding.test.converter;

import org.springframework.stereotype.Component;

import com.coding.test.domain.Course;
import com.coding.test.entity.CourseEntity;

@Component
public class CourseConverter {
  int id;
  String name;
  int duration;
  String durationType;

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

  public Course convert(CourseEntity entity) {
    Course course = new Course();

    course.setId(entity.getId());
    course.setName(entity.getName());
    course.setDeleted(entity.getDeleted());
    course.setDuration(entity.getDuration());
    course.setDurationType(entity.getDurationType());

    return course;
  }
}

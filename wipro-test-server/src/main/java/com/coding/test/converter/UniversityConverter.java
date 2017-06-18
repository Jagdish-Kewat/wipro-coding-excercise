package com.coding.test.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coding.test.domain.Course;
import com.coding.test.domain.University;
import com.coding.test.entity.CourseEntity;
import com.coding.test.entity.UniversityEntity;
import com.google.common.collect.Lists;

@Component
public class UniversityConverter {

  int id;
  String name;
  List<Course> courses;
  int deleted;

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
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public int getDeleted() {
    return deleted;
  }

  public void setDeleted(int deleted) {
    this.deleted = deleted;
  }

  public University convert(UniversityEntity entity) {
    University university = new University();
    university.setId(entity.getUniversityId());
    university.setName(entity.getName());
    populateCourses(university, entity);
    university.setDeleted(entity.getDeleted());
    return university;
  }

  private void populateCourses(University domain, UniversityEntity entity) {
    if (entity.getCourses() == null) {
      domain.setCourses(Lists.newArrayList());
      return;
    }

    for (CourseEntity courseEntity : entity.getCourses()) {
      Course courseDomain = new Course();

      courseDomain.setId(courseEntity.getId());
      courseDomain.setName(courseEntity.getName());
      courseDomain.setDuration(courseEntity.getDuration());
      courseDomain.setDurationType(courseEntity.getDurationType());
      courseDomain.setDeleted(courseEntity.getDeleted());

      domain.getCourses().add(courseDomain);
    }
  }
}

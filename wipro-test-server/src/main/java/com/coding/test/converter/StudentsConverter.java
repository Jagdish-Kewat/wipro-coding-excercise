package com.coding.test.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coding.test.domain.Course;
import com.coding.test.domain.Student;
import com.coding.test.entity.CourseEntity;
import com.coding.test.entity.StudentEntity;
import com.google.common.collect.Lists;

@Component
public class StudentsConverter {
  int id;
  String name;
  int deleted;
  List<Course> courses;

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

  public int getDeleted() {
    return deleted;
  }

  public void setDeleted(int deleted) {
    this.deleted = deleted;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public Student convert(StudentEntity entity) {
    Student student = new Student();

    student.setId(entity.getStudentId());
    student.setName(entity.getName());
    populateCourses(student, entity);
    student.setDeleted(entity.getDeleted());
    return student;
  }

  private void populateCourses(Student domain, StudentEntity entity) {
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

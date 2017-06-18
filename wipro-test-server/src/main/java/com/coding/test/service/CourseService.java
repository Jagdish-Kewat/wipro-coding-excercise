package com.coding.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.test.domain.Course;
import com.coding.test.entity.CourseEntity;
import com.coding.test.repository.CoursesRepository;

@Service
public class CourseService {
  @Autowired CoursesRepository courses;

  public CourseEntity getCourse(int id) {
    return courses.findOne(id);
  }

  public List<CourseEntity> getAllCourses(int id) {
    return (List<CourseEntity>) courses.findAll();
  }

  public void addCource(Course course) {
    CourseEntity entity = new CourseEntity();
    entity.setName(course.getName());
    entity.setDuration(course.getDuration());
    entity.setDurationType(course.getDurationType());

    courses.save(entity);
  }

  public void updateCourse(Course course) {
    CourseEntity entity = getCourse(course.getId());

    if (entity == null) {
      throw new RuntimeException(
          "The course '" + course.getName() + "' and ID '" + course.getId() + "' does not exist.");
    }

    entity.setName(course.getName());
    entity.setDuration(course.getDuration());
    entity.setDurationType(course.getDurationType());

    courses.save(entity);
  }

  public void deleteCourse(Course course) {
    CourseEntity entity = getCourse(course.getId());

    if (entity == null) {
      throw new RuntimeException(
          "The course '" + course.getName() + "' and ID '" + course.getId() + "' does not exist.");
    }

    // Soft delete
    entity.setDeleted(1);
    courses.save(entity);
  }
}

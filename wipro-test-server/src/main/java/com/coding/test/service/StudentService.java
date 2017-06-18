package com.coding.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.test.domain.Course;
import com.coding.test.domain.Student;
import com.coding.test.entity.CourseEntity;
import com.coding.test.entity.StudentEntity;
import com.coding.test.repository.StudentsRepository;
import com.google.common.collect.Lists;

@Service
public class StudentService {
  @Autowired StudentsRepository students;

  public StudentEntity getStudent(int id) {
    return students.findByStudentId(id);
  }

  public void addStudent(Student domain) {
    StudentEntity entity = new StudentEntity();
    entity.setName(domain.getName());

    populateStudentCourses(entity, domain);
    students.save(entity);
  }

  private void populateStudentCourses(StudentEntity entity, Student domain) {
    if (domain.getCourses() != null && !domain.getCourses().isEmpty()) {
      List<CourseEntity> courses = null;
      if (entity.getCourses() == null) {
        courses = Lists.newArrayList();
      } else {
        // This would be required while updating student.
        entity.getCourses().clear();
      }

      for (Course course : domain.getCourses()) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(course.getName());
        courseEntity.setDuration(course.getDuration());
        courseEntity.setDurationType(course.getDurationType());

        courses.add(courseEntity);
      }
      entity.setCourses(courses);
    }
  }

  public void updateStudent(Student domain) {
    StudentEntity entity = getStudent(domain.getId());

    if (entity == null) {
      throw new RuntimeException("The student with name '" + domain.getName() + "' and ID '"
          + domain.getId() + "' does not exist.");
    }

    entity.setName(domain.getName());
    populateStudentCourses(entity, domain);
    students.save(entity);
  }

  public void deleteStudent(Student domain) {
    StudentEntity entity = getStudent(domain.getId());

    if (entity == null) {
      throw new RuntimeException("The student with name '" + domain.getName() + "' and ID '"
          + domain.getId() + "' does not exist.");
    }

    // Soft delete
    entity.setDeleted(1);
    students.save(entity);
  }
}

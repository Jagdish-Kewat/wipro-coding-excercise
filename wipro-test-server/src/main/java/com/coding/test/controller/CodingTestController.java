package com.coding.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coding.test.converter.CourseConverter;
import com.coding.test.converter.StudentsConverter;
import com.coding.test.converter.UniversityConverter;
import com.coding.test.domain.Student;
import com.coding.test.service.CourseService;
import com.coding.test.service.StudentService;
import com.coding.test.service.UniversityService;

@RestController
@RequestMapping(path = "/codingTest")
public class CodingTestController {
  @Autowired StudentService studentService;
  @Autowired CourseService courseService;
  @Autowired UniversityService universityService;

  @Autowired StudentsConverter studentConverter;
  @Autowired CourseConverter courseConverter;
  @Autowired UniversityConverter universityConverter;

  @RequestMapping(path = "/students/{studentId}", method = RequestMethod.GET)
  public ResponseEntity<Student> getStudent(@PathVariable("studentId") int studentId) {
    return new ResponseEntity<Student>(
        studentConverter.convert(studentService.getStudent(studentId)), HttpStatus.OK);
  }

  @RequestMapping(path = "/students/add", method = RequestMethod.POST)
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @RequestMapping(path = "/students/update", method = RequestMethod.PUT)
  public void updateStudent(@RequestBody Student student) {
    studentService.updateStudent(student);
  }

  @RequestMapping(path = "/students/delete", method = RequestMethod.PUT)
  public void deleteStudent(@RequestBody Student student) {
    studentService.deleteStudent(student);
  }
}

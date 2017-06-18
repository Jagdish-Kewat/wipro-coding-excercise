package com.coding.test.client;

import com.coding.test.domain.Student;

import feign.Param;
import feign.RequestLine;

public interface CodingTestClient {

  @RequestLine("GET /codingtest/students/{studentId}")
  Student getStudent(@Param("studentId") String studentId);
  
  @RequestLine("POST /codingtest/students/add")
  void addStudent(Student student);
  
  @RequestLine("PUT /codingtest/students/update")
  void updateStudent(Student student);
  
  @RequestLine("PUT /codingtest/students/delete")
  void deleteStudent(Student student);
}

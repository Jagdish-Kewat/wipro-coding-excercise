package com.coding.test.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coding.test.entity.StudentEntity;

@Repository
public interface StudentsRepository
    extends CrudRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {

  public StudentEntity findByStudentId(@Param("studentId") int studentId);

}

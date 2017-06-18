package com.coding.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.test.entity.CourseEntity;

@Repository
public interface CoursesRepository extends CrudRepository<CourseEntity, Integer> {

}

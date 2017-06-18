package com.coding.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.coding.test.entity.StudentsEntity;

public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer>{

}

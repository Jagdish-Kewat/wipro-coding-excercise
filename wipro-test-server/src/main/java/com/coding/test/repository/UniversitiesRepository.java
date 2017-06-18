package com.coding.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.test.entity.UniversitiesEntity;

@Repository
public interface UniversitiesRepository extends CrudRepository<UniversitiesEntity, Integer>{

}

package com.coding.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coding.test.entity.UniversityEntity;

@Repository
public interface UniversitiesRepository extends CrudRepository<UniversityEntity, Integer> {
  public UniversityEntity findByUniversityId(@Param("universityId") int universityId);
}

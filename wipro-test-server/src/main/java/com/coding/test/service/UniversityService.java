package com.coding.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.test.domain.Course;
import com.coding.test.domain.University;
import com.coding.test.entity.CourseEntity;
import com.coding.test.entity.UniversityEntity;
import com.coding.test.repository.UniversitiesRepository;
import com.google.common.collect.Lists;

@Service
public class UniversityService {
  @Autowired UniversitiesRepository universities;
  
  public UniversityEntity getUniversity(int id){
    return universities.findByUniversityId(id);
  }
  
  public List<UniversityEntity> getAllUniversities(){
    return (List<UniversityEntity>) universities.findAll();
  }
  
  public void addUniversity(University domain){
    UniversityEntity entity = new UniversityEntity();
    entity.setName(domain.getName());
    populateCourses(entity, domain);
    universities.save(entity);
  }

  public void updateUniversity(University domain){
    UniversityEntity entity  =getUniversity(domain.getId());
    
    if(entity == null){
      throw new RuntimeException("The university '" + domain.getName() + "' and Id '" + domain.getId() + "' does not exist.");
    }
    
    entity.setName(domain.getName());
    populateCourses(entity, domain);
    universities.save(entity);
  }
  
  public void deleteUniversity(University domain){
    UniversityEntity entity  =getUniversity(domain.getId());
    
    if(entity == null){
      throw new RuntimeException("The university '" + domain.getName() + "' and Id '" + domain.getId() + "' does not exist.");
    }

    // Soft delete
    entity.setDeleted(1);
    universities.save(entity);
  }
  
  private void populateCourses(UniversityEntity entity, University domain) {
    List<CourseEntity> courses = null;
    if(entity.getCourses() == null){
      courses = Lists.newArrayList();
    } else {
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

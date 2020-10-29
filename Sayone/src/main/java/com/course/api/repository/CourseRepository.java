package com.course.api.repository;

import com.course.api.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseRepository extends CrudRepository<Course, Integer>, JpaSpecificationExecutor {



}

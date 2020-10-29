package com.course.api.repository;

import com.course.api.model.Course;
import com.course.api.model.CourseSubscription;
import com.course.api.model.Subscription;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseSubscriptionReposistory extends CrudRepository<CourseSubscription, Integer>, JpaSpecificationExecutor {

    @Query("Select cs.subscription_id FROM CourseSubscription cs where cs.course_id.course_id = :course_id")
    public List<Subscription> getCourseSubscriptionByCourseId(@Param("course_id") int course_id);


}

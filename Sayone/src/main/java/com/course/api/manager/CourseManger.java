package com.course.api.manager;

import com.course.api.dto.CourseDto;

public interface CourseManger {
    public CourseDto getCourseDetails(Integer courseId, String countryCode);


}

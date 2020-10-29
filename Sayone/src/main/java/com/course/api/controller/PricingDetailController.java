package com.course.api.controller;

import com.course.api.dto.CourseDto;
import com.course.api.manager.CourseManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/sayone/service/courses")
public class PricingDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PricingDetailController.class);

    @Autowired
    CourseManger courseManger;

    private String methodprfx = "PricingDetailController>>>";

    @RequestMapping(value = "/getCourseList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCourseDetails(@RequestParam(value = "courseId") Integer courseId,
                                       @RequestParam(value = "countryCode") String countryCode) {

        LOGGER.info("Inside PricingDetailController::PricingDetailController");
        CourseDto courseDto=courseManger.getCourseDetails(courseId,countryCode);
        return new ResponseEntity(courseDto, HttpStatus.OK);

    }

}

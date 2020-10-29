package com.course.api.manager.impl;

import com.course.api.dto.CourseDto;
import com.course.api.dto.SubscriptionDto;
import com.course.api.dto.TaxDto;
import com.course.api.exception.EntityNotFoundExceptionHandler;
import com.course.api.exception.HandleUnexpectedException;
import com.course.api.manager.CourseManger;
import com.course.api.model.Course;
import com.course.api.model.Subscription;
import com.course.api.model.Tax;
import com.course.api.repository.CountryTaxRepository;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.CourseSubscriptionReposistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CourseMangerImpl implements CourseManger {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseSubscriptionReposistory courseSubscriptionReposistory;

    @Autowired
    CountryTaxRepository countryTaxRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(CourseMangerImpl.class);

    @Override
    public CourseDto getCourseDetails(Integer courseId, String countryCode) {
        try {
            Optional<Course> coursesData = courseRepository.findById(courseId);
            if(coursesData.isPresent()) {
                CourseDto courseDto = new CourseDto();
                courseDto.setCourse_code(coursesData.get().getCourse_code());
                courseDto.setCourse_description(coursesData.get().getCourse_description());
                courseDto.setCourse_name(coursesData.get().getCourse_name());
                courseDto.setCourse_id(coursesData.get().getCourse_id());
                courseDto.setNet_price(coursesData.get().getNet_price());

                List<Subscription> subscriptions = courseSubscriptionReposistory.getCourseSubscriptionByCourseId(courseId);
                Tax countrytax = countryTaxRepository.getTaxByCountryId(countryCode);

                if (subscriptions.size() > 0) {
                    courseDto.setSubscription(subscriptions.stream().map(e -> {
                        SubscriptionDto subscriptionDto = new SubscriptionDto();
                        subscriptionDto.setSubscription_id(e.getSubscription_id());
                        subscriptionDto.setSubscription_duration(e.getSubscription_duration());
                        subscriptionDto.setSubscription_type(e.getSubscription_type());
                        return subscriptionDto;
                    }).collect(Collectors.toList()));
                }
                if (countrytax != null) {
                    TaxDto taxDto = new TaxDto();
                    taxDto.setTax_code(countrytax.getTax_code());
                    taxDto.setTax_id(countrytax.getTax_id());
                    taxDto.setTax_value(countrytax.getTax_value());
                    courseDto.setTax(taxDto);
                }
                return courseDto;
            }else{
                throw new EntityNotFoundExceptionHandler("No course details found on given id");
            }

        }catch (Exception e){
            LOGGER.error("Exception occurred",e);
            throw new HandleUnexpectedException(e.getMessage());
        }
    }
}

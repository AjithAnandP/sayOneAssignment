package com.course.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private int course_id;

    private String course_description;

    private String course_name;

    private int course_code;

    private float net_price;

    private List<SubscriptionDto> subscription;

    private TaxDto tax;


}


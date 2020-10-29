package com.course.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
public class SubscriptionDto {

    private int subscription_id;

    private String subscription_type;

    private String subscription_duration;


}


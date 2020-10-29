package com.course.api.dto;

import lombok.Data;

@Data
public class ErrorDto {
    int code;
    String error;
}

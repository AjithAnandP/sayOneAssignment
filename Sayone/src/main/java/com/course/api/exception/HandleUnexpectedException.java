package com.course.api.exception;

public class HandleUnexpectedException extends RuntimeException{
    private static final long serialVersionUID = -196463511582289325L;

    public HandleUnexpectedException(String msg) {
        super(msg);
    }
}

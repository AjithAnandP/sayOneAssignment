package com.course.api.exception;

/**
 * Unauthorized access exception
 * 
 * @author jpatel
 * 
 */
public class UnauthorizedAccessException extends RuntimeException {

  private static final long serialVersionUID = -196463511582289325L;

  public UnauthorizedAccessException(String msg) {
    super(msg);
  }

}

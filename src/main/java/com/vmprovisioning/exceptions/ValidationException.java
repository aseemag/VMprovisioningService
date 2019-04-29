package com.vmprovisioning.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
	
	 public ValidationException(String message) {
	        super(message);
	    }

}

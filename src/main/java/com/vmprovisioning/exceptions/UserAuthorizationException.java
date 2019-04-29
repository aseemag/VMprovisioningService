package com.vmprovisioning.exceptions;

import org.springframework.http.HttpStatus;

public class UserAuthorizationException extends RuntimeException {
	public static  HttpStatus httpStatus=HttpStatus.FORBIDDEN;
	
	public UserAuthorizationException(String message)
	{
		super(message);
	}

}

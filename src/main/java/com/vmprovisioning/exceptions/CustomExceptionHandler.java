package com.vmprovisioning.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vmprovisioning.dto.ResponseDTO;




@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(value=ValidationException.class)
	    public final ResponseEntity<Object> invalidParamsException(ValidationException ex, WebRequest request) {
	       ResponseDTO response=new ResponseDTO();
	       response.setErrorMessage(ex.getMessage());
	       response.setSuccess(false);
	       response.setErrorCode(ex.httpStatus.value());
	        return new ResponseEntity(response,ex.httpStatus);
	    }
	 
	 @ExceptionHandler(value=UserAuthorizationException.class)
	    public final ResponseEntity<Object> invalidUserException(UserAuthorizationException ex, WebRequest request) {
	       ResponseDTO response=new ResponseDTO();
	       response.setErrorMessage(ex.getMessage());
	       response.setSuccess(false);
	       response.setErrorCode(ex.httpStatus.value());
	        return new ResponseEntity(response,ex.httpStatus);
	    }
	 
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ResponseDTO response=new ResponseDTO();
	       response.setErrorMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	       response.setSuccess(false);
	       response.setErrorCode(HttpStatus.BAD_REQUEST.value());
	        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);

	    }

}

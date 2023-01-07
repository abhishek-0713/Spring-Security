package com.blackcoffer.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	/*---------------------------------------   Login Exception -------------------------------------------*/	

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException loginException, WebRequest webRequest) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setDetails(webRequest.getDescription(false));
		myErrorDetails.setErrorMsg(loginException.getMessage());
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	/*---------------------------------------   Course Exception -------------------------------------------*/	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> handleCustomerException(CourseException courseException, WebRequest webRequest) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setDetails(webRequest.getDescription(false));
		myErrorDetails.setErrorMsg(courseException.getMessage());
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	
	/*---------------------------------------   Student Exception -------------------------------------------*/	

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> productExceptionHandler(StudentException studentException, WebRequest webRequest){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setDetails(webRequest.getDescription(false));
		myErrorDetails.setErrorMsg(studentException.getMessage());
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	/*---------------------------------------   Exception -------------------------------------------*/	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> handleAllException(Exception exception, WebRequest webRequest) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setDetails(webRequest.getDescription(false));
		myErrorDetails.setErrorMsg(exception.getMessage());
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}

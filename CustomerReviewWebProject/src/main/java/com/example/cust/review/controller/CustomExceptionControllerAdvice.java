package com.example.cust.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cust.review.exception.CommentNotAllowedToAdd;
import com.example.cust.review.exception.ErrorResponse;
import com.example.cust.review.exception.RatingNotAllowed;

/**
 * Controller Advice to handle the custom exceptions in the project
 *
 */
@ControllerAdvice
public class CustomExceptionControllerAdvice {

	@ExceptionHandler(CommentNotAllowedToAdd.class)
	public ResponseEntity<ErrorResponse> exceptionHandlerForComments(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("1");
		error.setErrorMessage("Curse words are not allowed in to be added in comments. Please try again.");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(RatingNotAllowed.class)
	public ResponseEntity<ErrorResponse> exceptionHandlerForRating(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("2");
		error.setErrorMessage("Rating less than 0 is not allowed. Please try again.");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
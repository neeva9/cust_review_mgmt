package com.example.cust.review.exception;

//@ResponseStatus(value=HttpStatus.OK,reason="This customer is not found in the system")
public class CommentNotAllowedToAdd extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CommentNotAllowedToAdd(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public CommentNotAllowedToAdd() {
		super();
	}
}
package com.myshop.exception;

public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -4154911374002178446L;

	public NotFoundException(String message) {
		super(message);
	}
}

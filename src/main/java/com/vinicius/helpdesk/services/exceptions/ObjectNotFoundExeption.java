package com.vinicius.helpdesk.services.exceptions;

public class ObjectNotFoundExeption extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundExeption(String message) {
		super(message);
	}
	
	
    
}

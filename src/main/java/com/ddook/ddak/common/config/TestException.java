package com.ddook.ddak.common.config;

public class TestException extends RuntimeException {
	private static final long serialVersionUID = -8602905008569855730L;
	
	public TestException(Exception cause){
		super(cause);
	}
	
	public TestException(String message){
		super(message);
	}
	
	public TestException(String message, Throwable cause){
		super(message, cause);
	}

} 

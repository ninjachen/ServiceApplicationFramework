package com.wonders.frame.exception;

public class NonLoginedException extends RuntimeException {

	private static final long serialVersionUID = 1093850689983064383L;

	public NonLoginedException() {
		super();
	}
	
	public NonLoginedException(String msg) {
		super(msg);
	}
}

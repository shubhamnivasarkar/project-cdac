package com.app.custom_excs;

public class CustomerHandlingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerHandlingException(String errMesg) {
		super(errMesg);
	}

}

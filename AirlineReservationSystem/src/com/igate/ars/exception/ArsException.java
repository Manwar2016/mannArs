package com.igate.ars.exception;

public class ArsException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	public ArsException(){}
	public ArsException(String errorMsg)
	{
		super(errorMsg);
	}

}

package com.cognixia.jump.tcg.exceptions;

public class ResourceAlreadyExistException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException()
	{
		super();
	}
	
	public ResourceAlreadyExistException(String s)
	{
		super(s);
	}
}

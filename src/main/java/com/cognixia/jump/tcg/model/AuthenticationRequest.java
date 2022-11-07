package com.cognixia.jump.tcg.model;

import java.io.Serializable;

//model object used to send username and password when a user tries to Authenticate and needs to crate a JWT thus NOT AN ENTITY
public class AuthenticationRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public AuthenticationRequest()
	{
		
	}
	
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPasswood(String passwood) {
		this.password = passwood;
	}
}

package com.cognixia.jump.tcg.model;

import java.io.Serializable;

//response objects for when we authenticate and return the jwt
public class AuthenticationResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jwt;

	public AuthenticationResponse(String jWt) {
		super();
		this.jwt = jWt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	
	
	
}

package com.igate.ars.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



public class LoginDTO {

	@Pattern(regexp="^[A-Z][a-z]+{4,20}" , message="Invalid Username/Password")
	private String userName;
	@Pattern(regexp="^[a-zA-Z0-9_@#$%^&*()!]{4,12}", message="Invalid Username/Password")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

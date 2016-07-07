package com.igate.ars.dto;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {

  private String userId;
  @Pattern(regexp="[a-zA-Z]{5,20}",message="Name field should contain atleast 5 characters")
  private String userName;
  @NotEmpty(message="Please enter your password")
  @Pattern(regexp="^[a-zA-Z0-9_@#$%^&*()!]{8,12}", message="Password field should contain at least 8 alphanumeric characters")
  private String password;
  private String confirmPassword;
  private String role; 
  @Pattern(regexp="^[0-9]{10}", message="Please enter 10 digit mobile number")
  private String mobileNo;
  
  private boolean userStatus;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public boolean isUserStatus() {
	return userStatus;
}
public void setUserStatus(boolean userStatus) {
	this.userStatus = userStatus;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

  

	
}

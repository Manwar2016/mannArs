package com.igate.ars.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class PassengerDTO {

	private int passengerId;
	@NotEmpty(message="Please Enter first name")
	@Pattern(regexp="[A-Z][a-zA-Z]{2,30}", message="first name should not contain special character and digit")
	private String firstName;
	@NotEmpty(message="Please Enter last name")
	@Pattern(regexp="[A-Z][a-zA-Z]{2,30}", message="last name should not contain special character and digit")
	private String lastName;
	@NotEmpty(message="Please Enter mobile number")
	@Pattern(regexp="^[0-9]{10}", message="mobile number should contain 10 digits")
	private String mobileNo;
	@Email(message="Please enter your emailId")
	private String emailId;
	@NotEmpty(message="Please Select gender")
	private String gender;
	
	private String bookingId;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

package com.igate.ars.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CreditCardDTO {

	//@NotEmpty(message="Please enter the card number")
	//@Pattern(regexp="[0-9]{16}",message="only digits are allowed not more then 16")
	private String cardNumber;
	//@NotEmpty(message="Please select the card type")
	private String cardType;
	//@NotEmpty(message="Please enter the card holder name")
	//@Pattern(regexp="^[A-Z][a-z]{20}",message="First character of name should be in upper case , no special charaters and digit are allowed")
	private String cardHolder;
	//@NotEmpty(message="Please enter the card expiry date")
	//@DateTimeFormat(pattern="dd/mm/yyyy")
	//@Past(message="your card is expired")
	private Date expiryDate;
	//@NotEmpty(message="Cvv cannot be empty")
	//@Pattern(regexp="^[0-9]{3}",message="cvv must be 3 digits only")
	private String cvv;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	
	
}

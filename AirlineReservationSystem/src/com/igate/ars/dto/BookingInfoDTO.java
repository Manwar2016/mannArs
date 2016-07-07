package com.igate.ars.dto;



import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BookingInfoDTO {

	private String 	bookingId;
	private String flightNo;
	private String arrivalCity;
	private String departureCity;
	private String customerEmail;
	private String numPassengers;
	private double totalFare;
	private String pessangerId;
	private Date departureDate;
	private Date arrivalDate;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(String numPassengers) {
		this.numPassengers = numPassengers;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getPessangerId() {
		return pessangerId;
	}
	public void setPessangerId(String pessangerId) {
		this.pessangerId = pessangerId;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "BookingInfoDTO [bookingId=" + bookingId + ", flightNo="
				+ flightNo + ", arrivalCity=" + arrivalCity
				+ ", departureCity=" + departureCity + ", customerEmail="
				+ customerEmail + ", numPassengers=" + numPassengers
				+ ", totalFare=" + totalFare + ", pessangerId=" + pessangerId
				+ ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + "]";
	}
	
	
	
	
	
	
}

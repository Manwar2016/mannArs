package com.igate.ars.dto;

public class SeatInfoDTO {

	private String bookingId;
	private String passengersId;
	private int seatNo;
	private String flightNo;
	private String classType;
	
	
	
	public String getPassengersId() {
		return passengersId;
	}
	public void setPassengersId(String passengersId) {
		this.passengersId = passengersId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	

}

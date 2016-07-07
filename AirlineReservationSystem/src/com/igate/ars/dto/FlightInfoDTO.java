package com.igate.ars.dto;

import java.util.Date;



import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class FlightInfoDTO {
   
	
	private String flightNo;
	private int airportid;
	
	@NotEmpty(message="Please enter the Airline Name")
	@Size(max=15,min=4,message="Airline name should not be less than 4 characters and not more than 15 Characters")
	@Pattern(regexp="^[a-zA-Z]+",message="Airline Name should  only be in alphabets")
	private String airline;
	
	@NotEmpty(message="Please select the departure airport")
	private String departureAirportId;
	
	@NotEmpty(message="Please select the arrival airport")
	private String arrivalAirportId;
	
	@NotNull(message="Please enter departure date")
	//@Future(message="Departure date can not be past date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="Departure date should be in format(yyyy-mm-dd)")
	private Date departureDate;
	

	@NotNull(message="Please enter the arrival date ")
	@Future(message="Arrival date can not be past date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="Arrival date should be in format(yyyy-mm-dd)")
	private Date arrivalDate;
	
	@NotEmpty(message="Please enter the departure time ")
	@Pattern(regexp="[0-9]{2}\\:[0-9]{2}", message="Please enter time in 'hh:mm' format")
	private String  departureTime;
	
	@NotEmpty(message="Please enter the arrival time ")
	@DateTimeFormat(pattern="hh:mm")
	private String arrivalTime;
	
	@NotNull(message="Please enter the no. of First Class Seats")
	private int firstSeats;
	
	@NotNull(message="First class fare can not be empty")
	private double firstSeatFare;
	
	@NotNull(message="Please enter the no. of Business Class Seats")
	private int businessSeats;

	@NotNull(message="First class fare can not be empty")
	private double  businessSeatFare;
	
	//@NotEmpty(message="Class Type cannot be empty")
	private String classType;
	
	//@NotNull(message="Please select the number of passengers")
	private int numPassengers;
	
	private String arrivalCity;
	private String departureCity;
	
	public int getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public int getAirportid() {
		return airportid;
	}
	public void setAirportid(int airportid) {
		this.airportid = airportid;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	public String getDepartureAirportId() {
		return departureAirportId;
	}
	public void setDepartureAirportId(String departureAirportId) {
		this.departureAirportId = departureAirportId;
	}
	public String getArrivalAirportId() {
		return arrivalAirportId;
	}
	public void setArrivalAirportId(String arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
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
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}
	public double getFirstSeatFare() {
		return firstSeatFare;
	}
	public void setFirstSeatFare(double firstSeatFare) {
		this.firstSeatFare = firstSeatFare;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}
	public double getBusinessSeatFare() {
		return businessSeatFare;
	}
	public void setBusinessSeatFare(double businessSeatFare) {
		this.businessSeatFare = businessSeatFare;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
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
	@Override
	public String toString() {
		return "FlightInfoDTO [flightNo=" + flightNo + ", airportid="
				+ airportid + ", airline=" + airline + ", departureAirportId="
				+ departureAirportId + ", arrivalAirportId=" + arrivalAirportId
				+ ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", firstSeats=" + firstSeats
				+ ", firstSeatFare=" + firstSeatFare + ", bussinessSeats="
				+ businessSeats + ", bussinessSeatFare=" + businessSeatFare
				+ ", classType=" + classType + ", numPassengers="
				+ numPassengers + "]";
	}
	
	
}

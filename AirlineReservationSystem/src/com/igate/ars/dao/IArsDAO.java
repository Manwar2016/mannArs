package com.igate.ars.dao;

import java.util.Date;
import java.util.List;

import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.FlightInfoDTO;
import com.igate.ars.dto.PassengerDTO;
import com.igate.ars.dto.SeatInfoDTO;
import com.igate.ars.dto.UserDTO;
public interface IArsDAO {

	UserDTO isValidLogin(UserDTO user);
	int addUser(UserDTO user);
	List<AirportDTO> getAirport();
	int addFlightInfo(FlightInfoDTO flightInfoDTO);
	List<FlightInfoDTO> getFlightNumbers();
	List<FlightInfoDTO> getFlightInfoList(String flightNo);
	FlightInfoDTO getFlightInfo(String flightNo);
	int updateFlightInfo(FlightInfoDTO flightInfoDTO);
	List<FlightInfoDTO> getFlightInfoList(Date departureDate);
	int cancelFlight(String flightNo);
	boolean isValidForCancelFlight(String flightNo);

	/*Himshikha Das*/
	List<PassengerDTO> retrievePassengersList (String flightNo);
	List<BookingInfoDTO> retrieveBookingList (String flightNo);
	List<FlightInfoDTO> retrieveFlightList(String departureAirportId,Date departureDate);



	/* Rajdeep Saha*/
	public List<PassengerDTO> loadBookingList(int bookingId);
	public PassengerDTO getBookingList(int passengerId);
	public int updateBooking(PassengerDTO passenger);
	public List<BookingInfoDTO> viewBookings(String userID);
	public BookingInfoDTO viewDeleteBookings(int bookingId);
	public int deleteBooking(int bookingId);


	//reservation module
	List<AirportDTO> getAirportInfo();
	List<FlightInfoDTO> getFlights(FlightInfoDTO findFlightsInfoDTO);
	int getAvailableSeats(int flightNo,String classType);
	int blockSeats(List<SeatInfoDTO> seatInfoList,int flightNo, 
			String classType,int numPassengers);
	boolean bookSeatsTransaction(List<PassengerDTO> passengerList, 
			FlightInfoDTO flightInfoDTO, List<SeatInfoDTO> seatInfoList, 
			BookingInfoDTO bookingInfoDTO,String userId);
	FlightInfoDTO getFlightInfo(Integer flightNo);
	double getSeatFare(int flightNo, String classType);

}

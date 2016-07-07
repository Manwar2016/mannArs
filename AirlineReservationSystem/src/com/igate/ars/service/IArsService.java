package com.igate.ars.service;

import java.util.Date;
import java.util.List;

import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.FlightInfoDTO;
import com.igate.ars.dto.PassengerDTO;
import com.igate.ars.dto.SeatInfoDTO;
import com.igate.ars.dto.UserDTO;

public interface IArsService {

	public UserDTO isValidLogin(UserDTO user) ;
	public int addUser(UserDTO user) ;
	public List<AirportDTO> getAirport() ;
	public int addFlightInfo(FlightInfoDTO flightInfoDTO) ;
	public List<FlightInfoDTO> getFlightNumbers() ;
	public List<FlightInfoDTO> getFlightInfoList(String flightNo) ;
	public FlightInfoDTO getFlightInfo(String flightNo) ;
	public int updateFlightInfo(FlightInfoDTO flightInfoDTO) ;
	public List<FlightInfoDTO> getFlightInfoList(Date departureDate) ;
	public int cancelFlight(String flightNo) ;
	public  List<FlightInfoDTO> retrieveFlightList(String departureAirportId,Date departureDate)  ;
	public List<PassengerDTO> retrievePassengersList (String flightNo);
	public List<BookingInfoDTO> retrieveBookingList (String flightNo);
	public List<PassengerDTO> loadBookingList(int bookingId);
	public PassengerDTO getBookingList(int passengerId);
	public int updateBooking(PassengerDTO passenger);
	public List<BookingInfoDTO> getBookings(String userID);
	public BookingInfoDTO viewDeleteBooking(int bookingId);
	public int deleteBooking(int passengerId);
	public List<AirportDTO> getAirportInfo();
	public List<FlightInfoDTO> findFlights(FlightInfoDTO findFlightsInfoDTO);
	public boolean checkSeatAvailability(int flightNo,String classType,int numPassengers);
	public int blockSeats(List<SeatInfoDTO> seatInfoList,int flightNo, String classType,int numPassengers);
	FlightInfoDTO getFlightInfo(Integer flightNo);
	public boolean bookSeatsTransaction(List<PassengerDTO> passengerList,FlightInfoDTO flightInfoDTO, List<SeatInfoDTO> seatInfoList, 
			BookingInfoDTO bookingInfoDTO, String userId);
	public double getTotalFare(int numPassengers, int flightNo, String classType);
	public int getAvailableSeats(int flightNo, String classType);
}

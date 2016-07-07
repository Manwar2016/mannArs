package com.igate.ars.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igate.ars.dao.IArsDAO;
import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.FlightInfoDTO;
import com.igate.ars.dto.PassengerDTO;
import com.igate.ars.dto.SeatInfoDTO;
import com.igate.ars.dto.UserDTO;
@Service
public class ArsServiceImpl implements IArsService {

	@Autowired
	IArsDAO arsDaoImpl;



	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	isValidLogin()
		 - Input Parameters	:	UserDTO user
		 - Return Type		:	UserDTO
		 - Throws			:  	ArsException
		 - Author			:	Manwar Singh
		 - Creation Date	:	10/09/2015
		 - Description		:	Validation of login deatails 
	 ********************************************************************************************************/

	@Override
	public UserDTO isValidLogin(UserDTO user)  {
			user = arsDaoImpl.isValidLogin(user);
		return user;
	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
	 - Function Name	:	addUser()
	 - Input Parameters	:	UserDTO user
	 - Return Type		:	int
	 - Throws			:  	ArsException
	 - Author			:	Manwar Singh
	 - Creation Date	:	10/09/2015
	 - Description		:	Validation of login deatails 
	 ********************************************************************************************************/
	@Override
	public int addUser(UserDTO user)  {
		int count=0;
		
			count = arsDaoImpl.addUser(user);
		return count;
	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	getAirport()
		 - Input Parameters	:	
		 - Return Type		:	List<AirportDTO>
		 - Throws			:  	ArsException
		 - Author			:	Manwar Singh
		 - Creation Date	:	10/09/2015
		 - Description		:	get the list of airport
	 ********************************************************************************************************/

	@Override
	public List<AirportDTO> getAirport()  {
		List<AirportDTO> airportList = new ArrayList<AirportDTO>();
			airportList = arsDaoImpl.getAirport();
		return airportList;
	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	addFlightInfo()
			 - Input Parameters	:	FlightInfoDTO flightInfoDTO
			 - Return Type		:	int
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	add the flight Information into database
	 ********************************************************************************************************/

	@Override
	public int addFlightInfo(FlightInfoDTO flightInfoDTO)  {
		int count=0;
			count = arsDaoImpl.addFlightInfo(flightInfoDTO);
		return count;
	}

	/*******************************************************************************************************
	 - Function Name	:	getFlightNumbers()
	 - Input Parameters	:	 
	 - Return Type		:	List<FlightInfoDTO>
	 - Throws			:  	ArsException
	 - Author			:	RAJDEEP SAHA
	 - Creation Date	:	10/09/2015
	 - Description		:	get all the flight numbers from  the database
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlightNumbers()  {
		List<FlightInfoDTO> flightNumbersList = new ArrayList<FlightInfoDTO>();
		flightNumbersList = arsDaoImpl.getFlightNumbers();
		return flightNumbersList;
	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	getFlightInfo()
			 - Input Parameters	:	flightNo
			 - Return Type		:	FlightInfoDTO
			 - Throws			:  	ArsException
			 - Author			:	RAJDEEP SAHA
			 - Creation Date	:	10/09/2015
			 - Description		:	get the flight details based on the flight number from  the database
	 ********************************************************************************************************/

	@Override
	public List<FlightInfoDTO> getFlightInfoList(String flightNo)  {
		List<FlightInfoDTO> flightInfoList = new ArrayList<FlightInfoDTO>();
		flightInfoList = arsDaoImpl.getFlightInfoList(flightNo);
		return flightInfoList;
	}




	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
	 - Function Name	:	getFlightInfo()
	 - Input Parameters	:	flightNo
	 - Return Type		:	FlightInfoDTO
	 - Throws			:  	ArsException
	 - Author			:	RAJDEEP SAHA
	 - Creation Date	:	10/09/2015
	 - Description		:	get the flight details based on the flight number from  the database
	 ********************************************************************************************************/
	@Override
	public FlightInfoDTO getFlightInfo(String flightNo)
			 {
		FlightInfoDTO flightInfoDTO= new FlightInfoDTO();
		flightInfoDTO = arsDaoImpl.getFlightInfo(flightNo);
		return flightInfoDTO;
	}
	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	updateFlightInfo()
			 - Input Parameters	:	FlightInfoDTO flightInfoDTO
			 - Return Type		:	count
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	get the flight details based on the flight number from  the database
	 ********************************************************************************************************/

	@Override
	public int updateFlightInfo(FlightInfoDTO flightInfoDTO)
			 {
		int count=0;
		count = arsDaoImpl.updateFlightInfo(flightInfoDTO);
		return count;
	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	getFlightInfo()
		 - Input Parameters	:	Date departureDate
		 - Return Type		:	FlightInfoDTO
		 - Throws			:  	ArsException
		 - Author			:	RAJDEEP SAHA
		 - Creation Date	:	10/09/2015
		 - Description		:	get the flight details based on the departure date from  the database
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlightInfoList(Date departureDate)
			 {
		List<FlightInfoDTO> flightInfoList = new ArrayList<FlightInfoDTO>();
		flightInfoList = arsDaoImpl.getFlightInfoList(departureDate);
		return flightInfoList;
	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	cancelFlight()
			 - Input Parameters	:	String flightNo
			 - Return Type		:	int
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	cancel the flight  based on the flight number date from  the database
	 ********************************************************************************************************/
	@Override
	public int cancelFlight(String flightNo)  {
		int count=0;
		count = arsDaoImpl.cancelFlight(flightNo);
		return count;
	}

	
	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	 retrieveFlightList()
			 - Input Parameters	:	String departureAirportId,Date departureDate
			 - Return Type		:	List
			 - Throws			:  	ArsException
			 - Author			:	hIMSHIKHA dAS
			 - Creation Date	:	10/09/2015
			 - Description		:	get the flight details based on departure date and departure city
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> retrieveFlightList(String departureAirportId,Date departureDate)  
	{
		List<FlightInfoDTO> allFlightList=arsDaoImpl.retrieveFlightList(departureAirportId,departureDate);
		return allFlightList;
	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	 retrievePassengersList()
			 - Input Parameters	:	String flightNo
			 - Return Type		:	List
			 - Throws			:  	ArsException
			 - Author			:	Himshikha Das
			 - Creation Date	:	10/09/2015
			 - Description		:	get the passenger details based on specific flight id
	 ********************************************************************************************************/


	@Override
	public List<PassengerDTO> retrievePassengersList(String flightNo)
			 {
		List<PassengerDTO> allPassengersList=arsDaoImpl.retrievePassengersList(flightNo);
		return allPassengersList;
	}
	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
	 - Function Name	:	 retrieveBookingList()
	 - Input Parameters	:	String flightNo
	 - Return Type		:	List
	 - Throws			:  	ArsException
	 - Author			:	Himshikha Das
	 - Creation Date	:	10/09/2015
	 - Description		:	get the booking details based on specific flight id
	 ********************************************************************************************************/

	@Override
	public List<BookingInfoDTO> retrieveBookingList(String flightNo)
			 {
		List<BookingInfoDTO> viewBookingList=arsDaoImpl.retrieveBookingList(flightNo);
		return viewBookingList;
	}



	public List<PassengerDTO> loadBookingList(int bookingId){

		return arsDaoImpl.loadBookingList(bookingId);

	}


	public PassengerDTO getBookingList(int passengerId){

		return arsDaoImpl.getBookingList(passengerId);

	}

	public int updateBooking(PassengerDTO passenger){

		return arsDaoImpl.updateBooking(passenger);

	}


	public List<BookingInfoDTO> getBookings(String userID){

		return arsDaoImpl.viewBookings(userID);

	}

	public BookingInfoDTO viewDeleteBooking(int bookingId){


		return arsDaoImpl.viewDeleteBookings(bookingId);
	}


	public int deleteBooking(int passengerId){

		return arsDaoImpl.deleteBooking(passengerId);

	}

	//------------------------ Reservation Module--------------------------
	@Override
	public List<AirportDTO> getAirportInfo() {
		return arsDaoImpl.getAirportInfo();
	}

	@Override
	public List<FlightInfoDTO> findFlights(FlightInfoDTO findFlightsInfoDTO) {
		return arsDaoImpl.getFlights(findFlightsInfoDTO);
	}

	@Override
	public boolean checkSeatAvailability(int flightNo,String classType, int numPassengers)
	{
		boolean isSeatAvailable = false;
		if( arsDaoImpl.getAvailableSeats(flightNo,classType) >= numPassengers){
			isSeatAvailable = true;
		}
		return isSeatAvailable;
	}

	@Override
	public int blockSeats(List<SeatInfoDTO> seatInfoList,int flightNo, String classType, int numPassengers)
	{
		return arsDaoImpl.blockSeats(seatInfoList,flightNo,classType, numPassengers);
	}

	@Override
	public double getTotalFare(int numPassengers, int flightNo,
			String classType) {
		double totalFare = numPassengers * arsDaoImpl.getSeatFare(flightNo,classType);
		return totalFare;
	}

	@Override
	public FlightInfoDTO getFlightInfo(Integer flightNo) {
		// TODO Auto-generated method stub
		return arsDaoImpl.getFlightInfo(new Integer(flightNo));
	}

	@Override
	public boolean bookSeatsTransaction(List<PassengerDTO> passengerList,
			FlightInfoDTO flightInfoDTO, List<SeatInfoDTO> seatInfoList,BookingInfoDTO bookingInfoDTO,String userId) {
		// TODO Auto-generated method stub
		return arsDaoImpl.bookSeatsTransaction(passengerList, flightInfoDTO, seatInfoList, bookingInfoDTO, userId);
	}

	//----------------------Flight Occupancy Module -------------------
	
	@Override
	public int getAvailableSeats(int flightNo,String classType) {
		return arsDaoImpl.getAvailableSeats(flightNo, classType);
	}

}


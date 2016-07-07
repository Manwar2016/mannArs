package com.igate.ars.dao;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.FlightInfoDTO;
import com.igate.ars.dto.PassengerDTO;
import com.igate.ars.dto.SeatInfoDTO;
import com.igate.ars.dto.UserDTO;
import com.igate.ars.rowmapper.AirportRowMapper;
import com.igate.ars.rowmapper.FlightInfoRowMapper;
import com.igate.ars.rowmapper.FlightNumberRowMapper;
import com.igate.ars.rowmapper.LoginRowMapper;
import com.igate.ars.rowmapper.PassengerRowMapper;
import com.igate.ars.rowmapper.ViewBookingsRowMapper;
import com.igate.ars.rowmapper.ViewUpdateBookingRowMapper;
@Repository
public class ArsDaoImpl extends JdbcDaoSupport implements IArsDAO{



	@Autowired
	private DataSource arsDataSource;
	@PostConstruct
	private void initialize() {
		setDataSource(arsDataSource);
	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
	 - Function Name	:	isValidLogin()
	 - Input Parameters	:	UserDTO user
	 - Return Type		:	UserDTO
	 - Throws			:  	ArsException
	 - Author			:	RAJDEEP SAHA
	 - Creation Date	:	10/09/2015
	 - Description		:	Validation of login deatails 
	 ********************************************************************************************************/


	@SuppressWarnings("unchecked")
	@Override
	public UserDTO isValidLogin(UserDTO user)  {

		int count=0;
		count = getJdbcTemplate().queryForObject("SELECT count(*) FROM users WHERE username=? AND password=?",Integer.class,user.getUserName(),user.getPassword());
		if(count!=0)
		{
	    // user=getJdbcTemplate().queryForObject(QueryMapper.VALID_LOGIN_QUERY, new LoginRowMapper(),user.getUserName(),user.getPassword());
			user=(UserDTO) getJdbcTemplate().queryForObject(QueryMapper.VALID_LOGIN_QUERY, new LoginRowMapper(),user.getUserName(),user.getPassword());
	     if(user.getRole()!=null)
			user.setUserStatus(true);
		}
		else
			user.setUserStatus(false);
		return user;
	}



		//------------------------ 1.Airline Reservation System--------------------------
		/*******************************************************************************************************
		 - Function Name	:	addUser()
		 - Input Parameters	:	UserDTO user
		 - Return Type		:	UserDTO
		 - Throws			:  	ArsException
		 - Author			:	RAJDEEP SAHA
		 - Creation Date	:	10/09/2015
		 - Description		:	add the user in dabase
		 ********************************************************************************************************/

	@Override
	public int addUser(UserDTO user)  {
		int count=0;
		count=getJdbcTemplate().update(QueryMapper.ADD_USER_QUERY, user.getUserName(),user.getPassword(),user.getMobileNo());
		return count;
	}




	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
	 - Function Name	:	getAirport()
	 - Input Parameters	:	 
	 - Return Type		:	AirportDTO
	 - Throws			:  	ArsException
	 - Author			:	Manwar Singh
	 - Creation Date	:	10/09/2015
	 - Description		:	getting the airport id and airport name
	 ********************************************************************************************************/
	@Override
	public List<AirportDTO> getAirport()  {
		List<AirportDTO> airportList=getJdbcTemplate().query(QueryMapper.GET_AIRPORT_QUERY, new AirportRowMapper());
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
		 - Description		:	add the flight information into database
	 ********************************************************************************************************/
	@Override
	public int addFlightInfo(FlightInfoDTO flightInfoDTO)  {
		int count=0;
		count=getJdbcTemplate().update(QueryMapper.ADD_FLIGHT,flightInfoDTO.getAirline(),flightInfoDTO.getArrivalAirportId(),
				flightInfoDTO.getDepartureAirportId(),flightInfoDTO.getDepartureDate(),flightInfoDTO.getArrivalDate(),
				flightInfoDTO.getDepartureTime(),flightInfoDTO.getArrivalTime(),flightInfoDTO.getFirstSeats(),flightInfoDTO.getFirstSeatFare(),
				flightInfoDTO.getBusinessSeats(),flightInfoDTO.getBusinessSeatFare());
		return count;

	}



	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	getFlightNumbers()
		 - Input Parameters	:	 
		 - Return Type		:	List<FlightInfoDTO>
		 - Throws			:  	ArsException
		 - Author			:	Manwar Singh
		 - Creation Date	:	10/09/2015
		 - Description		:	get all the flight numbers from  the database
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlightNumbers()  {
		List<FlightInfoDTO> flightNumberList=getJdbcTemplate().query(QueryMapper.GET_FLIGHT_NUMBER_QUERY, new FlightNumberRowMapper());
		return flightNumberList;

	}





	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	getFlightInfoList()
		 - Input Parameters	:	flightNo
		 - Return Type		:	FlightInfoDTO
		 - Throws			:  	ArsException
		 - Author			:	Manwar Singh
		 - Creation Date	:	10/09/2015
		 - Description		:	get the flight details based on the flight number from  the database
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlightInfoList(String flightNo)  {
		List<FlightInfoDTO> flightInfoList=getJdbcTemplate().query(QueryMapper.GET_FLIGHT_INFO, new FlightInfoRowMapper(),flightNo);
		return flightInfoList;
	}



	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	getFlightInfo()
			 - Input Parameters	:	flightNo
			 - Return Type		:	FlightInfoDTO
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	get the flight details based on the flight number from  the database
	 ********************************************************************************************************/
	@Override
	public FlightInfoDTO getFlightInfo(String flightNo)  {
		FlightInfoDTO flightInfo = getJdbcTemplate().queryForObject(QueryMapper.GET_FLIGHT_INFO, new FlightInfoRowMapper(),flightNo);
		return flightInfo;
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
		count=getJdbcTemplate().update(QueryMapper.UPDATE_FLIGHT_INFO,flightInfoDTO.getAirline(),flightInfoDTO.getArrivalAirportId(),
				flightInfoDTO.getDepartureAirportId(),flightInfoDTO.getDepartureDate(),flightInfoDTO.getArrivalDate(),
				flightInfoDTO.getDepartureTime(),flightInfoDTO.getArrivalTime(),flightInfoDTO.getFirstSeats(),flightInfoDTO.getFirstSeatFare(),
				flightInfoDTO.getBusinessSeats(),flightInfoDTO.getBusinessSeatFare(),flightInfoDTO.getFlightNo());
		return count;
	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	getFlightInfoList()
			 - Input Parameters	:	Date departureDate
			 - Return Type		:	FlightInfoDTO
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	get the flight details based on the departure date from  the database
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlightInfoList(Date departureDate) {
		List<FlightInfoDTO> flightInfoList=getJdbcTemplate().query(QueryMapper.GET_FLIGHT_INFOLIST, new FlightInfoRowMapper(),departureDate);
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
		int countFlight=getJdbcTemplate().queryForInt("SELECT count(flightno) from bookinginfo WHERE flightno=?",flightNo);
		if(countFlight==0)
			{
			  count=getJdbcTemplate().update(QueryMapper.CANCEL_FLIGHT_QUERY,flightNo);
			}
		return count;
	}



	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	isValidForCancelFlight()
			 - Input Parameters	:	String flightNo
			 - Return Type		:	boolean
			 - Throws			:  	ArsException
			 - Author			:	Manwar Singh
			 - Creation Date	:	10/09/2015
			 - Description		:	count the numbers of booking for given flight number 
	 ********************************************************************************************************/	
	@Override
	public boolean isValidForCancelFlight(String flightNo)
		 {
		int count=0;
		count=getJdbcTemplate().update(QueryMapper.COUNT_BOOKING_QUERY ,flightNo);
		if(count>0)
			return true;
		else
			return false;
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
	public List<FlightInfoDTO> retrieveFlightList(String departureAirportId,Date departureDate)  {
		String sql="SELECT flightNo,airline,arrivalAirportId,departureAirportId,departureDate,arrivalDate,departureTime ,arrivalTime,firstSeats ,firstSeatFare,businessSeats ,businessSeatsFare FROM FlightInfo WHERE departureAirportId=? AND departureDate=?";
		List<FlightInfoDTO> allFlightList= getJdbcTemplate().query(sql,new FlightInfoRowMapper(),departureAirportId,departureDate);
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
		String sql="SELECT p.firstname,p.lastname,b.bookingId,p.passengerid,p.mobileno FROM bookingInfo b,passengers p WHERE p.bookingid=b.bookingId and b.flightNo=?";
		List<PassengerDTO> allPassengersList= getJdbcTemplate().query(sql,new PassengerRowMapper(), new Integer(flightNo));


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
		String sql="SELECT bookingid,flightno,arrivalcity,departurecity,customeremail,numpassengers,totalfare  FROM Bookinginfo WHERE  flightno=?";
		List<BookingInfoDTO> viewBookingList= getJdbcTemplate().query(sql,new BookingListRowMapper(), new Integer(flightNo));
		return viewBookingList;
	}


	public List<PassengerDTO> loadBookingList(int bookingId){

		List<PassengerDTO> passengerslist=getJdbcTemplate().query(QueryMapper.LOAD_UPDATE_BOOKING,new ViewUpdateBookingRowMapper(),bookingId);


		return passengerslist;


	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	getBookingList()
			 - Input Parameters	:	int passengerId
			 - Return Type		:	PassengerDTO
			 - Throws			:  	ArsException
			 - Author			:	RAJDEEP SAHA
			 - Creation Date	:	17/10/2015
			 - Description		:	Returning passenger Information 
	 ********************************************************************************************************/



	public PassengerDTO getBookingList(int passengerId){

		System.out.println(passengerId);
		//PassengerDTO passengers=getJdbcTemplate().queryForObject(QueryMapper.VIEW_UPDATE_BOOKING,new ViewUpdateBookingRowMapper(),passengerId);
		PassengerDTO passengers=(PassengerDTO) getJdbcTemplate().queryForObject(QueryMapper.VIEW_UPDATE_BOOKING,new ViewUpdateBookingRowMapper(),passengerId);
		System.out.println("dao1");

		return passengers;

	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
				 - Function Name	:	updateBooking()
				 - Input Parameters	:	PassengerDTO passenger
				 - Return Type		:	int
				 - Throws			:  	ArsException
				 - Author			:	RAJDEEP SAHA
				 - Creation Date	:	17/10/2015
				 - Description		:	Updating booking details
	 ********************************************************************************************************/



	public int updateBooking(PassengerDTO passenger){


		int count=getJdbcTemplate().update(QueryMapper.UPDATE_PASSENER_QUERY, passenger.getFirstName(),passenger.getLastName(),passenger.getEmailId(),passenger.getMobileNo(),passenger.getGender(),passenger.getPassengerId());

		return count;

	}


	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
				 - Function Name	:	viewBookings()
				 - Input Parameters	:	
				 - Return Type		:	List<BookingInfoDTO>
				 - Throws			:  	ArsException
				 - Author			:	RAJDEEP SAHA
				 - Creation Date	:	17/10/2015
				 - Description		:	Returning booking details
	 ********************************************************************************************************/




	public List<BookingInfoDTO> viewBookings(String userID){

		List<BookingInfoDTO> bookingInfoList=getJdbcTemplate().query(QueryMapper.GET_BOOKINGS_QUERY, new ViewBookingsRowMapper(),userID);


		return bookingInfoList;

	}
	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
		 - Function Name	:	viewDeleteBookings(int bookingId)
		 - Input Parameters	:	int bookingId
		 - Return Type		:	BookingInfoDTO
		 - Throws			:  	ArsException
		 - Author			:	RAJDEEP SAHA
		 - Creation Date	:	19/10/2015
		 - Description		:	Returning booking details based on id
	 ********************************************************************************************************/


	public BookingInfoDTO viewDeleteBookings(int bookingId){

	//	BookingInfoDTO bookingInfo=getJdbcTemplate().queryForObject(QueryMapper.GET_BOOKING_BY_ID, new ViewBookingsRowMapper(),bookingId);
		BookingInfoDTO bookingInfo=(BookingInfoDTO) getJdbcTemplate().queryForObject(QueryMapper.GET_BOOKING_BY_ID, new ViewBookingsRowMapper(),bookingId);

		return bookingInfo;

	}

	//------------------------ 1.Airline Reservation System--------------------------
	/*******************************************************************************************************
			 - Function Name	:	deleteBooking(int passengerId)
			 - Input Parameters	:	int passengerId
			 - Return Type		:	int
			 - Throws			:  	ArsException
			 - Author			:	RAJDEEP SAHA
			 - Creation Date	:	19/10/2015
			 - Description		:	Delete Booking Details Based on Paseenger Id
	 ********************************************************************************************************/


	public int deleteBooking(int passengerId){
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;

		int bookingId=getJdbcTemplate().queryForInt(QueryMapper.BOOKING_ID_QUERY, passengerId);
		int count=getJdbcTemplate().update(QueryMapper.DELETE_SEAT_QUERY,passengerId);

		if(count!=0){

			count1=getJdbcTemplate().update(QueryMapper.DELETE_PASSENGER_QUERY,passengerId);

			if(count1!=0){

				count2=getJdbcTemplate().update(QueryMapper.UPDATE_BOOKING_QUERY, bookingId);

			}
			 count3=getJdbcTemplate().queryForInt(QueryMapper.COUNT_PASSENGER_QUERY,bookingId);
			
			System.out.println(count3);
			if(count3==0)
			{
				count4=getJdbcTemplate().update(QueryMapper.DELETE_BOOKING_QUERY,bookingId);
			}

		}

		return count2;
	}



	//------------------------ Reservation Module--------------------------
	/*******************************************************************************************************
		 - Function Name	:	getAirportInfo()
		 - Input Parameters	:	
		 - Return Type		:	List<AirportDTO>
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked when search flights form is loaded.
		  						It returns all airport info to be filled in the dropdown box
	 ********************************************************************************************************/

	@Override
	public List<AirportDTO> getAirportInfo(){
		String sql = "SELECT airportid, airportname, city FROM airport";
		List<AirportDTO> airportList = (List<AirportDTO>) getJdbcTemplate().query(sql,  new AirportRowMapper()); 
		return airportList;
	}

	/*******************************************************************************************************
		 - Function Name	:	getFlights()
		 - Input Parameters	:	FlightInfoDTO flightInfoDTO
		 - Return Type		:	List<FlightInfoDTO>
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked due to Search Flights action.
		  						It returns a list of flights based on the input parameter
	 ********************************************************************************************************/
	@Override
	public List<FlightInfoDTO> getFlights(FlightInfoDTO findFlightsInfoDTO){
		String sql = "SELECT "
				+ " F.flightNo, F.airline,"
				+ " A1.city,A2.city,"
				+ " F.departureDate,F.arrivalDate,"
				+ " F.departureTime,F.arrivalTime,"
				+ " F.firstSeats,F.firstSeatFare,"
				+ " F.businessSeats,F.businessSeatsFare"
				+ " FROM flightInfo F, airport A1, airport A2"
				+ " WHERE"
				+ " F.departureairportid = A1.airportid AND"
				+ " F.arrivalairportid = A2.airportid AND"
				+ " F.departureairportid = ? AND"
				+ " F.arrivalairportid = ? AND"
				+ " F.departuredate = ? ";
		Object[] params = new Object[]{findFlightsInfoDTO.getDepartureAirportId(),
				findFlightsInfoDTO.getArrivalAirportId(),findFlightsInfoDTO.getDepartureDate()};
		List<FlightInfoDTO> flightList = (List<FlightInfoDTO>) getJdbcTemplate().query(sql, new FlightInfoRowMapper(),params); 
		return flightList;
	}

	/*******************************************************************************************************
		 - Function Name	:	getAvailableSeats()
		 - Input Parameters	:	int flightNo
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked due to Book seats action.
		  						It returns a the number of seats available
		  						based on the flight number
	 ********************************************************************************************************/

	@Override
	public int getAvailableSeats(int flightNo,String classType) {
		// TODO Auto-generated method stub
		int availableSeats = 0;
		int firstSeats = 0;
		int businessSeats = 0;
		int bookedSeats = 0;
		if("firstClass".equals(classType)){
			String sql1 = "SELECT firstseats FROM flightinfo WHERE flightno = ? ";
			firstSeats = getJdbcTemplate().queryForInt(sql1,flightNo);
			String sql2 = "SELECT count(seatNo) FROM seat WHERE flightno = ? AND classtype = 'firstClass' ";
			bookedSeats = getJdbcTemplate().queryForInt(sql2,flightNo);
			availableSeats = firstSeats - bookedSeats;
		}
		else if("businessClass".equals(classType)){
			String sql1 = "SELECT businessseats FROM flightinfo WHERE flightno = ? ";
			businessSeats = getJdbcTemplate().queryForInt(sql1,flightNo);
			String sql2 = "SELECT count(seatNo) FROM seat WHERE flightno = ? AND classtype = 'businessClass' ";
			bookedSeats = getJdbcTemplate().queryForInt(sql2,flightNo);
			availableSeats = businessSeats - bookedSeats;
		}
		return availableSeats;
	}

	/*******************************************************************************************************
		 - Function Name	:	blockSeats()
		 - Input Parameters	:	List<SeatInfoDTO> seatInfoList
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked due to Book seats action.
		 						It blocks the seats by updating the database 
		  						It returns the number of seats blocked.
	 ********************************************************************************************************/

	@Override
	public int blockSeats(List<SeatInfoDTO> seatInfoList,int flightNo, 
			String classType,int numPassengers) {
		// TODO Auto-generated method stub
		int numBlockedSeats = 0;
		for(int index = 0; index < numPassengers; index++){
			int seatNo = generateSeatNo();
			SeatInfoDTO seatInfoDTO = new SeatInfoDTO();
			seatInfoDTO.setSeatNo(seatNo);
			seatInfoDTO.setFlightNo(new Integer(flightNo).toString());
			seatInfoDTO.setClassType(classType);
			seatInfoList.add(seatInfoDTO);
			String sql = "INSERT INTO seat(seatno, flightno, classtype) VALUES(?,?,?)";
			Object[] params = new Object[]{seatNo,flightNo,classType};
			numBlockedSeats = numBlockedSeats + getJdbcTemplate().update(sql, params);
		}
		return numBlockedSeats;
	}

	/*******************************************************************************************************
		 - Function Name	:	generateSeatId()
		 - Input Parameters	:	
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by block seats function
		 						It generates seat id for the booking
	 ********************************************************************************************************/

	public int generateSeatNo(){
		int seatId = 0;
		String sql = "SELECT seatNoSeq.nextVal FROM DUAL";
		seatId = getJdbcTemplate().queryForInt(sql);
		return seatId ;
	}

	/*******************************************************************************************************
		 - Function Name	:	getSeatFare()
		 - Input Parameters	:	int numPassengers, int flightNo,
								String classType
		 - Return Type		:	double
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	
	 ********************************************************************************************************/

	@Override
	public double getSeatFare(int flightNo, String classType) {
		double seatFare = 0;
		String sql = null;
		if("firstClass".equals(classType)){
			sql = "SELECT firstSeatFare FROM flightInfo WHERE flightNo = ?";
			
		}
		else{
			sql = "SELECT businessSeatsFare FROM flightInfo WHERE flightNo = ?";
		}
		seatFare = getJdbcTemplate().queryForObject(sql,Double.class,flightNo);
		System.out.println("getSeatFare");
		return seatFare;
	}

	/*******************************************************************************************************
		 - Function Name	:	getFlightInfo()
		 - Input Parameters	:	Integer flightNo
		 - Return Type		:	FlightInfoDTO
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked due to Book seats action.
		  						It returns the Flight Information based on flight number
	 ********************************************************************************************************/

	@Override
	public FlightInfoDTO getFlightInfo(Integer flightNo) {
		// TODO Auto-generated method stub'
		System.out.println("getFlightInfo");
		String sql = "SELECT "
				+ " F.flightNo, F.airline,"
				+ " A1.city,A2.city,"
				+ " F.departureDate,F.arrivalDate,"
				+ " F.departureTime,F.arrivalTime,"
				+ " F.firstSeats,F.firstSeatFare,"
				+ " F.businessSeats,F.businessSeatsFare "
				+ " FROM flightInfo F, airport A1, airport A2"
				+ " WHERE"
				+ " F.departureairportid = A1.airportid AND"
				+ " F.arrivalairportid = A2.airportid AND"
				+ " F.flightNo = ? ";
		Object[] params = new Object[]{flightNo};
		FlightInfoDTO flightInfoDTO = getJdbcTemplate().queryForObject(sql, new FlightInfoRowMapper(),params);
		return flightInfoDTO;
	}

	/*******************************************************************************************************
		 - Function Name	:	bookSeatsTransaction()
		 - Input Parameters	:	List<PassengerDTO> passengerList,
								FlightInfoDTO flightInfoDTO, 
								List<SeatInfoDTO> seatInfoList,
								CreditCardDTO creditCardDTO
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked due to Book seats action.
		 						It performs a transaction to book a ticket based on
		 						input parameters. 
		  						It returns the bookingInfoDTO for the ticket.
	 ********************************************************************************************************/

	@Override
	public boolean bookSeatsTransaction(List<PassengerDTO> passengerList,
			FlightInfoDTO flightInfoDTO, List<SeatInfoDTO> seatInfoList,
			BookingInfoDTO bookingInfoDTO,String userId) {
		// TODO Auto-generated method stub
		boolean transactionStatus = false;
		addBookingInfo( bookingInfoDTO,flightInfoDTO,userId);
		addPassengerDetails(passengerList, new Integer(bookingInfoDTO.getBookingId().toString()));
		confirmSeats(seatInfoList, passengerList);
		transactionStatus = true;
		return transactionStatus;
	}

	/*******************************************************************************************************
		 - Function Name	:	generateBookingId()
		 - Input Parameters	:	
		 - Return Type		:	BookingInfoDTO
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by addBookingInfo function
		 						It generates the booking id
	 ********************************************************************************************************/

	public int addBookingInfo(BookingInfoDTO bookingInfoDTO, FlightInfoDTO flightInfoDTO,String userId)
	{
		int bookingId = generateBookingId();
		bookingInfoDTO.setBookingId(new Integer(bookingId).toString());
		
		//calculate total fare
		double totalFare = flightInfoDTO.getNumPassengers() * getSeatFare(new Integer(flightInfoDTO.getFlightNo().toString()), flightInfoDTO.getClassType());
		bookingInfoDTO.setTotalFare(totalFare);
		bookingInfoDTO.setNumPassengers(new Integer(flightInfoDTO.getNumPassengers()).toString());
		bookingInfoDTO.setArrivalCity(flightInfoDTO.getArrivalCity());
		bookingInfoDTO.setDepartureCity(flightInfoDTO.getDepartureCity());
		bookingInfoDTO.setFlightNo(new Integer(flightInfoDTO.getFlightNo()).toString());
		System.out.println(bookingInfoDTO.toString());
		String sql = "INSERT INTO bookinginfo("
				+ "bookingid, flightno, "
				+ "departureCity, arrivalCity, "
				+ "numpassengers, totalfare, userid)"
				+ "VALUES(?,?,?,?,?,?,?)";
		int numRows = getJdbcTemplate().update(sql, bookingId,flightInfoDTO.getFlightNo(),
				bookingInfoDTO.getDepartureCity(),bookingInfoDTO.getArrivalCity(),
				bookingInfoDTO.getNumPassengers(),totalFare,userId);
		return numRows;
	}

	/*******************************************************************************************************
		 - Function Name	:	generateBookingId()
		 - Input Parameters	:	
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by addBookingInfo function
		 						It generates the booking id
	 ********************************************************************************************************/

	public int generateBookingId()
	{
		int bookingId = 0;
		String sql = "SELECT bookingIdSeq.nextVal FROM DUAL";
		bookingId = getJdbcTemplate().queryForInt(sql);
		return bookingId ;
	}


	/*******************************************************************************************************
		 - Function Name	:	addPassengerDetails()
		 - Input Parameters	:	List<PassengerDTO> passengerList,int bookingId
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by bookSeatsTransaction function
		 						It inserts passenger information in the passenger list 
		 						into the database
	 ********************************************************************************************************/

	public int addPassengerDetails(List<PassengerDTO> 
	passengerList,int bookingId)
	{
		int numRows = 0;
		for( PassengerDTO passengerDTO: passengerList){
			int passengerId = generatePassengerId();
			passengerDTO.setPassengerId(passengerId);
			String sql = "INSERT INTO passengers"
					+ "(passengerid, bookingid, emailid,"
					+ "firstname, lastname, gender, mobileno) "
					+ "VALUES(?,?,?,?,?,?,?)";
			numRows = numRows + getJdbcTemplate().update(sql, passengerId, bookingId,
					passengerDTO.getEmailId(),passengerDTO.getFirstName(),
					passengerDTO.getLastName(),passengerDTO.getGender(),
					passengerDTO.getMobileNo());
		}
		return numRows;
	}

	/*******************************************************************************************************
		 - Function Name	:	generatePassengerId()
		 - Input Parameters	:	List<PassengerDTO> passengerList,int bookingId
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by bookSeatsTransaction function
		 						It inserts passenger information in the passenger list 
		 						into the database
	 ********************************************************************************************************/

	public int generatePassengerId()
	{
		int passengerId = 0;
		String sql = "SELECT passengerIdSeq.nextVal FROM DUAL";
		passengerId = getJdbcTemplate().queryForInt(sql);
		return passengerId ;
	}

	/*******************************************************************************************************
		 - Function Name	:	confirmSeats()
		 - Input Parameters	:	List<SeatInfoDTO> seatInfoList, 
								List<PassengerDTO> passengerList
		 - Return Type		:	int
		 - Throws			:  	ArsException
		 - Author			:	Nikhil Pereira
		 - Creation Date	:	16/10/2015
		 - Description		:	This method is invoked by bookSeatsTransaction function
		 						It updates passenger id in the passenger list in the 
		 						bookedseats table.
	 ********************************************************************************************************/

	public int confirmSeats(List<SeatInfoDTO> seatInfoList, 
			List<PassengerDTO> passengerList){

		int numRows = 0;
		Iterator<PassengerDTO> passengerListIterator = passengerList.iterator();
		Iterator<SeatInfoDTO> seatListIterator = seatInfoList.iterator();
		while(passengerListIterator.hasNext()){
			String sql = "UPDATE seat SET passengerId = ? WHERE seatNo = ?";
			numRows = numRows + getJdbcTemplate().update(sql, 
					passengerListIterator.next().getPassengerId(),
					seatListIterator.next().getSeatNo());
		}
		return numRows;
	}

}







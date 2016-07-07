package com.igate.ars.dao;

public interface QueryMapper {
   public static String VALID_LOGIN_QUERY="SELECT username,password,role,userid FROM users WHERE username=? AND password=?";
   public static String ADD_USER_QUERY="INSERT INTO users VALUES(USERIDSEQ.nextval,?,?,'user',?)"; 
   public static String GET_AIRPORT_QUERY="SELECT airportId, airportName,city FROM airport"; 
   public static String GET_FLIGHT_NUMBER_QUERY="SELECT flightno FROM flightinfo"; 
   public static String GET_FLIGHT_INFO="SELECT flightno, airline, arrivalairportid, departureairportid, departuredate,"
			+ "arrivaldate , departuretime, arrivaltime, firstseats, firstseatfare, businessseats,"
			+ " businessseatsfare FROM flightinfo WHERE flightno=?";
   public static String UPDATE_FLIGHT_INFO="UPDATE flightinfo SET airline=?, ARRIVALAIRPORTID=?, DEPARTUREAIRPORTID=?,"
			+ " DEPARTUREDATE=?,ARRIVALDATE=? , DEPARTURETIME=?, ARRIVALTIME=?,"+ " FIRSTSEATS=?, FIRSTSEATFARE=?,"
			+ " BUSINESSSEATS=?,"+ " BUSINESSSEATSFARE=? WHERE FLIGHTNO=?";
	
   public static String ADD_FLIGHT="INSERT INTO flightInfo VALUES(flightnoseq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
   public static String GET_FLIGHT_INFOLIST="SELECT flightno, airline, arrivalairportid, departureairportid, departuredate,"
			+ "arrivaldate , departuretime, arrivaltime, firstseats, firstseatfare, businessseats,"
			+ " businessseatsfare FROM flightinfo WHERE departuredate=?";
   public static String COUNT_BOOKING_QUERY="SELECT count(*) FROM flightinfo f JOIN bookinginfo b ON(f.?= b.?) AND f.departuredate >= sysdate";
   public static String CANCEL_FLIGHT_QUERY= "DELETE FROM flightinfo WHERE flightno=?";
	
   public static String LOAD_UPDATE_BOOKING="SELECT bookingid,passengerid,firstname,lastname,emailid,mobileno,gender FROM passengers WHERE bookingId=?";
	
	public static String VIEW_UPDATE_BOOKING="SELECT bookingid,passengerid,firstname,lastname,emailid,mobileno,gender FROM passengers WHERE passengerid=?";
	public static String UPDATE_PASSENER_QUERY="UPDATE passengers SET firstname=?,lastname=?,emailid=?,mobileno=?,gender=? WHERE passengerid=?";
	
	public static String GET_BOOKINGS_QUERY="SELECT bookingId,flightNo,arrivalCity,departureCity,CustomerEmail,numPassengers,totalFare FROM bookinginfo WHERE userid=?";
	
	public static String GET_BOOKING_BY_ID="SELECT bookingId,flightNo,arrivalCity,departureCity,CustomerEmail,numPassengers,totalFare FROM bookinginfo WHERE bookingid=?";

	public static String DELETE_SEAT_QUERY="DELETE seat WHERE passengerId=?";
	
	public static String DELETE_PASSENGER_QUERY="DELETE passengers WHERE passengerId=?";
	
	public static String DELETE_BOOKING_QUERY="DELETE bookingInfo WHERE bookingId=?";
	
	public static String BOOKING_ID_QUERY="SELECT bookingId FROM passengers WHERE passengerId=?";
	
	public static String UPDATE_BOOKING_QUERY="UPDATE bookingInfo SET numpassengers=numpassengers-1 WHERE bookingId=?";
	
	public static String COUNT_PASSENGER_QUERY="SELECT count(*) FROM passengers p JOIN bookingInfo b ON(p.bookingId=b.bookingId) WHERE p.bookingId=?";
	
 
	
}

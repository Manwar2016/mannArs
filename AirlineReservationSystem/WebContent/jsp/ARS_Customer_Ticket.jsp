<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Ticket</title>
</head>
<body>
	<h1>Your Ticket</h1>
	<table>
		<tr>
			<th>Booking ID</th>
			<td>${bookingInfoDTO.bookingId}</td>
		</tr>
		<tr>
			<th>Flight No</th>
			<td>${flightInfoDTO.flightNo }</td>
		</tr>
		<tr>
			<th>Airline</th>
			<td>${flightInfoDTO.airline }</td>
		</tr>
		<tr>
			<th>Passenger List</th>
			<td>
				<c:forEach var="passengerDTO" items="${passengerList }">
				<ul>
					<li>${passengerDTO.firstName} ${passengerDTO.lastName} </li>
				</ul>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>Seat Number</th>
			<td>
			<c:forEach var="seatDTO" items="${seatInfoList }">
				<ul>
					<li>${seatDTO.seatNo} </li>
				</ul>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th>Departure City</th>
			<td>${flightInfoDTO.departureCity }</td>
		</tr>
		<tr>
			<th>Departure Date</th>
			<td>${flightInfoDTO.departureDate }</td>
		</tr>
		<tr>
			<th>Departure Time</th>
			<td>${flightInfoDTO.departureTime }</td>
		</tr>
		<tr>
			<th>Arrival City</th>
			<td>${flightInfoDTO.arrivalCity }</td>
		</tr>
		<tr>
			<th>Arrival Date</th>
			<td>${flightInfoDTO.arrivalDate }</td>
		</tr>
		<tr>
			<th>Arrival Time</th>
			<td>${flightInfoDTO.arrivalTime }</td>
		</tr>
		<tr>
			<th>Number of Passengers</th>
			<td>${bookingInfoDTO.numPassengers }</td>
		</tr>
		<tr>
			<th>Total Fare</th>
			<td>${bookingInfoDTO.totalFare }</td>
		</tr>
	</table>
	<h3>Have a nice flight!</h3>
</body>
</html>
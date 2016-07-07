<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/AirlineReservationSystem/css/arsStyle.css" rel="stylesheet"
	type="text/css" />
<link href="/AirlineReservationSystem/css/Searchtable.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"></script>
</head>
<body>
	<div id="page" align="center">
		<div class="main">

			<!-- header -->
			<header>

			<div align="center" id="topHeader">
				<h1 id="headerMain">AirLine Reservation System</h1>
				<nav>
				 <list> <a href="loadHome.htm"><input type="button" value="Home" class="menu" /></a></list>
				 <list> <a href="/aboutus.jsp"><input type="button" value="About Us" class="menu" /></a></list>
				 <list> <a href=""><input type="button" value="Contact Us" class="menu" /></a></list>
				 <list> <a href=""><input type="button" value="Services" class="menu" /></a></list>
				 <list> <a href=""><input type="button" value="Terms And Conditions" class="menu" /></a></list> </nav>
			</div>


			</header>
			<%-- Add extra fields --%>
			<div>
				<c:if test="${ flightInfoList.size() == 0}">
					<h3 style="color: red">There are no flights for the chosen date</h3>
				</c:if>
				<c:if test="${ flightInfoList.size() != 0 }">
					<table class="responstable2">
						<tr>
							<th>Class Type</th>
							<td>${findFlightInfoDTO.classType }</td>
						</tr>
						<tr>
							<th>No. of Passengers</th>
							<td>${findFlightInfoDTO.numPassengers }</td>
						</tr>
						<tr>
							<th>Departure Date</th>
							<td>${findFlightInfoDTO.departureDate }</td>
						</tr>
						<tr>
							<th>Departure City</th>
							<td>${flightInfoList[0].departureCity }</td>
						</tr>
						<tr>
							<th>Arrival City</th>
							<td>${flightInfoList[0].arrivalCity }</td>
						</tr>
					</table>
					<table class="responstable2">
						<caption>Flight List</caption>
						<tr>
							<th>Flight No.</th>
							<th>Airline</th>
							<th>Departure Time</th>
							<th>Arrival Time</th>
							<th>Arrival Date</th>
							<th>Total Fare(INR)</th>
							<th>Action</th>
						</tr>
						<c:set var="flightInfoList" value="${sessionScope.flightInfoList}" />
						<c:forEach var="flight" items="${flightInfoList}">
							<tr>
								<td>${flight.flightNo}</td>
								<td>${flight.airline}</td>
								<td>${flight.departureTime}</td>
								<td>${flight.arrivalTime}</td>
								<td>${flight.arrivalDate}</td>
								<c:if test="${findFlightInfoDTO.classType eq 'businessClass'}">
									<td>${flight.businessSeatFare*findFlightInfoDTO.numPassengers}</td>
								</c:if>
								<c:if test="${findFlightInfoDTO.classType eq 'firstClass'}">
									<td>${flight.firstSeatFare*findFlightInfoDTO.numPassengers}</td>
								</c:if>
								<td><a
									href="processBookSeats.htm?flightNo=${flight.flightNo}">Book
										Seats</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		<div class="footer">
			<div id="footer1">
				Copyright &copy; igate.ars.com<br>
			</div>
		</div>
</body>
</html>
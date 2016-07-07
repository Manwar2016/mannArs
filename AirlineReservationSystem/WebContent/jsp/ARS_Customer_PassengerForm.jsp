<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Form</title>
<link href="/AirlineReservationSystem/css/arsStyle.css" rel="stylesheet" type="text/css"/>
<link href="/AirlineReservationSystem/css/Searchtable.css" rel="stylesheet" type="text/css"/>
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
       <list><a href="loadHome.htm"><input type="button" value="Home" class="menu"/></a></list>  
       <list><a href="/aboutus.jsp"><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list> 
      </nav>	  
    </div>
</header>
	<c:if test="${counter ne null}">
	<h3>Passenger Form ${counter-1 } successfully submitted</h3>
	</c:if>

	<c:url var="myAction" value="/processPassengerForm.htm"></c:url>
	<div id="passenger">
	<table class="signup">
		<form:form action="${myAction}" method="post"
			modelAttribute="passengerDTO">
			<caption>Passenger Form ${counter}</caption>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" id="firstName"></form:input></td>
				<td><form:errors path="firstName" cssStyle="color:red" ></form:errors></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" id="lastName"></form:input></td>
				<td><form:errors path="lastName" cssStyle="color:red" ></form:errors></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input path="emailId" id="emailId"></form:input></td>
				<td><form:errors path="emailId" cssStyle="color:red" ></form:errors></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><form:input path="mobileNo" id="mobileNo"></form:input></td>
				<td><form:errors path="mobileNo" cssStyle="color:red" ></form:errors></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="male"
						label="Male" /> <form:radiobutton path="gender"
						value="female" label="Female" /></td>
				<td><form:errors path="gender" cssStyle="color:red" ></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Passenger"> <input
					type="reset" onclick="reset()" value="Reset"></td>
			</tr>
		</form:form>
	</table>
	</div>
<table class="responstable2">
		<tr>
			<th>Flight No.</th>
			<td>${flightInfoDTO.flightNo }</td>
		</tr>
		<tr>
			<th>Airline</th>
			<td>${flightInfoDTO.airline }</td>
		</tr>
		<tr>
			<th>Departure Date</th>
			<td>${flightInfoDTO.departureDate }</td>
		</tr>
		<tr>
			<th>Arrival Date</th>
			<td>${flightInfoDTO.arrivalDate }</td>
		</tr>
		<tr>
			<th>Departure Time</th>
			<td>${flightInfoDTO.departureTime }</td>
		</tr>
		<tr>
			<th>Arrival Time</th>
			<td>${flightInfoDTO.arrivalTime }</td>
		</tr>
		<tr>
			<th>Number Of Passengers</th>
			<td>${findFlightInfoDTO.numPassengers }</td>
		</tr>
		<tr>
			<th>Class Type</th>
			<td>${findFlightInfoDTO.classType }</td>
		</tr>
		<tr>
			<th>Total Fare</th>
			<td>${totalFare}</td>
		</tr>
	</table>
</div>
<div class="footer">
   <div id="footer1">Copyright &copy; igate.ars.com<br></div>
</div>
</body>
</html>
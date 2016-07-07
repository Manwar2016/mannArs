<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Form</title>
<link href="/AirlineReservationSystem/css/arsStyle.css" rel="stylesheet" type="text/css"/>
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
       <list><a href="/loadHome.htm"><input type="button" value="Home" class="menu"/></a></list>  
       <list><a href="/aboutus.jsp"><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>  
      </nav>	  
    </div>
       
     
</header>

	<h1></h1>
	<h1>Flight Occupancy Form</h1>
	<c:url var="myAction" value="/processFlightOccupancyForm.htm"></c:url>
	<table class="tloginBody4">
		<form:form action="${myAction}" method="post" modelAttribute="flightInfoDTO">
			<tr>
				<td>Departure Date:</td>
				<td><form:input path="departureDate" id="departureDate"></form:input></td>
				<td><form:errors path="departureDate"></form:errors></td>
			</tr>
			<tr>
				<td>Class Type:</td>
				<td><form:radiobutton path="classType" value="firstClass" label="First Class" />
					<form:radiobutton path="classType" value="businessClass" label="Business Class" /></td>
				<td><form:errors path="classType"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Get Flights"></td>
			</tr>
		</form:form>
	</table>
	<c:if test="${flightList.size() ne 0 }">
		<table>
			<c:forEach var="flight" items="${flightList}">
				<tr>
					<td>${flight.flightNo}</td>
					<td>${flight.airline}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.arrivalTime}</td>
					<td>${flight.arrivalDate}</td>
					<td>
					<a href="processViewFlightOccupancy.htm?flightNo=${flight.flightNo}">
					View Occupancy</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${flightList.size() eq 0}">
		<h3>No flights available for this date</h3>
	</c:if>
<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
    
</div>
</body>
</html>
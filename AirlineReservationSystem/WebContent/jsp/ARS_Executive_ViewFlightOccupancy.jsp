<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Flight Occupancy</title>
</head>
<body>
	<h1>Flight Occupancy</h1>
	<table>
		<c:if test="${availableSeats eq totalSeats}">
			<h3>Flight is empty</h3>
		</c:if>
		<c:if test="${availableSeats eq 0}">
			<h3>Flight is fully booked</h3>
		</c:if>
		<tr>
			<th>Class Type</th>
			<td>${classType }</td>
		</tr>
		<tr>
			<th>Total Seats</th>
			<td>${totalSeats }</td>
		</tr>
		<tr>
			<th>No. of Booked Seats</th>
			<td>${bookedSeats}</td>
		</tr>
		<tr>
			<th>Available Seats</th>
			<td>${availableSeats }</td>
		</tr>
	</table>
</body>
</html>
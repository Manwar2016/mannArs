<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Flight Form</title>
<link href="/AirlineReservationSystem/css/arsStyle.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"></script>
</head>
<div id="page" align="center">
<div class="main">

<!-- header -->
<header>
    
    <div align="center" id="topHeader">
     <h1 id="headerMain">AirLine Reservation System</h1>
 <nav>
     
       <list><a href=""><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>
 
      </nav>	  
    </div>
       
     
</header>
	
	<c:url var="myAction" value="loadSearchFlightList.htm"></c:url>
	<table class="taddFlightBody">
	<caption>Search Flight Form </caption>
		<form:form action="${myAction}" method="post"
			modelAttribute="findFlightInfoDTO">
			<tr>
				<td>From:<span style="color:red">*</span></td>
				<td><form:select path="departureAirportId" id="departureAirportId">
						<form:option value="" label="Select Airport and City"></form:option>
						<c:forEach var="airportDTO" items="${airportList}">
							<form:option value="${airportDTO.airportId}"
								label="${ airportDTO.airportName} ${ airportDTO.city}"></form:option>
						</c:forEach>
					</form:select>
			<form:errors path="departureAirportId" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>To:<span style="color:red">*</span></td>
				<td><form:select path="arrivalAirportId" id="arrivalAirportId">
						<form:option value="" label="Select Airport and City"></form:option>
						<c:forEach var="airportDTO" items="${airportList}">
							<form:option value="${airportDTO.airportId}"
								label="${ airportDTO.airportName} ${ airportDTO.city}"></form:option>
						</c:forEach>
					</form:select>
				<form:errors path="arrivalAirportId" cssStyle="color:red"></form:errors><span style="color: red">${cityError}</span></td>
			</tr>
			<tr>
				<td>Departure Date:<span style="color:red">*</span></td>
				<td><form:input path="departureDate" id="departureDate"></form:input>
				<form:errors path="departureDate" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Number of Passengers:<span style="color:red">*</span></td>
				<td><form:input path="numPassengers" id="numPassengers"></form:input>
				<form:errors path="numPassengers" cssStyle="color:red"></form:errors><span style="color: red">${numError}</span></td>
			</tr>
			<tr>
				<td>Class Type:<span style="color:red">*</span></td>
				<td><form:radiobutton path="classType" value="firstClass" label="First Class" />
					<form:radiobutton path="classType" value="businessClass" label="Business Class" />
				<form:errors path="classType" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Find Flights">&nbsp;&nbsp;
				<input type="reset" onclick="reset()" value="Reset"></td>
			</tr>
		</form:form>
	</table>
	<h3 style="color: red">${errorMsg}</h3>
</div>
<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
</html>
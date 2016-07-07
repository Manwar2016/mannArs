<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
      <div id="logUser">Logged User<br><span>${userName}</span></div>
 <nav>
       <list><a href=""><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>
      </nav>	  
    </div>
    
</header>
<c:url var="myAction" value="/processAddFlight.htm" />
<table class="taddFlightBody">
<caption>Add Flight Form</caption>
<form:form method="post" modelAttribute="flightInfoDTO" action="${myAction}">
			<tr><td>Airline:<span style="color:red">*</span></td>
			<td><form:input path="airline" placeholder="Enter the Airline" /></td>
			<td><form:errors path="airline" cssStyle="color:red"/></td> 
			</tr>
			<tr><td>Departure Airport:<span style="color:red">*</span></td>
			<td>
			<form:select path="departureAirportId">
    		<form:option value="" label="Please Select Departure Airport"/>
    		<form:options items="${airportList}" itemLabel="airportName" itemValue="airportId"/>
    		</form:select></td>
    		<td><form:errors path="departureAirportId" cssStyle="color:red"/></td>
  			</tr>
  			<tr><td>Arrival Airport:<span style="color:red">*</span></td>
			<td>
			<form:select path="arrivalAirportId">
    		<form:option value="" label="Please Select Arrival Airport"/>
    			<form:options items="${airportList}" itemLabel="airportName" itemValue="airportId"/>
    		</form:select>
    		</td>
  			<td><form:errors path="arrivalAirportId" cssStyle="color:red"/><span style="color: red">${sameAirportError}</span></td>
			</tr>
			
			<tr><td>Departure Date(yyyy-MM-dd):<span style="color:red">*</span></td>
			<td><form:input path="departureDate" placeholder="Enter the Departure Date" max="2016-04-30" title="Date should be within 6 months"/></td>
			<td><form:errors path="departureDate" cssStyle="color:red"/>${deptDateError}</td>  
			</tr>
			
			<tr><td>Arrival Date(yyyy-MM-dd):<span style="color:red">*</span></td>
			<td><form:input path="arrivalDate" placeholder="Enter the Arrival Date" /></td>
			<td><form:errors path="arrivalDate" cssStyle="color:red"/></td> 
			</tr> 
			
			<tr><td>Departure Time(hh:mm):<span style="color:red">*</span></td>
			<td><form:input path="departureTime" placeholder="Enter the Departure Time" /></td>
			<td><form:errors path="departureTime" cssStyle="color:red"/></td>
			</tr>  
			
			<tr><td>Arrival Time(hh:mm):<span style="color:red">*</span></td>
			<td><form:input path="arrivalTime" placeholder="Enter the Arrival Time" /></td>
			<td><form:errors path="arrivalTime" cssStyle="color:red"/><span style="color: red">${sameTimeError}</span></td>  
			</tr>
			
			<tr><td>First Class Seats:<span style="color:red">*</span></td>
			<td><form:input path="firstSeats" placeholder="Enter the First Class Seats" /></td>
			<td><span style="color: red">${firstseatError}</span></td> 
			</tr> 
			
			<tr><td>Business Class Seats:<span style="color:red">*</span></td>
			<td><form:input path="businessSeats" placeholder="Enter the Business Class Seats" /></td>
			<td><span style="color: red">${bussseatError}</span></td>
			</tr>  
			
			
			<tr><td>First Class Seats Fare:<span style="color:red">*</span></td>
			<td><form:input path="firstSeatFare" placeholder="Enter the First Class Seats Fare" /></td>
			<td><span style="color: red">${firstseatFareError}</span></td>  
			</tr>
			
			
			<tr><td>Business Class Seats Fare:<span style="color:red">*</span></td>
			<td><form:input path="businessSeatFare" placeholder="Enter the Business Class Seats Fare" /></td>
			<td><span style="color: red">${bussseatFareError}</span></td> 
			</tr> 
			<tr><td colspan="2" align="center"><input  type = "submit" value = "Add Flight" /></td></tr>
			<tr><td colspan="3" align="center"><h3 style="color:red">${errorMsg}</h3></td></tr>
			<tr><td colspan="3" align="center"><h3 style="color:green">${successMsg}</h3></td></tr>						
</form:form>
</table>
</div>
<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br></div>
  
</div>
</div>
</body>
</html>
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
    <div id=viewReport1>  
	<h3 id="titleForm">View Flight Reports Form</h3>
	
	<c:url var="myAction" value="/processViewFlightDetails.htm"/>	
	<table class="tloginBody4">
	<form:form method="post" modelAttribute="flightInfoDTO" action="${myAction}">

  			
  	    <tr>
	     <td>Enter  Date (yyyy-mm-dd):<span style="color:red">*</span></td>
	     <td><form:input path="departureDate" placeholder="enter date" /></td></tr>
	     <tr><td><form:errors path="departureDate" cssStyle="color:red"/></td>  
	    </tr>
	    
	    
	   
			<tr><td>Departure Airport:<span style="color:red">*</span></td>
			<td>
			<form:select path="departureAirportId">
    		<form:option value="" label="Please Select"/>
    		<form:options items="${airportList}" itemLabel="airportName" itemValue="airportId"/></tr>
    		</form:select></td><tr>
  			<form:errors path="departureAirportId" cssStyle="color:red"/>
  			</tr>
  			
	   
    		<tr>
    		<td colspan="2"><input type="submit" value="submit" class="menu" id="viewReportButton"></td></tr>
     </form:form>
	</table>
	</div>
	<div id=viewReport2>
	<h3 id="titleForm">View Passenger List</h3>
	
	<c:url var="myAction" value="/processViewPassengerDetails.htm"/>
		
	<table class="tloginBody4">
	<form:form method="post" modelAttribute="flightInfoDTO" action="${myAction}">
  		<tr><td>Select Flight ID:<span style="color:red">*</span></td>
		<td>
			<form:select path="flightNo">
    		<form:option value="" label="Please Select"/>
    		<form:options items="${flightNumbersList}" itemLabel="flightNo" itemValue="flightNo"/>
    		</form:select></td>
    		<tr>
  			          <td><form:errors path="flightNo" cssStyle="color:red"/>error</td>		
  			</tr>
  			<tr></tr>
  			<tr></tr>
    		<tr>
    		<td align="center"><input type="submit" value="Passenger List" class="menu" id="viewReportButton"></td>		
  			</tr>
 
     </form:form>
	</table>
	</div>
	
	<div id=viewReport3>
	<h3 id="titleForm">View Booking List</h2>
	<c:url var="myAction" value="/processViewBookingDetails.htm"/>
	
	<table class="tloginBody4">
	<form:form method="post" modelAttribute="flightInfoDTO" action="${myAction}">
  		<tr><td>Select Flight ID:<span style="color:red">*</span></td>
		<td>
			<form:select path="flightNo">
    		<form:option value="" label="Please Select"/>
    		<form:options items="${flightNumbersList}" itemLabel="flightNo" itemValue="flightNo"/>
    		</form:select></td></tr>
    		<tr>
  			          <td><form:errors path="flightNo" cssStyle="color:red"/>error</td>		
  				</tr>
    	</tr>
    	<tr></tr>
  		<tr></tr>
    		<tr>
    		<td align="center"><input type="submit" value="submit" class="menu" id="viewReportButton"></td>
    		</tr>
     </form:form>
	</table>
	</div>
	</div>



<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
</body>
</html>
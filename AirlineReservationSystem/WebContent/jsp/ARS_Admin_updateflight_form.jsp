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
	<c:url var="myAction" value="/processUpdateFlightForm.htm" />	
	<table class="taddFlightBody">
	<caption>Update Flight Form</caption>
	<form:form method="POST" modelAttribute="flightInfoDTO" action="${myAction}">
	        <tr>
				<td><label>Flight Number:<span style="color:red">*</span></label></td>
				<td><form:input path="flightNo" readonly="true"/>
				</td>
            </tr>
	   
			<tr>
				<td><label>Airline:<span style="color:red">*</span></label></td>
				<td><form:input path="airline"/></td>
                <td><form:errors path="airline" cssStyle="color:red"/></td> 
            </tr>
			<tr><td>Departure Airport:<span style="color:red">*</span></td>
			<td>
			<form:select path="departureAirportId">
    		<form:option value="" label="Please Select"/>
    		<form:options items="${airportList}" itemLabel="airportName" itemValue="airportId"/>
    		</form:select></td>
  			<td><form:errors path="departureAirportId" cssStyle="color:red"/></td>
  			</tr>
  			
  			
  			<tr><td>Arrival Airport:<span style="color:red">*</span></td>
			<td>
			<form:select path="arrivalAirportId">
    		<form:option value="" label="Please Select"/>
    			<form:options items="${airportList}" itemLabel="airportName" itemValue="airportId"/>
    		</form:select>
    		</td>
  			<td><form:errors path="arrivalAirportId" cssStyle="color:red"/><span style="color: red">${sameCityError}</span></td>
			</tr>
			<tr>
				<td><label>Departure Date:<span style="color:red">*</span></label></td>
				 <td><form:input path="departureDate"  placeholder="select date"/></td>
				 <td><form:errors path="departureDate" cssStyle="color:red"/></td>  
	       </tr>
				
			<tr>
				<td><label>Arrival Time:<span style="color:red">*</span></label></td>
				 <td><form:input path="arrivalDate" placeholder="select date"/></td>
				 <td><form:errors path="arrivalDate" cssStyle="color:red"/></td>  
	       </tr>
				
			<tr>
				<td><label>Departure Time:<span style="color:red">*</span></label></td>
				 <td><form:input path="departureTime"  placeholder="select departure time"/></td>
				 <td><form:errors path="departureTime" cssStyle="color:red"/></td>  
	       </tr>
				
			<tr>
				<td><label>Arrival Time:<span style="color:red">*</span></label></td>
				 <td><form:input path="arrivalTime" placeholder="select arrival time"/></td>
				<td><form:errors path="arrivalTime" cssStyle="color:red"/><span style="color: red">${sameTimeError}</span></td>  
	       </tr>
	       <tr>
				<td><label>Number of First Class seats:<span style="color:red">*</span></label></td>
				 <td><form:input path="firstSeats" placeholder="select date"/></td>
				 <td><span style="color: red">${firstseatError}</span></td> 
	       </tr>
	       <tr>
				<td><label>First  Class Seat Fare:<span style="color:red">*</span></label></td>
				 <td><form:input path="firstSeatFare" placeholder="select date"/></td>
				 <td><span style="color: red">${firstseatFareError}</span></td>  
	       </tr>
	       <tr>
				<td><label>Number of Business Class seats:<span style="color:red">*</span></label></td>
				 <td><form:input path="businessSeats" placeholder="select date"/></td>
				 <td><span style="color: red">${bussseatError}</span></td>
	       </tr>
	        <tr>
				<td><label>Business Class Seat Fare:<span style="color:red">*</span></label></td>
				 <td><form:input path="businessSeatFare" placeholder="select date"/></td>
				<td><span style="color: red">${bussseatFareError}</span></td> 
	       </tr>
			<tr>
				<td colspan="3" align="center"><input  type="submit" value="Update"></td>
			</tr>
			<tr><td colspan="3" align="center"><h3><span style="color:green">${successMsg}</span></h3></td></tr>
	</form:form>
	</table>
	</div>



<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
    
</div>
</body>
</html>
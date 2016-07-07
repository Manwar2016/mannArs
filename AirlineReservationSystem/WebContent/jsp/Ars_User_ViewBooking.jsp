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
 <nav>
     
       <list><a href=""><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>
       
       
      
      </nav>	  
    </div>
       
     
</header>
<h1> Booking Details</h1>
<table border="1" align="center">
<tr>
			<th>Booking Id</th>
			<th>Flight Number</th>
			<th>Arrival City</th>
			<th>Departure City</th>
			<th>Customer Email</th>
			<th>Number of Passengers</th>
			<th>Total Fare</th>
			
			
		</tr>


 <c:forEach var="bookingInfo" items="${bookingInfoList}">

 	
		
		<tr>
			<td><c:out value="${bookingInfo.bookingId}" /></td>
			<td><c:out value="${bookingInfo.flightNo}" /></td>
			<td><c:out value="${bookingInfo.arrivalCity}" /></td>
			<td><c:out value="${bookingInfo.departureCity}" /></td>
			<td><c:out value="${bookingInfo.customerEmail}" /></td>
			<td><c:out value="${bookingInfo.numPassengers}" /></td>
			<td><c:out value="${bookingInfo.totalFare}" /></td>
			<td><a href="http://localhost:8080/AirlineReservationSystem/loadUpdateBooking.htm?id=${bookingInfo.bookingId}"><input type="submit" value="Update"/></a></td>
			<td><a href="http://localhost:8080/AirlineReservationSystem/loadDeleteBooking.htm?id=${bookingInfo.bookingId}"><input type="submit" value="Delete"/></a></td>
		</tr>

 </c:forEach>

</table>

</div>



<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
</body>
</html>
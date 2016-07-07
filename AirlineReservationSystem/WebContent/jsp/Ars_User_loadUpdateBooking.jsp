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
<h1>Update Passenger</h1>




		
<table border="1" align="center">
<tr>
			<th>Booking Id</th>
			<th>Passenger Id</th>
			<th>First Name</th>
			<th>LastName</th>
			<th>Mobile Number</th>
			<th>Gender</th>
		</tr>
	


 <c:forEach var="passengers" items="${passengersList}">

 	
		
		<tr>
			<td><c:out value="${passengers.bookingId}" /></td>
			<td><c:out value="${passengers.passengerId}" /></td>
			<td><c:out value="${passengers.firstName}" /></td>
			<td><c:out value="${passengers.lastName}" /></td>
			<td><c:out value="${passengers.mobileNo}" /></td>
			<td><c:out value="${passengers.gender}" /></td>
			<td><a href="http://localhost:8080/AirlineReservationSystem/getBookingList.htm?id=${passengers.passengerId}"><input type="submit" value="Update"/></a></td>
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
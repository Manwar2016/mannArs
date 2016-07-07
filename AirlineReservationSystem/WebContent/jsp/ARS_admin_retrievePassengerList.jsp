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
<link href="/AirlineReservationSystem/css/table.css" rel="stylesheet" type="text/css"/>
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

<c:url var="myAction" value="/processViewPassengerDetails.htm" />

<c:if test="${allPassenegerList ne null}">
<div>
<table class="responstable1">
  <tr>

   
    <th>bookingId</th>
    <th>passengerId</th>
    <th>firstName</th>
	<th>lastName</th>
	<th>mobileNo</th>
	

  </tr>
  <c:forEach var="passengerDTO" items="${allPassenegerList}"> 
    <tr>

    <td>${passengerDTO.bookingId}</td>
    <td>${passengerDTO.passengerId}</td>
	<td>${passengerDTO.firstName}</td>
	<td>${passengerDTO.lastName}</td>
	<td>${passengerDTO.mobileNo}</td>
    
  </tr>
  </c:forEach>
</table>
</div>
</c:if>

</div>
<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br></div>
  
</div>
</div>
</body>
</html>
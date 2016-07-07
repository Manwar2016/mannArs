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

<c:url var="myAction" value="/getFlightInfo.htm" />
<table class="tsearchFlight">
<caption>Search Flight For Update</caption>
<form:form method="post" modelAttribute="flightInfoDTO" action="${myAction}">
  			<tr><td>Select Flight Number:<span style="color:red">*</span></td>
			<td>
			<form:select path="flightNo">
    		<form:option value="" label="Please Select flight number"/>
    			<form:options items="${flightNumbersList}" itemLabel="flightNo" itemValue="flightNo"/>
    		</form:select>
    		</td>
    		<td><input type="submit" value="OK" class="menu"/></td>
  			<td><form:errors path="flightNo" cssStyle="color:red"/></td>
			</tr>	
<br/>
<br/>		
</form:form>
</table>
<c:if test="${flightInfoList eq null}">
<h2 style="color: red">${errormsg}</h2>
</c:if>
<c:if test="${flightInfoList ne null}">
<div>
<table class="responstable1">
  <tr>
    <th>Flight Number</th>
    <th data-th="Driver details"><span>Airline</span></th>
    <th>Arrival Airport Id</th>
    <th>Departure Airport Id</th>
    <th>Departure Date(yyyy-mm-dd)</th>
	<th>Arrival Date(yyyy-mm-dd)</th>
	<th>Departure Time(hh:mm)</th>
    <th>Arrival Time(hh:mm)</th>
    <th>First Class Seats</th>
	<th>First Class Seat Fare(INR)</th>
	<th>Business Class Seats</th>
	<th>Business Seats Fare(INR)</th>
	<th>Action</th>
  </tr>
  <c:forEach var="flightInfoDTO" items="${flightInfoList}"> 
    <tr>
    <td>${flightInfoDTO.flightNo}</td>
    <td>${flightInfoDTO.airline}</td>
    <td>${flightInfoDTO.arrivalCity}</td>
	<td>${flightInfoDTO.departureCity}</td>
	<td>${flightInfoDTO.departureDate}</td>
    <td>${flightInfoDTO.arrivalDate}</td>
    <td>${flightInfoDTO.departureTime}</td>
	<td>${flightInfoDTO.arrivalTime}</td>
	<td>${flightInfoDTO.firstSeats}</td>
	<td>${flightInfoDTO.firstSeatFare}</td>
	<td>${flightInfoDTO.businessSeats}</td>
	<td>${flightInfoDTO.businessSeatFare}</td>
	<td><a href="loadUpdateFlightForm.htm?flightNo=${flightInfoDTO.flightNo}"><input type="button" value="UPDATE" id="update"/></a></td>
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
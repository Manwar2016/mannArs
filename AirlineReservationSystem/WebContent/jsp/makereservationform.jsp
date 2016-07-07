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
     
       <list><a href=""><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>  
      </nav>	  
    </div>
       
     
</header>
<div id="loggedUser"><h3 style="color: green">Welcome ${sessionScope.userName}</h3></div>
	<h2 id="titleForm">Reservation Form</h2>
	
	<c:url var="myAction" value="/AirlineReservationSystem/operation.htm?option=makeReservation" />	
	
	<table class="tloginBody4">
	<form:form method="POST" modelAttribute="flightInfoDTO" action="${myAction}">
	 
	   
			<tr>
				<td><label>From:<span style="color:red">*</span></label></td>
				<td><form:select path="departureCity"> 
				<form:option value="" label="Select a City"/>
				<form:options items="${cityList}" itemValue="departureCity" itemLabel="departureCity"/>
				 </form:select>
				</td>
               <td><form:errors path="departureCity" cssStyle="color:red"/></td> 
               </tr>

				 
				
			<tr>
				<td><label>To:<span style="color:red">*</span></label></td>
				<td><form:select path="arrivalCity"> 
				<form:option value="" label="Select a City"/>
				<form:options items="${cityList}" itemValue="arrivalCity" itemLabel="arrivalCity"/>
				 </form:select>
				</td>
               <td><form:errors path="arrivalCity" cssStyle="color:red"/></td> 
               </tr>
			
				
			<tr>
				<td><label>Departure Date:<span style="color:red">*</span></label></td>
				 <td><form:input path="departureDate" placeholder="select date"/></td>
				 <td><form:errors path="departureDate" cssStyle="color:red"/></td>  
	       </tr>
				
			<tr>
				<td><label>Arrival Date:<span style="color:red">*</span></label></td>
				 <td><form:input path="arrivalDate" placeholder="select date"/></td>
				 <td><form:errors path="arrivalDate" cssStyle="color:red"/></td>  
	       </tr>
					
				<tr>
                     <td>Class Type:<span style="color:red">*</span></td>
                     <td>
                     <form:radiobutton path="classType" value="businessClass" label="BusinessClass"/></td>
                     <td><form:radiobutton path="classType" value="firstClass" label="FirstClass"/></td>
                     <td><form:errors path="classType" cssStyle="color:red"/></td> 
                  </tr>
				
				 <tr>
				 <td><label>Number of Passengers:<span style="color:red">*</span></label></td>
				 <td><form:input path="numPassengers" placeholder="Enter no. of passengers"/></td>
				 <td><form:errors path="numPassengers" cssStyle="color:red"/></td>  
	       </tr>
				
			<tr>
				<td colspan="3" align="center"><input  type="submit" value="Find Flights"></td>
			</tr>
		
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
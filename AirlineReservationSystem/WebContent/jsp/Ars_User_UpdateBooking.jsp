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

<c:url var="myAction" value="updateBooking.htm" />

<table class="tloginBody">
<form:form method="post" modelAttribute="passengerDTO" action="${myAction}">

			<tr><td>PassengerId:<span style="color:red">*</span></td>
			<td><form:input path="passengerId"  value="${passengers.passengerId}" readonly="true" /></td>
			<td><form:errors path="passengerId" cssStyle="color:red"/></td></tr>
			
			<tr><td>First Name:<span style="color:red">*</span></td>
			<td><form:input path="firstName"  value="${passengers.firstName}" readonly="true"/></td>
			<td><form:errors path="firstName" cssStyle="color:red"/></td> </tr> 
			
			<tr><td>Last Name:<span style="color:red">*</span></td>
			<td><form:input path="lastName" value="${passengers.lastName}" readonly="true"/></td>
			<td><form:errors path="lastName" cssStyle="color:red"/></td> </tr> 
			
			<tr><td>Email Id:<span style="color:red">*</span></td>
			<td><form:input path="emailId" value="${passengers.emailId}"/></td></tr>
			<tr><td><form:errors path="emailId" cssStyle="color:red"/></td>  </tr>
			
			<tr><td>Mobile Number:<span style="color:red">*</span></td>
			<td><form:input path="mobileNo" value="${passengers.mobileNo}"/></td></tr>
			<tr><td><form:errors path="mobileNo" cssStyle="color:red"/></td>  </tr>
			
			
			<tr>
            <td>Gender:<span style="color:red">*</span></td>
            <td>
            <form:input path="gender" value="${passengers.gender}" readonly="true" /></td>
            <td><form:errors path="gender" cssStyle="color:red"/></td> 
            </tr>
            
            <tr><td colspan="2" align="center"><input align="center" type = "submit" value = "Update" /></td></tr>
			<h3 style="color:red">${errorMsg}</h3>
</form:form>
</table>



</div>



<div class="footer">
       <div id="footer1">Copyright &copy; igate.ars.com<br>
</div>
  
</div>
</div>
</body>
</html>
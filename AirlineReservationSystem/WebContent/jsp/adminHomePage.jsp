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
      <div id="logUser">Logged User<br><span style="color: green">${userName}</span><br>
      <a href="logOut.htm">Log Out</a>
      </div>
 <nav>
       <list><a href=""><input type="button" value="About Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Contact Us" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Services" class="menu"/></a></list>
       <list><a href=""><input type="button" value="Terms And Conditions" class="menu"/></a></list>
      </nav>	  
    </div>
    
</header>
<div id="loggedUser"><h3 style="color: green">Welcome ${sessionScope.userName}</h3></div>

	
	<table class="tloginBody4">
	<tr><td><a href="loadAddFlight.htm">Add Flight</a></td></tr>
	<tr><td><a href="loadUpdateFlight.htm">Update Flight</a></td></tr>
	<tr><td><a href="cancelFlight.htm">Cancel Flight</a></td></tr>
	<tr><td><a href="loadViewReport.htm">View Reports</a></td></tr>
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
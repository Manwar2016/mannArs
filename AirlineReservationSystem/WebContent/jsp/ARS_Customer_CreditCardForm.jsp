<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit Card Form</title>
<link href="/AirlineReservationSystem/css/arsStyle.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="/AirlineReservationSystem/javascript/validation.js"></script>
</head>
<body>

	<div id="page" align="center">
		<div class="main">
			<header>
			<div align="center" id="topHeader">
				<h1 id="headerMain">AirLine Reservation System</h1>
				<nav> <list> <a href=""><input type="button" value="About Us" class="menu" /></a></list>
				      <list> <a href=""><input type="button" value="Contact Us" class="menu" /></a></list>
				      <list> <a href=""><input type="button" value="Services" class="menu" /></a></list>
				      <list> <a href=""><input type="button" value="Terms And Conditions" class="menu" /></a></list>
				      <list> <a href=""><input type="button" value="Log Out" class="menu" /></a></list>
			    </nav>
			</div>
			</header>
			
			<div class="mainBody1">


				<div id="signup">
				
				</div>
			<c:url var="myAction" value="/processCreditCardForm.htm"></c:url>
				<table class="signup">
					<caption>Credit Card Form</caption>
			<form:form action="${myAction}" method="post" modelAttribute="creditCardDTO">
			<tr>
				<td>Card Type:</td>
					<td><form:radiobutton path="cardType" value="masterCard" label="Master Card" />
					<form:radiobutton path="cardType" value="visa" label="Visa" /></td>
				<td><form:errors path="cardType"></form:errors></td>
			</tr>
			<tr>
				<td>Card Holder:</td>
				<td><form:input path="cardHolder" id="cardHolder"></form:input></td>
				<td><form:errors path="cardHolder"></form:errors></td>
			</tr>
			<tr>
				<td>Card Number:</td>
				<td><form:input path="cardNumber" id="cardNumber"></form:input></td>
				<td><form:errors path="cardNumber"></form:errors></td>
			</tr>
			<tr>
				<td>Expiry Date:</td>
				<td><form:input path="expiryDate" id="expiryDate"></form:input></td>
				<td><form:errors path="expiryDate"></form:errors></td>
			</tr>
			<tr>
				<td>CVV:</td>
				<td><form:input path="cvv" id="cvv"></form:input></td>
				<td><form:errors path="cvv"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm Booking">
				<input type="reset" onclick="reset()" value="Reset"></td>
			</tr>
		</form:form>
	</table>
	</div>
			<div class="footer1">
				<div id="footer1">
					Copyright &copy; igate.ars.com<br>
				</div>

			</div>
		</div>
	</div>
</body>
</html>

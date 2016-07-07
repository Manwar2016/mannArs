<%-- 
/*******************************************************************		
*  File Name      : ARS_user_signup.jsp	
*  Description    : This is a signup page in which user can do register for using the application	 	
*  Author         : 835845(Manwar Singh)	
*  Last Edited By : 835845(Manwar Singh)	
*  Version        : 1.0
*  Since          : 	
*  Style Sheets   : arsStyle.css	
*  Scripts        : validation.js	
*  Created on     : Oct 16, 2015		
*  History	
*  Modified By    : 
*****************************************************************/	
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
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
				<c:url var="myAction" value="/addUser.htm" />

				<table class="signup">
					<caption>SignUp Form</caption>
					<form:form onsubmit="" method="post" modelAttribute="userDTO"
						action="${myAction}">
						<tr>
							<td>User Name:<span style="color: red">*</span></td>
							<td><form:input path="userName" placeholder="enter your name" title="please enter characters only" /></td>
							<td><form:errors path="userName" cssStyle="color:red" /></td>
							<td id="nameErr"></td>
						</tr>
						<tr>
							<td>Phone number:<span style="color: red">*</span>
							</td>
							<td><form:input path="mobileNo" placeholder="enter your phone number" title="please enter 10 digit" /></td>
							<td><form:errors path="mobileNo" cssStyle="color:red" /></td>
							<td id="phoneErr"></td>
						</tr>
						<tr>
							<td>Password: <span style="color: red"> * </span></td>
							<td><form:password path="password" placeholder="enter your password" title="please enter your password" /></td>
							<td><form:errors path="password" cssStyle="color:red" /></td>
						</tr>
						<tr>
							<td>Confirm Password :<span style="color: red"> * </span></td>
							<td><form:password path="confirmPassword" placeholder="enter your password" title="please re-enter your password" /></td>
							<td><form:errors path="confirmPassword" cssStyle="color:red" /></td>
							<td id="passwordErr"><h4 Style="color:red">${passwordValidMsg}</h4></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" value="Submit" /> <input type="reset" value="Clear" /></td>
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
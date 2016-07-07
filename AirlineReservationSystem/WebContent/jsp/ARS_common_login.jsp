<%-- 
/*******************************************************************	
*	
*  File Name      : ARS_Common_login.jsp	
*  Description    : <Describe what the HTML/JSP does>	
*  	
*  Author         : 835845(Manwar Singh)	
*  Last Edited By : 835845(Manwar Singh)	
*  Version        : 1.0
*  Since          : 	
*  Style Sheets   : arsStyle.css	
*  Scripts        : 	
*  Created on     : Oct 16, 2015		
*  History	
*  Modified By    : 835845 on  Oct 19, 2015	
*                 : add error message
*	
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

<c:url var="myAction" value="/processLogin.htm" />

<table class="tloginBody">
<caption>Login Form</caption>
	<form:form  modelAttribute="loginDTO" action="${myAction}">
			<tr><td>Name:</td>
			<td><form:input path="userName" placeholder="enter your name" title="please enter characters only"/></td>
			<tr><td>Password:</td>
			<td><form:password path="password" placeholder="enter your password"/></td>
			<tr><td colspan="2" align="center"><input type ="submit" value = "Login" /></td></tr>
			<tr><td colspan="2" align="center" style="color:red">
			<form:errors path="userName" cssStyle="color:red"/>${errorMsg}</td></tr>
			<tr><td colspan="2" align="center"><a href="loadSignup.htm">SignUp</a></td></tr>
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
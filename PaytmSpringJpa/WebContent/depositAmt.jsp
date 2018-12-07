<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="customerbal" action="insertNo" method="post">
		<table>
			<tr>
				<td>Enter Mobile No:</td>
				<td><form:input path="mobileNo" size="10"  /> 
				<form:errors path="mobileNo" cssStyle="color:red" cssClass="error" /></td></tr>			
			<tr>	<td>Enter Amount:</td>
				<td><form:input path="balance" size="10"  /> 
				<form:errors path="balance" cssStyle="color:red" cssClass="error" /></td></tr>
			<tr>	<td><input type="submit" value="Deposit Amount" /></td></tr>				
		</table>
</form:form>
</body>
</html>
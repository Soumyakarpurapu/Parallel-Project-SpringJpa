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
<form:form modelAttribute="customerbal" action="fundtr" method="post">
		<table>
			<tr>
				<td>Enter your Mobile No:</td>
				<td><input type="text" name="SNumber" /> 
				<form:errors path="mobileNo" cssStyle="color:red" cssClass="error" /></td></tr>
		<tr><td>Enter Mobile No to which money is to Transfered:</td>
				<td><input type="text" name="RNumber" /> 
				<form:errors path="mobileNo" cssStyle="color:red" cssClass="error" /></td>	</tr>	
			<tr>	<td>Enter Amount:</td>
				<td><form:input path="balance" size="10"  /> </td>
				<form:errors path="balance" cssStyle="color:red" cssClass="error" /></tr>
				<tr><td><input type="submit" value="Transfer Amount" /></td></tr>
		</table>
</form:form>
</body>
</html>
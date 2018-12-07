<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Your Details</h1>
	<f:form modelAttribute="customer" action="save" method="post">
		<table>
			<tr>
				<td>Enter Mobile Number</td>
				<td><f:input path="mobileNo" size="10" /> 
					<f:errors path="mobileNo" cssStyle="color:red" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Your Name</td>
				<td><f:input path="name" size="15" /> 
				<f:errors path="name" cssStyle="color:red" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Enter Balance to initialize</td>
				<td><f:input path="balance" size="15" /> 
				<f:errors path="balance" cssStyle="color:red" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="Create Account" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
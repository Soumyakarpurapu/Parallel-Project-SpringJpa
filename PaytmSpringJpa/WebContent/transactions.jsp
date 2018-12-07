<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="for"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=2>
<tr>
<th>TranId<th>MobileNo<th>TranType<th>Amount</th>
</tr>

<for:forEach var="transactions" items="${list}">
<tr>
<td><c:out value="${transactions.tranId}"></c:out></td>
<td><c:out value="${transactions.mobNo}"></c:out></td>
<td><c:out value="${transactions.tranType}"></c:out></td>
<td><c:out value="${transactions.amount}"></c:out></td>
</tr>
</for:forEach>

</table>
<a href="Welcome.jsp">Click here to go to Main Menu</a>
</body>
</html>
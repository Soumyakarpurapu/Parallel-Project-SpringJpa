<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paytm App</title>
</head>
<body>
<h1>Welcome to Paytm App</h1>
<table border="3">
<tr><td><h3>Pick your operations</h3></td></tr>
<tr><td><a href="createAccount">Create a new account</a></td></tr>
<tr><td><a href="showBalance">Show Balance</a></td></tr>
<tr><td><a href="depositAmount">Deposit Amount</a></td></tr>
<tr><td><a href="withdrawAmount">Withdraw Amount</a></td></tr>
<tr><td><a href="transferAmount">Transfer Amount</a></td></tr>
<tr><td><a href="printTransactions">Print Transactions</a></td></tr>
</table>
</body>
</html>
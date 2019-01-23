<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Transaction Id</th>
			<th><a href="sortByName.mm">Account Number</a></th>
			<th>Amount</th>
			<th>current Balance</th>
			<th>Type Of Transaction</th>
			<th>Date and Time</th>
		</tr>
	<jstl:if test="${transactions!=null}">
		<tr>
			<td>${transactions.transactionId}</td>
			<td>${transactions.accountNumber}
		
		</tr>	
	
	</jstl:if>
	
	</table>
</body>
</html>
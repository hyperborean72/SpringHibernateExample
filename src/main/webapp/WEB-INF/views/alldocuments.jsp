<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Documents</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>

<body>
	<h2>All Uploaded Documents</h2>	
	<table>
		<tr>
			<td>NAME</td><td>DATE</td><td>CODE (click to update)</td><td></td>
		</tr>
		<c:forEach items="${documents}" var="document">
			<tr>
			<td>${document.name}</td>
			<td>${document.date}</td>
			<td><a href="<c:url value='/edit-${document.code}-document' />">${document.code}</a></td>
			<td><a href="<c:url value='/delete-${document.code}-document' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Document</a>
</body>
</html>
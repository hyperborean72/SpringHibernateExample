<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Items</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>

<body>
	<h2>All Uploaded Items</h2>
	<table>
		<tr>
			<td>NAME</td><td>PRICE</td><td>PARENT DOCUMENT</td>
		</tr>
		<c:forEach items="${documentItems}" var="documentItem">
			<tr>
			<td>${documentItem.name}</td>
			<td>${documentItem.price}</td>
			<%--td><a href="<c:url value='/edit-${document.code}-document' />">${document.code}</a></td--%>
			<td>${documentItem.document.name}</td>
			</tr>
		</c:forEach>
	</table>
	<%--br/>
	<a href="<c:url value='/new' />">Add New Document</a>
	<br/>
    <a href="<c:url value='/listItems' />">List Items</a--%>
</body>
</html>
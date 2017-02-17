<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
</head>
<body>
	message : ${success}
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">All Documents</a>
	<br/>
    <br/>
    or create associated <a href="<c:url value='/newItem' />">New Document Item</a>
    <br/>
    <br/>
    or list <a href="<c:url value='/listItems' />">Document Items</a>
	
</body>
</html>
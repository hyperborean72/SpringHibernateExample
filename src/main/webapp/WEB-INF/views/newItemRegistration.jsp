<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Item Registration Form</title>

<style>
	.error {
		color: #ff0000;
	}
</style>
</head>

<body>

	<h2>Item Registration Form</h2>
 
	<form:form method="POST" modelAttribute="documentItem">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="price">Price: </label> </td>
				<td><form:input path="price" id="price"/></td>
				<td><form:errors path="price" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="document">Document: </label></td>
				<td>
					<form:select path="document" id="document">
						<form:options items="${documents}" itemLabel="name" itemValue="id"/>
					</form:select>
				</td>
				<td></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
    	Return to <a href="<c:url value='/list' />">List of Documents</a>
</body>
</html>
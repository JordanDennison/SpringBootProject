<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<style>
	body {
		justify-content: center;
		align-items: center;
		height: 100vh;
	}
</style>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<!-- <link rel="stylesheet" href="../Views/styles.css" type="text/css"> -->

	<title>Welcome Page</title>
</head>

<html>	
	<body>

		<!-- Navbar -->
		<%@ include file="Navbar.jsp" %>

		<c:choose>

			<c:when test="${firstLogin == 1}">
				<h1> Welcome, new user ${sessionScope.email}</h1>
			</c:when>

			<c:otherwise>
				<h1> Welcome back ${sessionScope.email}</h1>
			</c:otherwise>
		</c:choose>

	</body>
</html>
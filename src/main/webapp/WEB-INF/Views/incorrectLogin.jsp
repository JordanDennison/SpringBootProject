<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="../Views/styles.css" type="text/css">

	<title>Login Page</title>
</head>

<html>
	
	<head>
		<title>Fusion Internship</title>
	</head>
	
	<body>

		<!-- Navbar -->
		<%@ include file="Navbar.jsp" %>

		<h1> Fusion Internship Project</h1>

		<form action="/login" method="post">

			<input type="text" name="email" placeholder="Email"/>

			<input type="password" name="password" placeholder="Password"/>

			<button type="submit">Login</button>
		
		</form>

		<p style="color: red;"> Login information incorrect </p>

		<a href="/oauth2/authorization/google">Login with Google</a>

	</body>
	
</html>
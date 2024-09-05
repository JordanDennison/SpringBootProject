<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

	<head>
		
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
		
		<!-- Add css and images folder to fix error -->
		<link href="/resources/css/Home.css" rel="stylesheet" type="text/css">

		<title>Login Page</title>
	</head>


	<body id="main-body">
		
		<!-- Navbar -->
		<%@ include file="Navbar.jsp" %>
		

		<div class="container text-center" style="vertical-align: center;">

			<!-- Title DIV -->
			<div class="row" style="margin-top: 40px;">
				<div class="col">
					<h1> Fusion Internship Project</h1>
				</div>
			</div>

			<!-- Regular Login Form -->
			<div class="row">
				
				<div class="col">
					
					<form action="/login" method="post" style="align-content: center;">
						
						<div class="row">
							<div class="col" id="form-column">
								<input id="input-field" type="text" name="email" placeholder="Email"/>
							</div>
						</div>

						<div class="row">
							<div class="col" id="form-column">
								<input id="input-field" type="password" name="password" placeholder="Password"/>
							</div>
						</div>

						<div class="row">
							<div class="col" id="form-column">
								<button id="login-button" type="submit">Login</button>
							</div>
						</div>
						
					</form> 
				</div>
			</div>

			<!-- Google Login -->
			<div class="row">
				<div class="col">
					<a id="google-styling" href="/oauth2/authorization/google">Login with Google</a>
			</div>

			<!-- Card Section -->
			<div class="row" style="margin-top: 5%;">
				
				<div id="cards" class="col rounded">
					<h1>Column 1</h1>
					<p>This is an example of some sample card text that could be used in a card on the homepage.</p>
				</div>

				<div id="cards" class="col rounded">
					<h1>Column 2</h1>
					<p>This is an example of some sample card text that could be used in a card on the homepage.</p>
				</div>

				<div id="cards" class="col rounded">
					<h1>Column 3</h1>
					<p>This is an example of some sample card text that could be used in a card on the homepage.</p>
				</div>

			</div>

			<!-- Image Carousel -->
			<div class="row mx-auto p-2" style="margin-top: 50px; margin-bottom: 50px;">
				<div class="d-flex justify-content-center w-100">
					<%@ include file="ImageCarousel.jsp" %>
				</div>
			</div>
				
		</div>
	</body>
	
</html>
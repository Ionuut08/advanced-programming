<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Hplus</title>
</head>
<body>
	<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<ul class="navbar">
					<li><a href="/home">home</a></li>
					<li><a href="/search">search</a></li>
					<li><a href="/redirectToLinkedIn">linkedIn</a></li>
				</ul>
				<!-- navbar -->
			</div>
			<!-- container nav-elements -->
		</nav>
	</header>
	<!-- #home -->
	<span class="success">${dataSaved}</span>
   	<section id="login" class="section">
		<div class="container tagline">
			<em>LOGIN USER</em>
			<form:form action="/login" method="post" modelAttribute="login">
				<label>Username</label> <form:input path="username"/><br />
			    <label>Password</label> <form:input type="password" path="password"/><br />
			     <input type="submit" value="Login">
			</form:form>
			 <a class="card-title" href="/goToRegistration">Register new user? Click here</a>
		</div>
	</section>
	<!-- #products -->

</body>
</html>
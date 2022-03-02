<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Play with me</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-image: url("/images/backgrounds/outside.jpeg");
	background-size: cover;
	
}
</style>
<body>
	<h1>Play With Me</h1>
	<c:forEach items="${ thisUser.getPets()}" var="onePet">
		<div>
			<h1>${onePet.getPetName()}</h1>
			<h2>Energy: ${onePet.getEnergy()}</h2>
			<h2>Happiness: ${onePet.getHappiness()}</h2>
			<h2>Hunger: ${onePet.getHealth()}</h2>
			<h2>Clean: ${onePet.getCleanliness()}</h2>
		</div>
		<div class="container">
			<div class="row mb-4 c">
				<div class="col-md-2 p-5 gray">
					<img style="background-color: #ffffff00; border: none"
						class="img_test" src="/images/${onePet.getType()}pic.png"
						alt="Failed image: ${onePet.getType()}" />
				</div>
			</div>
		</div>
		<button>Throw Ball</button>
		<button>Tug of War</button>
		<a class="btn btn-primary" href="/play/${onePet.getId() }">Play
			Tag</a>
	</c:forEach>
	<a href="/home" class="btn btn-warning">I'm Tired</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<style>
body {
	background-image: url("/images/backgrounds/louis2BG.jpg");
	background-size: cover;
}
</style>
<body>


	<c:forEach items="${ thisUser.getPets()}" var="onePet">
		<div style="position: absolute; left: 50px;">
			<h1 style="color: #ffffff">${onePet.getPetName()}</h1>
			<h2 style="color: #ffffff;">
				My Gold:
				<c:out value="${thisUser.getGold().getGold()}" />
			</h2>

			<h2 style="color: #ffffff">Energy: ${onePet.getEnergy()}</h2>
			<progress class="progress-bar" value="${onePet.getEnergy()}"
				max="100"></progress>

			<h2 style="color: #ffffff">Happiness: ${onePet.getHappiness()}</h2>
			<progress class="progress-bar" value="${onePet.getHappiness()}"
				max="100"></progress>

			<h2 style="color: #ffffff">Hunger: ${onePet.getHealth()}</h2>
			<progress class="progress-bar" value="${onePet.getHealth()}"
				max="100"></progress>

			<h2 style="color: #ffffff">Clean: ${onePet.getCleanliness()}</h2>
			<progress class="progress-bar" value="${onePet.getCleanliness()}"
				max="10"></progress>
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
		<div class="d-flex justify-content-center">
			<div class="d-flex justify-content-around w-50 bg-danger p-2" style="position: fixed; left: 900px; top: 50px;">
				<a class="btn btn-light p-2" href="/clean/${onePet.getId() }">Clean
					Me</a> <a class="btn btn-secondary p-2" href="/feed/${onePet.getId() }">Feed
					Me</a> <a class="btn btn-primary p-2" href="/play">Play with Me</a> <a
					class="btn btn-success p-2" href="/contest/${onePet.getId() }">Contest</a>
				<a class="btn btn-info p-2" href="/sleep/${onePet.getId() }">Sleep</a>
				<a class="btn btn-warning"href="/store">Store</a>
			</div>
		</div>



	</c:forEach>
	<div style="position: fixed; left: 50px; top: 700px;">
		<a class="btn btn-danger text-dark" href="/logout">logout</a>
	</div>


</body>
</html>
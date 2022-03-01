<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Pet</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Choose your Pet</h1>
	<form:form action="/create/pet" method = "post" modelAttribute="newPet">
		<form:input type="hidden" path ="owner" value="${thisUser.id }"/>
		<div>
			<label>What will you name your pet?</label>
			<form:input type="text" path="petName"/>
			<form:errors path="petName"/>
		</div>
		<div>
			<label>What will you name your pet?</label>
			<form:select path="type">
				<option value="gorilla">Gorilla</option>
				<option value="tiger">Tiger</option>	
				<option value="wolf">Wolf</option>		
			</form:select>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>
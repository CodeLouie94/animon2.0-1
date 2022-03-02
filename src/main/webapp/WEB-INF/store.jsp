<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-image: url("/images/backgrounds/storeBG.png");
	background-size: cover;
}
</style>
<body>
	<script>
      function play() {
        var audio = document.getElementById("audio");
        audio.play();
      }
    </script>
    <audio id="audio" src="/sounds/chaching.mp3"></audio>


	<div>
		<h3>Gold: <c:out value="${thisUser.getGold().getGold()}"/></h3>
	</div>
		
		<c:choose>
			<c:when test="${thisUser.getGold().getGold() >= 50 }">
				<a href="/buylfeed" onclick="play()" class="btn btn-secondary"><button >Low Quality Feed</button></a>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-secondary" disabled>Low Quality Feed</button>
			</c:otherwise>
			
		
		</c:choose>
		<a href="/buyhfeed" onclick="play()"><button >High Quality Feed</button></a>
		<a href="/buyrope" onclick="play()"><button >Rope Toy</button></a>
		<a href="/buyball" onclick="play()"><button >Ball Toy</button></a>
		<a href="/buysoap" onclick="play()"><button >Pet Soap</button></a>	
		
	<a href="/home">Go back home</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error404.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device.width, inital-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Home page</title>
</head>
<body>
	<jsp:include page="header_home.jsp"/>
	<%
		String admin = (String) session.getAttribute("nomeAdmin");
		if (admin == null) {
	%>
	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h2>Accesso Negato</h2>
			</div>
		<div class="panel-body">
			<div>
				<p>Per poter accedere a questa pagina,</p> 
				<p>effettua il login!</p>
				<a href="login.jsp">Login</a>
			</div>
		</div>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="text-center">
	  	<div class="btn-group-vertical" style="margin-top:100px;">
	  		<div class="containter" style="width:200px;">
			    <a class="btn btn-primary btn-block" href="inserisci.jsp" style="margin-top:20px;">Inserisci</a>
				<a class="btn btn-primary btn-block" href="visualizzastatistiche.jsp" style="margin-top:20px;">Visualizza</a>
				<a class="btn btn-primary btn-block" href="elimina.jsp" style="margin-top:20px;">Elimina</a>
			</div>
	  	</div>
	</div>
	<%
		}
	%>
	<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
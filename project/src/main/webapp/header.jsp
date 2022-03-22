<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device.width, inital-scale=1">
<link rel="stylesheet" href="css/style.css">
</head>
<body>




<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle"
			data-toggle="collapse"
			data-target="#mioMenu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">
            <img src="img/apple.jpg"
			style="max-width: 50px; height: auto; margin-top: -7px;">
		
            </a>
		</div>
		<div class="collapse navbar-collapse" id="mioMenu">
		<%
			//session.setAttribute("nomeAdmin", "CarloMartello");
			String admin = (String) session.getAttribute("nomeAdmin");
			if (admin == null) {
			%> 
		<ul class="nav navbar-nav navbar-right">
			<li><a href="registra.jsp">
			<span class="glyphicon glyphicon-user"></span> Sign-Up
			</a></li>
			<li><a href="login.jsp">
			<span class="glyphicon glyphicon-log-in"></span> Login
			</a></li>
		</ul>
		<%
			} else {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Benvenuto <%=admin%></a></li>
            <li>
					<form action="/<%=application.getServletContextName()%>/logout"
						method="post">
						<input type="submit" class="btn btn-danger navbar-btn"
							value="Logout" />
					</form>
				</li>
		</ul>
		
		<%
			}
		%>
	</div>
</div>
</nav>








</body>
</html>
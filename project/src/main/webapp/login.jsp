<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("tentativo")!=null&&((int)session.getAttribute("tentativo"))>5)
	response.sendRedirect("accessonegato.jsp");
	if(session.getAttribute("nomeAdmin")!=null)
		response.sendRedirect("home.jsp");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
</head>
<body>
<jsp:include page="header-pages.jsp"/>
<div class="container" >
	<div class="page-header">
		<h3>Inserire i dati per effettuare il login da Amministratore</h3>
	</div>
	<form action="/<%= application.getServletContextName()%>/login" method="post" class="form-horizontal">
	
		<div class="form-group">
			<label class="col-md-2 control-label">Codice Amministratore</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="number" name="codAdmin"placeholder="Codice Amministratore....."class="form-control">
				</div>
			</div>
			<div class="col-md-6 control-label" ></div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label">Nome Amministratore</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="nomeAdmin"placeholder="Nome Amministratore....."class="form-control">
				</div>
			</div>
			<div class="col-md-6 control-label" ></div>
		</div>
		
		<div class="row">
			<div class="col-md-5 control-label" ><%if(session.getAttribute("tentativo")!=null){
				%>Tentativi rimasti:
				<%= 6-(int)session.getAttribute("tentativo") %>
			<%} %></div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-primary">
					Invia&nbsp;<span class="glyphicon glyphicon-log-in"></span>
				</button>
			
			
			</div>
		
		</div>
	</form>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
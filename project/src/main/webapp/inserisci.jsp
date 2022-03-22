<%@page import="com.project.facade.AdminFacade"%>
<%@page import="com.project.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error404.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Inserisci</title>
</head>
<body>
<jsp:include page="header-pages.jsp"/>
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
	<div class="container">
	<h3>Inserire dati del corsista</h3>
	<form action="<%=request.getContextPath()%>/Inserisci" method="post">
	<div class="form-group">
	<div class="mb-3 col-md-3">
		<label for="nome" class="form-label">Nome</label>
		<input type="text" class="form-control" name="nome" 
		placeholder="Nome..." required >
		<br>
		<label for="cognome" class="form-label">Cognome</label>
		<input type="text" class="form-control" name="cognome" 
		placeholder="Cognome..." required >
		<br>
			<div class="dropdown">
  				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   				 Lista corsi
   				<span class="caret"></span>
  				</button>
  				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		  		<%
		  			Corso[] corsi = AdminFacade.getInstance().corsiDisp();
					for (Corso c : corsi) {
		  		%>
			    	<li><a class="dropdown-item" id="corso"><%=c.getNomeCorso()%></a></li>
			    <%
					}
			    %>
			    </ul>
			</div>
		<br>
		<button type="submit" class="btn btn-outline-info">Registra corsista</button>
	</div>
	</div>
	</form>
	</div>
	<%
		}
	%>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
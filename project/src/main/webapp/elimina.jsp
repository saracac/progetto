<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.businesscomponent.model.Corso" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device.width, inital-scale=1">
<link rel="stylesheet" href="css/style.css">
	<title>Eliminazione corsi</title>
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
	<div class="page-header">
		<h3>Scegli quali corsi vuoi eliminare</h3>
	</div>
		<form action="/<%=application.getServletContextName()%>/Elimina" method="post">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Nome corso</th>
						<th>Data inizio</th>
						<th>Data fine</th>
					</tr>
				</thead>
				<tbody>
				<%
					Corso[] corsi = (Corso[]) session.getAttribute("corsi");
					for (Corso corso : corsi) {
				%>
				<tr>
					<td><input type="checkbox" name="corso" value="<%=corso.getCodCorso()%>"/></td>
					<td><%=corso.getNomeCorso()%></td>
					<td><%=corso.getDataInizio()%></td>
					<td><%=corso.getDataFine()%></td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
			<input type="submit" value="Conferma" />
		</form>
</div>
	<%
		}
	%>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
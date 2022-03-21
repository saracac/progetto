<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.businesscomponent.model.Corso" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Eliminazione corsi</title>
</head>
<body>
<div class="container">
	<div class="page-header">
		<h3>Scegli quali corsi vuoi eliminare</h3>
	</div>
		<form action="<%=application.getServletContextName()%>/Elimina" method="post">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
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
</body>
</html>
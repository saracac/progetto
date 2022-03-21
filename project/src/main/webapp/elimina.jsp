<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.businesscomponent.model.Corso" %>
<!DOCTYPE html>
<html>
<head>
	<title>Eliminazione corsi</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Elimina" method="post">
	<p>Scegli quali corsi vuoi eliminare</p>
	<table>
		<%
			Corso[] corsi = (Corso[]) session.getAttribute("corsi");
			for (Corso corso : corsi) {
		%>
		<tr>
			<td><input type="checkbox" name="corso" value="<%=corso.getCodCorso()%>"/></td>
			<td><%=corso.getNomeCorso()%></td>
			<td><%=corso.getDataInizio()%></td>
			<td><%=corso.getDataFine()%></td>
			<td></td>
		</tr>
		<%
			}
		%>
	</table>
	<input type="submit" value="Conferma" />
	</form>
</body>
</html>
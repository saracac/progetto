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
<jsp:include page="header_pages.jsp"/>
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
		<button type="submit" class="btn btn-outline-info">Registra corsista</button>
	</div>
</div>
	</form>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h3>Inserire dati del corsista</h3>
	<form action="<%=request.getContextPath()%>/Inserisci" method="post"></form>
<div class="form-group">
	<div class="mb-3 col-md-3">
		<label for="nome" class="form-label">Nome</label>
		<input type="text" class="form-control" name="nome" 
		placeholder="Nome..." required >
	</div>
<div class="form-group">
	<div class="mb-3 col-md-3">
		<label for="cognome" class="form-label">Cognome</label>
		<input type="text" class="form-control" name="cognome" 
		placeholder="Cognome..." required >
	</div>
	
</div>
</div>
<div class="mb-3 mt-5 col-md-2">
<button type="submit" class="btn btn-outline-info">Registra corsista</button>
</div>
</form>
</div>


<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
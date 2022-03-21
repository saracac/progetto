<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Inserimento</title>
</head>
<body>
	<jsp:include page="header_pages.jsp"/>
	<div class="container">
		<h3>Inserire dati del corsista</h3>
		
		
		
	<form action="<%=request.getContextPath()%>/Inserisci" method="post">

	    <div class="form-group">
        <div class="row">
            <div class="col-md-6">
                <label>First name</label>
                <input type="text" class="form-control">
            </div>
            <div class="col-md-6">
                <label>Last name</label>
                <input type="text" class="form-control">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Address</label>
        <input type="text" class="form-control">
    </div>


	  <div class="col-md-4 form-group">
	    <label for="nome" class="form-label">Nome</label> 
	    <input type="text" class="form-control" name="nome" placeholder="Nome..." required>
	  </div>
	  
	  <div class="col-md-4 form-group">
	    <label for="cognome" class="form-label">Cognome</label> 
		<input type="text" class="form-control" name="cognome" placeholder="Cognome..." required>
	  </div>
	
	<div class="form-group">
	  <button type="submit" class="btn btn-outline-info">Registra corsista</button>
	</div>
	</form>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%@page import="com.project.businesscomponent.model.Corso"%>
<%@page import="com.project.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%	AdminFacade aF=AdminFacade.getInstance(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header-pages.jsp"/>
<div class="container" >
	<div class="page-header">
		<h3>Statistiche</h3>
	<%
		Corso[] corsi = aF.getCorsiCorsista((long)session.getAttribute("cod"));
		for(Corso cor:corsi){
	%>  
	        <div class="row"> 
		        <div class="col-md-2 "><h4><%=cor.getNomeCorso() %></h4></div>
				<div class="col-md-2"> <h4><%=cor.getDataInizio() %></h4></div>
				<div class="col-md-2"><h4><%=cor.getDataFine() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getCodCorso() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getAula() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getCosto() %></h4></div>
			</div>
	<%
		}
		%>
	</div>
	</div>
	
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
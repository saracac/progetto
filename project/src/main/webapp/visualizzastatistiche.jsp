<%@page import="com.project.businesscomponent.model.Corso"%>
<%@page import="com.project.businesscomponent.model.Corsista"%>
<%@page import="com.project.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%	AdminFacade aF=AdminFacade.getInstance(); %>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Visualizzazione Statistiche</title>
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
<div class="container" >
	<div class="page-header">
		<h3>Statistiche</h3>
	</div>
	<div class="row">
			 <div class="col-md-3 bg-info">Numero Corsisti:</div>
			<div class="col-md-3"> <%=aF.corsistaTot() %></div>
			<div class="col-md-3 bg-info">Corso Più Popolare:</div>
			<%--<div class="col-md-3"> <%=aF.corsoPiuFreq() %></div>  --%>
	</div>
	<div class="row">
			<div class="col-md-3 bg-info">Data Inizio Corso:</div>
			<%--<div class="col-md-3"> <%=aF.dataInizioUltimoCorso() %></div>--%>
			<div class="col-md-3 bg-info">Durata Media Dei Corsi:</div>
			<%--<div class="col-md-3"> <%=aF.durataMediaCorsi()%></div>--%>
	</div>
	<div class="row">
			<div class="col-md-3 bg-info">Numero di Commenti:</div>
			<%--<div class="col-md-3"> <%=aF.numeroComm()%></div>--%>
			<div class="col-md-3 bg-info">Docente con più Corsi</div>
			<%-- <div class="col-md-3"> <%=aF.docentePiuCorsi()%></div>  --%>
	</div>
	<br>
	<br>
	<div class="row">
			<div class="col-md-12 bg-info">Elenco Corsisti:</div>
			
	</div>
	
	
	
	<%
	int i=0;
	Corsista[] corsisti = aF.elencoCorsisti();
	
	if(corsisti.length==0){
		%>
		<div class="row">
		<div class="col-md-12 bg-info">Nessun corsista presente! Visita la pagina dedicata per inserire il primo corsista. <a href="inserisci.jsp"> Clicca qui per inserire un corsista.</a></div>
		</div>
		<%		
	}else{
		
		%>
		
		<div class="row">
			<div class="col-md-3 bg-info">Nome</div>
			<div class="col-md-3 bg-info"> Cognome</div>
			<div class="col-md-3 bg-info">Codice</div>
			<div class="col-md-3 bg-info">Precedenti Formativi</div>
		</div>
	<%	
		for(Corsista c:corsisti){
	%>
	
	
	    <div class="row">
	      	<div class="col-md-3 "><%=c.getNomeCorsista() %></div>
			<div class="col-md-3"> <%=c.getCognomeCorsista() %></div>
			<div class="col-md-3"><%=c.getCodCorsista() %></div>
			<div class="col-md-3"><a  href="/visual?cod=<%=c.getCodCorsista()%>">Elenco Corsi Frequentati</a> </div>
	    </div>
	<%
	
		}
	}
	%>
	<br>
	<br>
	<% 
	
	Corso [] corso=aF.corsiDisp();
	if(corso.length==0){
		%>
		<div class="row">
		<div class="col-md-12 bg-info">Nessun Corso Attualmente Disponibile </div>
		</div>
		<%	
	}else{
	%>
		<div class="row bg-info">Corsi Ancora Disponibili</div>
		<% for(Corso c:corso){%>
			<div class="row">
	         
		        <div class="col-md-2 "><%=c.getNomeCorso() %></div>
				<div class="col-md-2"> <%=c.getDataInizio() %></div>
				<div class="col-md-2"><%=c.getDataFine() %></div>
				<div class="col-md-2 "><%=c.getCodCorso() %></div>
				<div class="col-md-2 "><%=c.getAula() %></div>
				<div class="col-md-2 "><%=c.getCosto() %></div>
			</div>
			
		<%}}}
%>

</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
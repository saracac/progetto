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
	
	<div class="panel-group">
	  <div class="panel panel-default">
	    <div class="row">
	      	<div class="col-md-3 "><h4><%=c.getNomeCorsista() %></h4></div>
			<div class="col-md-3"> <h4><%=c.getNomeCorsista() %></h4></div>
			<div class="col-md-3"><h4><%=c.getNomeCorsista() %></h4></div>
			<div class="col-md-3"><a data-toggle="collapse" href="#collapse1">Elenco Corsi Frequentati</a> </div>
	    </div>
	    <div id="collapse1" class="panel-collapse collapse">
	      <ul class="list-group">
	<%
		Corso[] corsi = aF.getCorsiCorsista(c.getCodCorsista());
		for(Corso cor:corsi){
	%>
	        <li class="list-group-item">
	         
		        <div class="col-md-2 "><h4><%=cor.getNomeCorso() %></h4></div>
				<div class="col-md-2"> <h4><%=cor.getDataInizio() %></h4></div>
				<div class="col-md-2"><h4><%=cor.getDataFine() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getCodCorso() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getAula() %></h4></div>
				<div class="col-md-2 "><h4><%=cor.getCosto() %></h4></div>
				
			</li>
	<%
		}
	%>
	      </ul>
	    </div>
	  </div>
	</div>
	<%
	
		}
	}
	
	Corso [] corso=aF.corsiDisp();
	if(corso.length==0){
		%>
		<div class="row">
		<div class="col-md-12 bg-info">Nessun Corso Attualmente Disponibile </div>
		</div>
		<%	
	}else{
	%>
	<div class="panel-group">
	  <div class="panel panel-default">
		<ul class="list-group">
		<% for(Corso c:corso){%>
			<li class="list-group-item">
	         
		        <div class="col-md-2 "><h4><%=c.getNomeCorso() %></h4></div>
				<div class="col-md-2"> <h4><%=c.getDataInizio() %></h4></div>
				<div class="col-md-2"><h4><%=c.getDataFine() %></h4></div>
				<div class="col-md-2 "><h4><%=c.getCodCorso() %></h4></div>
				<div class="col-md-2 "><h4><%=c.getAula() %></h4></div>
				<div class="col-md-2 "><h4><%=c.getCosto() %></h4></div>
				
			</li>
		<%} %>
		</ul>
	</div>
	</div>
	
<%
	}
%>

</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
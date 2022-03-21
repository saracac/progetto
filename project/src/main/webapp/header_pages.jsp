<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<a class="navbar-left"><img src="img/logo_betacom.jpg" width="80" height="40"></a>	
		<a class="navbar-brand">Betacom Academy</a>
    	  <div class="collapse navbar-collapse navbarCollapse">
			<%
				String admin = (String) session.getAttribute("nomeAdmin");
				if (admin == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp">
					<span class="glyphicon glyphicon-log-in"></span> Log-in</a>
				</li>
			</ul>
			
			<%
				} else {
			%>	
   		 	<ul class="nav navbar-nav">
     			<li><a href="home.jsp" id="home">Home</a></li>
      			<li><a href="inserisci.jsp" id="insert">Inserisci</a></li>
      			<li><a href="#" id="view">Visualizza</a></li>
      			<li><a href="elimina.jsp" id="delete">Elimina</a></li>
    		</ul>	
			<ul class="nav navbar-nav navbar-right">
				<li><a>Benvenuto <%=admin%></a></li>
				<li>
					<form action="<%=application.getServletContextName()%>/logout" method="post">
						<input type="submit" class="btn btn-danger navbar-btn" value="Logout"/>
					</form>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</div>
</nav>
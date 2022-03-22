<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<a class="navbar-left"><img src="img/apple.jpg"
			style="max-width: 60px; height: auto; padding-top: 7px;">
		</a>
		<!-- <a class="navbar-brand">Betacom Academy</a> -->
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
      			<li><a href="visualizzastatistiche.jsp" id="view">Visualizza</a></li>
      			<li>
	      			<form action="/<%=application.getServletContextName()%>/Elimina" method="get">
						<label for="elimina">Elimina</label>
						<input type="submit" value="elimina" name="elimina"/>
					</form>
				</li>
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
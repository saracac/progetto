
<nav class="navbar navbar-inverse" style="margin-bottom: 30px;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle"
			data-toggle="collapse"
			data-target="#mioMenu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">
            <img src="img/apple.jpg"
			style="max-width: 50px; height: auto; margin-top: -7px;">
		
            </a>
		</div>
		<div class="collapse navbar-collapse" id="mioMenu">
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
      			<!-- <li><a href="elimina.jsp" id="delete">Elimina</a></li> -->
      			<li><a>
      			<form action="/<%=application.getServletContextName()%>/Elimina" method="get">
						<input type="submit" value="Elimina" name="elimina"
						style="background-color: #000; border:none;"/>
					</form>
			    </a></li>
    		</ul>	
        
        
		<ul class="nav navbar-nav navbar-right"> 
            <li><a>Benvenuto <%=admin%></a></li>
				<li><a>
					<form action="/<%=application.getServletContextName()%>/logout"
						method="post">
						<input type="submit" class="btn btn-danger"
							value="Logout" />
					</form>
				</a></li>
		</ul>
		
		
		<%
			}
		%>
	</div>
</div>
</nav>

 
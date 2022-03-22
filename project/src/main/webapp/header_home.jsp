<nav class="navbar navbar-inverse" style="padding-bottom: 30px;">
	<div class="container-fluid">	
	
		<a class="navbar-left"><img src="img/apple.jpg"
			style="max-width: 60px; height: auto;">
		</a>
		<!-- <a class="navbar-brand">Betacom Academy</a> -->
		<div class="collapse navbar-collapse navbarCollapse">
			<%
			//session.setAttribute("nomeAdmin", "CarloMartello");
			String admin = (String) session.getAttribute("nomeAdmin");
			if (admin == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-in"></span> Log-in
				</a></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a>Benvenuto <%=admin%></a></li>
				<li>
					<form action="/<%=application.getServletContextName()%>/logout"
						method="post">
						<input type="submit" class="btn btn-danger navbar-btn"
							value="Logout" />
					</form>
				</li>
			</ul>
			<%
			}
			%>
		</div>
	</div>
</nav>
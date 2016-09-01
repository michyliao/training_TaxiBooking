<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="style.html"></jsp:include>
<body>


	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
		
					<h3>Michy's Taxi Booking</h3>
			


			<ul class="nav navbar-nav navbar-right">
				<button class="button" action="Logout">Logout</button>
			</ul>

		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<jsp:include page="login.jsp"></jsp:include>
				<jsp:include page="newUser.jsp"></jsp:include>
			</div>
			<div class="col-md-8">something goes here</div>




		</div>

	</div>


</body>
</html>
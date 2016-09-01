<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!-- add ajax -->

<jsp:include page="style.html"></jsp:include>


<c:url value="CabBooking" var="bookLink"></c:url>
<c:url value="MyTrips" var="tripLink"></c:url>
<c:url value="RateCard" var="rateLink"></c:url>
<c:url value="CustCare" var="careLink"></c:url>

<body>
	<div class="container">
		<div class="row">

			<ul class="nav nav-pills">
			
				<li role="presentation" class="active"><a href="${bookLink }">Book Cab</a></li>
				<li role="presentation"><a href="${tripLink }">My Trips</a></li>
				<li role="presentation"><a href="${rateLink }">Rate Cards</a></li>
				<li role="presentation"><a href="${careLink }">Customer Care</a></li>
			</ul>


		</div>

		<div class="row">
			<jsp:include page="booking.html"></jsp:include>
			
		</div>

	</div>

</body>
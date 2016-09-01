<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
				<li role="presentation"><a href="${rateLink }">Rate
						Cards</a></li>
				<li role="presentation"><a href="${careLink }">Customer
						Care</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-offset-5 col-md-5">
				<h2>Available Cabs to Book</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th>Cab Number</th>
							<th>Cab Type</th>
							<th>Driver Name</th>
							<th>Current Location</th>
							<th>Book</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.availCabs }" var="cab">
							<c:url value="/ConfirmPage" var="cabURL">
							<c:param name="cabId" value="${cab.id}"></c:param>
							</c:url>
						
							<tr>
								<td><c:out value="${cab.car_id}"></c:out></td>
								<td><c:out value="${cab.car_type }"></c:out>
								</td>
								<td><c:out value="${cab.driver_name }"></c:out>
								</td>
								<td><c:out value="${cab.location }"></c:out>
								</td>
								<td><a href="${cabURL}">Book</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
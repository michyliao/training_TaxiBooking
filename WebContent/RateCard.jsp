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
				<li role="presentation"><a href="${bookLink }">Book Cab</a></li>
				<li role="presentation"><a href="${tripLink }">My Trips</a></li>
				<li role="presentation" class="active"><a href="${rateLink }">Rate
						Cards</a></li>
				<li role="presentation"><a href="${careLink }">Customer
						Care</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-offset-5 col-md-5">
				<h2>Rate Card</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th>Vehicle Type</th>
							<th>Minimum km</th>
							<th>Addl Charges/km</th>
							<th>WTG Charges for 1 min</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.vList }" var="vehicle">
							<tr>
								<td><c:out value="${vehicle.type_full }"></c:out></td>
								<td>Rs.<c:out value="${vehicle.minKm }"></c:out>/-(4KMS)
								</td>
								<td>Rs.<c:out value="${vehicle.addCharge }"></c:out>/-
								</td>
								<td>Rs.<c:out value="${vehicle.wtgCharge }"></c:out>/-
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
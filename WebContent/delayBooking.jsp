<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>



<jsp:include page="style.html"></jsp:include>

<script type="text/javascript">
$( function() {
    //$( "#datepicker" ).datepicker();
  	//$( "#timepicker" ).timepicker({});
	$('#date').bootstrapMaterialDatePicker({ weekStart : 0, time: false });
	$('#time').bootstrapMaterialDatePicker({ date: false });
  } );

</script>

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
			<div class="col-md-offset-3 col-md-5">
	<center>
		<h3>Book Cab</h3>
	</center>
	<c:set value="${requestScope.tempBooking }" var="booking" scope="request"></c:set>
	
	<form class="form-horizontal" action="DelayBooking" method="post">

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email" name="email" value="${booking.email}" >
			</div>
		</div>
		<div class="form-group">
			<label for="phoneInput" class="col-sm-2 control-label">Telephone</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="phoneInput"
					placeholder="enter your phone numer here" name="phone" value="${booking.phone }">
			</div>
		</div>
		<div class="form-group">
			<label for="phoneInput" class="col-sm-2 control-label">Booking
				Type</label>
			<div class="col-sm-10">
				<select name="bookingType">
					<option value="METER">Meter</option>
					<option value="OUTSTATION">Out Station</option>
					<option value="PACKAGE">Package</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="pickupInput" class="col-sm-2 control-label">Pickup
				Place</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="pickupInput"
					placeholder="Enter the location" name="pickupPlace" value="${booking.pickupPlace }">
			</div>
		</div>
		<div class="form-group">
			<label for="dropoffInput" class="col-sm-2 control-label">Dropoff
				Place</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="dropoffInput"
					placeholder="Enter Locaiton" name="dropoffPlace" value="${booking.dropoffPlace }">
			</div>
		</div>
		<div class="form-group">
			<label for="pickupDateInput" class="col-sm-2 control-label">Pickup Date
				Place</label>
			<div class="col-sm-10">
							
					<input type="text" id="date" name="pickupDate">
			</div>
		</div>
		<div class="form-group">
			<label for="pickupTimeInput" class="col-sm-2 control-label">Pickup Time
				Place</label>
			<div class="col-sm-10">
							<input type="text" id="time" name="pickupTime">



						</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Book Now</button>
			</div>
		</div>



	</form>
</div>
			
		</div>

	</div>

</body>
CREATE OR REPLACE PROCEDURE create_Booking
(
	id IN Bookings.id%TYPE,
	email IN Bookings.email%TYPE,
	phone IN Bookings.phone%TYPE,
	booking_type IN Bookings.booking_type%TYPE,
	pickup_place IN Bookings.pickup_place%TYPE,
	dropoff_place IN Bookings.dropoff_place%TYPE,
	pickupTime IN Bookings.pickupTime%TYPE
) 
IS
BEGIN

	INSERT INTO Bookings
	VALUES(id, email, phone, booking_type, pickup_place, dropoff_place, pickupTime);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'CabBooking ID already exists / duplicate id');

END create_Booking;
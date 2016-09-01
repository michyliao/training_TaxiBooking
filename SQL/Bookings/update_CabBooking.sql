CREATE OR REPLACE PROCEDURE update_Booking
(
	t_id IN Bookings.id%TYPE,
	t_email IN Bookings.email%TYPE,
	t_phone IN Bookings.phone%TYPE,
	t_booking_type IN Bookings.booking_type%TYPE,
	t_pickup_place IN Bookings.pickup_place%TYPE,
	t_dropoff_place IN Bookings.dropoff_place%TYPE,
	t_pickupTime IN Bookings.pickupTime%TYPE
) 
IS
BEGIN

	UPDATE Bookings
	SET id = t_id, email = t_email, phone = t_phone, booking_type = t_booking_type, pickup_place = t_pickup_place, dropoff_place = t_dropoff_place, pickupTime = t_pickupTime
	where id = t_id;

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_Booking;
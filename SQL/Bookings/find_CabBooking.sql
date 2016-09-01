CREATE OR REPLACE PROCEDURE find_Booking 
(
	t_id IN Bookings.id%TYPE,
	t_email IN Bookings.email%TYPE,
	Booking_cursor out SYS_REFCURSOR
) 
IS
BEGIN
	open Booking_cursor for
		select id, email, phone, booking_type, pickup_place, dropoff_place, pickupTime
		from Bookings
		where (email = t_email) or (id = t_id);


	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_Booking;
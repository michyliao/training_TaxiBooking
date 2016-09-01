CREATE OR REPLACE PROCEDURE findALL_Bookings
(
	Bookings_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN Bookings_cursor FOR
		SELECT id, email, phone, booking_type, pickup_place, dropoff_place, pickupTime
		FROM Bookings;
		
END findALL_Bookings;
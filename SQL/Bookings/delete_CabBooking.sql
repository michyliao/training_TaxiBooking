CREATE OR REPLACE PROCEDURE delete_Booking
(
	t_id IN Bookings.id%TYPE
)
IS
BEGIN

	DELETE FROM CabBookings
	where id = t_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_Booking;
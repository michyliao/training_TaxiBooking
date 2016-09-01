CREATE OR REPLACE PROCEDURE find_availableCabs 
(
	location IN CabAvailability.current_location%TYPE,
	Cabs_cursor out SYS_REFCURSOR
) 
IS
BEGIN
	open Cabs_cursor for
		select avail.id, cars.type, driver.name, avail.current_location, cars.id
		from CabAvailability avail 
		inner join Drivers driver on avail.driver_id = driver.id
		inner join Vehicles cars on cars.id = avail.vehicle_id
		where avail.current_location = location and avail.available = 1;


	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_availableCabs;
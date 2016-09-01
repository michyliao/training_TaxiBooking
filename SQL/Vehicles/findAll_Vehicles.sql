CREATE OR REPLACE PROCEDURE findAll_Vehicles
(
	Vehicles_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN Vehicles_cursor FOR
		SELECT id, type, type_full, minKm, addCharge, wtgCharge 
		FROM Vehicles;
		
END findAll_Vehicles;
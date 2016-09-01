CREATE OR REPLACE PROCEDURE findALL_TaxiUser
(
	TaxiUser_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN TaxiUser_cursor FOR
		SELECT id, email, password, phone, city
		FROM TaxiUser;
		
END findALL_TaxiUser;
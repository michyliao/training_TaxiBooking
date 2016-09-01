CREATE OR REPLACE PROCEDURE find_TaxiUser 
(
	t_id IN TaxiUser.id%TYPE,
	t_email IN TaxiUser.email%TYPE,
	TaxiUser_cursor out SYS_REFCURSOR
) 
IS
BEGIN
	open TaxiUser_cursor for
		select id, email, password, phone, city
		from TaxiUser
		where (email = t_email) or (id = t_id);


	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_TaxiUser;
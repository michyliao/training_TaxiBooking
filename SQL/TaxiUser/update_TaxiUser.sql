CREATE OR REPLACE PROCEDURE update_TaxiUser
(
	t_id IN TaxiUser.id%TYPE,
	t_email IN TaxiUser.email%TYPE,
	t_password IN TaxiUser.password%TYPE,
	t_phone IN TaxiUser.phone%TYPE,
	t_city IN TaxiUser.city%TYPE
) 
IS
BEGIN

	UPDATE TaxiUser
	SET id = t_id, email = t_email, password = t_password, phone = t_phone, city = t_city
	where id = t_id;

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_TaxiUser;
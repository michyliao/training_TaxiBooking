CREATE OR REPLACE PROCEDURE create_TaxiUser
(
	id IN TaxiUser.id%TYPE,
	email IN TaxiUser.email%TYPE,
	password IN TaxiUser.password%TYPE,
	phone IN TaxiUser.phone%TYPE,
	city IN TaxiUser.city%TYPE
) 
IS
BEGIN

	INSERT INTO TaxiUser
	VALUES(id, email, password, phone, city);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'TAXIUSER ID already exists / duplicate id');

END create_TaxiUser;
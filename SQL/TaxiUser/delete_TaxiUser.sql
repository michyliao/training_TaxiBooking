CREATE OR REPLACE PROCEDURE delete_TaxiUser
(
	t_id IN TaxiUser.id%TYPE
)
IS
BEGIN

	DELETE FROM TaxiUser
	where id = t_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_TaxiUser;
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (input VARCHAR(20))
BEGIN
	SELECT e.name AS town_name
	FROM towns AS e
	WHERE
		e.name LIKE CONCAT(input, '%')
	ORDER BY e.name;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('B');

DROP PROCEDURE usp_get_towns_starting_with;

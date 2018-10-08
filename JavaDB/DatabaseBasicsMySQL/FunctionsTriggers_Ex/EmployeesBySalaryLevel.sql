DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(20))
BEGIN
	SELECT
		e.first_name,
        e.last_name
	FROM 
		employees AS e
	WHERE ufn_get_salary_level(e.salary) = salary_level
    ORDER BY first_name DESC, last_name DESC;
END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level('High');

DROP PROCEDURE usp_get_employees_by_salary_level;


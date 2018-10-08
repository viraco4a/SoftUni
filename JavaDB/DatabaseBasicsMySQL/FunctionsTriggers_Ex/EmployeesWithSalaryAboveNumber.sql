DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary  DOUBLE(19,4))
BEGIN
	SELECT
		e.first_name,
        e.last_name
	FROM
		employees AS e
	WHERE
		e.salary >= salary
	ORDER BY e.first_name, e.last_name, employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above(48100);
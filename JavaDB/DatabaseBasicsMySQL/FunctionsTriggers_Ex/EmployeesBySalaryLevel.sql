CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(17, 2))
RETURNS VARCHAR(20)
BEGIN
	DECLARE salary_level VARCHAR(20);
    SET salary_level = (
		CASE
			WHEN salary < 30000 THEN 'Low'
            WHEN salary <= 50000 THEN 'Average'
			ELSE 'High'
		END
    );
	RETURN salary_level;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(20))
BEGIN
	SELECT
		e.first_name,
        e.last_name
	FROM 
		employees AS e
	WHERE ufn_get_salary_level(e.salary) = salary_level
    ORDER BY first_name DESC, last_name DESC;
END
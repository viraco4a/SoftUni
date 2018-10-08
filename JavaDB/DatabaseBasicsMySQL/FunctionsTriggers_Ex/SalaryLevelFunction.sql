DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(17, 2))
RETURNS VARCHAR(20)
BEGIN
	DECLARE salary_level VARCHAR(20);
    SET salary_level := (
		CASE
			WHEN salary < 30000 THEN 'Low'
            WHEN salary <= 50000 THEN 'Average'
			ELSE 'High'
		END
    );
	RETURN salary_level;
END $$
DELIMITER ;

SELECT ufn_get_salary_level(53500);
DROP FUNCTION ufn_get_salary_level;
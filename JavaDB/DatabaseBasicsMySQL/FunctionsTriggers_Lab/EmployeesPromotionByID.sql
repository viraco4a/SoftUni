DELIMITER $$
-- start judge
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	START TRANSACTION;
    IF((SELECT COUNT(employee_id)
			FROM employees
            WHERE employee_id LIKE id)<>1) THEN
    ROLLBACK;
    ELSE
		UPDATE employees AS e
        SET salary = salary * 1.05
        WHERE e.employee_id = id;
	END IF;    
END $$ -- end judge without $$

CALL usp_raise_salary_by_id(178);

SELECT
	employee_id,
    salary
FROM employees
WHERE employee_id = 178
DROP PROCEDURE usp_assign_employee_to_report;

DELIMITER $$
CREATE PROCEDURE usp_assign_employee_to_report(employee_id INT, report_id INT) 
BEGIN
	DECLARE employee_department_id INT DEFAULT 
		(SELECT e.department_id 
		FROM employees AS e 
        WHERE e.id = employee_id);
        
	DECLARE report_category_id INT DEFAULT 
		(SELECT r.category_id 
        FROM reports AS r
        WHERE r.id = report_id);
    
	DECLARE category_department_id INT DEFAULT 
		(SELECT c.department_id 
        FROM categories AS c
        WHERE c.id = report_category_id);
    
	IF
		employee_department_id != category_department_id THEN
		SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Employee doesn\'t belong to the appropriate department!';
        ROLLBACK;
    ELSE
		UPDATE reports AS r
			SET r.employee_id = employee_id
			WHERE r.id = report_id;
        COMMIT;
    END IF;
END $$

DELIMITER ;

CALL usp_assign_employee_to_report(30, 1);
SELECT employee_id FROM reports WHERE id = 2;

CALL usp_assign_employee_to_report(17, 2);
SELECT employee_id FROM reports WHERE id = 2;

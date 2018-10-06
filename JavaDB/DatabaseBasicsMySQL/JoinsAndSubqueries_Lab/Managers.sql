SELECT
	e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    d.department_id,
    d.name AS department_name
FROM 
	departments as d 
		JOIN 
	employees as e ON e.employee_id = d.manager_id
ORDER BY e.employee_id
LIMIT 5
SELECT
	employee_id,
    first_name,
    last_name,
    department_id,
    salary
FROM employees AS e
WHERE ISNULL(e.manager_id);
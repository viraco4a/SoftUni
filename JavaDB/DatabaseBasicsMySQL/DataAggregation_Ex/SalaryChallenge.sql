SELECT 
		e.first_name,
        e.last_name,
        e.department_id
FROM 
	employees AS e
		JOIN
	(SELECT
		department_id, AVG(salary) AS dep_avg_salary
	FROM employees
    GROUP BY department_id) AS avrg ON e.department_id = avrg.department_id
WHERE
	salary > avrg.dep_avg_salary
ORDER BY department_id
LIMIT 10
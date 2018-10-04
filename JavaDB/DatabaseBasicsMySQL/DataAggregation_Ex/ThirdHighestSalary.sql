SELECT
	emp.department_id,
	MAX(emp.salary) AS 'third_highest_salary'
FROM
	employees AS emp
		JOIN
	(SELECT
		e.department_id, MAX(e.salary) AS max_salary
	FROM
		employees AS e
	JOIN (SELECT
		e.department_id, MAX(e.salary) AS max_salary
	FROM
		employees AS e
	GROUP BY e.department_id) AS first_max_salary ON e.department_id = first_max_salary.department_id
	WHERE
		e.salary < first_max_salary.max_salary
	GROUP BY e.department_id) AS second_max_salary ON emp.department_id = second_max_salary.department_id
WHERE
	emp.salary < second_max_salary.max_salary
GROUP BY emp.department_id
ORDER BY emp.department_id;
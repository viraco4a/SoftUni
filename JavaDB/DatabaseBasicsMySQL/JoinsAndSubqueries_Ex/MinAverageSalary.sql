SELECT
	AVG(e.salary) AS min_average_salary
FROM employees AS e
GROUP BY department_id
ORDER By min_average_salary
LIMIT 1
SELECT
	COUNT(employee_id) AS count
FROM employees AS e
WHERE e.salary > (
SELECT AVG (e.salary) AS 'average_salary'
FROM employees AS e
);


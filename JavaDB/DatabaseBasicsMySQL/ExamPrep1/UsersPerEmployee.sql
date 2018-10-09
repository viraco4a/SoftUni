SELECT
	CONCAT(e.first_name, ' ', e.last_name) AS `name`,
    COUNT(DISTINCT r.user_id) AS users_count
FROM employees AS e
JOIN reports AS r
	ON e.id = r.employee_id
GROUP BY e.id
ORDER BY users_count DESC, `name`;
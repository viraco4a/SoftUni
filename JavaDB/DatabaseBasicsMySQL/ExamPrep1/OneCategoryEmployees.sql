SELECT
	c.`name` AS category_name,
    COUNT(e.id) AS employees_number
FROM categories AS c
JOIN employees AS e
	ON c.department_id = e.department_id
GROUP BY c.name
ORDER BY c.`name`;
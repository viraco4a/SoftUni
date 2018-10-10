SELECT
	d.name AS department_name,
    c.name AS category_name,
    ROUND(COUNT(r.id)/
    ((SELECT
		COUNT(r1.id)
	FROM reports AS r1
		JOIN categories AS c1 ON c1.id = r1.category_id
		JOIN departments AS d1 ON c1.department_id = d1.id
		WHERE d1.id = d.id
    GROUP BY d1.id
    )) * 100, 0 ) AS percentage
FROM departments AS d
JOIN categories AS c ON c.department_id = d.id
JOIN reports AS r ON r.category_id = c.id
GROUP BY d.id, c.id
ORDER BY d.name, c.name, percentage


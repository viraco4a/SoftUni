SELECT
	c.name AS category_name,
    COUNT(r.id) AS reports_number
FROM categories AS c
JOIN reports AS r
	ON r.category_id = c.id
GROUP BY r.category_id
ORDER BY reports_number, c.name
SELECT
	d.name AS department_name,
    IFNULL(FLOOR(AVG(DATEDIFF(r.close_date, r.open_date))), 'no info') AS average_duration
FROM departments AS d
JOIN categories AS c ON c.department_id = d.id
JOIN reports AS r ON r.category_id = c.id
GROUP BY d.id
ORDER BY d.name
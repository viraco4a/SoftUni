SELECT
	r.open_date,
    r.description,
    u.email AS reporter_email
FROM reports AS r
JOIN categories AS c
	ON r.category_id = c.id
JOIN departments AS d
	ON d.id = c.department_id
JOIN users AS u
	ON u.id = r.user_id
WHERE
	r.close_date IS NULL
	AND 
    r.`description` LIKE '%str%'
    AND
    char_length(`description`) > 20
    AND
    d.name IN ('Infrastructure', 'Emergency', 'Roads Maintenance')
ORDER BY open_date, reporter_email, u.id
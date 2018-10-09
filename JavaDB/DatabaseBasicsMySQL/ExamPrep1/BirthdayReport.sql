SELECT DISTINCT
	c.name AS category_name
FROM users AS u
JOIN reports AS r
	ON u.id = r.user_id
JOIN categories AS c
	ON c.id = r.category_id
WHERE DAY(u.birthdate) = DAY(r.open_date)
ORDER BY category_name
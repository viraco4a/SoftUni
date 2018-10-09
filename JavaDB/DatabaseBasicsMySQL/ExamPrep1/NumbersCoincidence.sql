SELECT  DISTINCT
	u.username
FROM users AS u
JOIN reports AS r
	ON r.user_id = u.id
WHERE 
	(LEFT (username, 1) REGEXP '^[0-9]' > 0
		AND
	r.category_id = LEFT (username, 1))
		OR
	(RIGHT (username, 1) REGEXP '^[0-9]' > 0
		AND
	r.category_id = RIGHT (username, 1))
ORDER BY u.username

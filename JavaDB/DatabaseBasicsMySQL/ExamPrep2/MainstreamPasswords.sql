SELECT DISTINCT
	u.id, u.username, u.password
FROM users AS u
	JOIN users AS u2 ON u.password = u2.password
    WHERE u.id != u2.id
ORDER BY u.username, u.id    
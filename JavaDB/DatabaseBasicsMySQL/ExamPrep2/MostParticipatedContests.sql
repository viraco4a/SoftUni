SELECT *
FROM
	(SELECT
	c.id, c.name, COUNT(uc.contest_id) AS contestants
FROM contests AS c
LEFT JOIN users_contests AS uc ON uc.contest_id = c.id
GROUP BY uc.contest_id
ORDER BY contestants DESC, c.id
LIMIT 5) AS x
ORDER BY x.contestants, x.id
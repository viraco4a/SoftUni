SELECT
	c.id, c.name
FROM categories AS c
	LEFT JOIN categories AS c2 ON c2.parent_id = c.id
WHERE c2.id IS NULL
ORDER BY c.name, c.id
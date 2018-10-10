UPDATE problems AS p
		JOIN
	contests AS c ON p.contest_id = c.id
		JOIN
	categories AS cat ON c.category_id = cat.id
SET
	p.tests = CASE(p.id % 3)
		WHEN 0 THEN CHAR_LENGTH(cat.name)
		WHEN 1 THEN (SELECT SUM(s.id) FROM submissions AS s WHERE s.problem_id = p.id)
		WHEN 2 THEN CHAR_LENGTH(c.name)
		END
WHERE p.tests = 0;
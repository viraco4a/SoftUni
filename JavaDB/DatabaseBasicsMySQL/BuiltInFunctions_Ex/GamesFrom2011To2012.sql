SELECT 
	name, 
    date_format(start, '%Y-%m-%d')
FROM 
	games
WHERE 
	YEAR(start) BETWEEN 2011 AND 2012
ORDER BY start, name
LIMIT 50;
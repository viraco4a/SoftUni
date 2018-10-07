SELECT
	c.country_code,
    COUNT(mc.mountain_id) AS mountain_range
FROM countries AS c
	JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
	JOIN mountains AS m
		ON mc.mountain_id = m.id
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_name
ORDER BY mountain_range DESC
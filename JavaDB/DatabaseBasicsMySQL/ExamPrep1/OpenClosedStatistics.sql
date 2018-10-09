SELECT
	x.name,
    CONCAT_WS('/', x.closed, x.opened) AS closed_open_reports
FROM
(SELECT
	CONCAT_WS(' ', e.first_name, e.last_name) AS name,
    COUNT(IF(YEAR(r.close_date) = 2016, 1, NULL)) AS closed,
    COUNT(IF(YEAR(r.open_date) = 2016, 1, NULL)) AS opened
FROM reports AS r
JOIN employees AS e ON e.id = r.employee_id
GROUP BY name
HAVING closed > 0 OR opened > 0) AS x
ORDER BY name
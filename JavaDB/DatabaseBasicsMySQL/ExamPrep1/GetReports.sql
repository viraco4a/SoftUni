DROP FUNCTION udf_get_reports_count;

CREATE FUNCTION udf_get_reports_count(employee_id INT, status_id INT)
RETURNS INT
RETURN 
	(
	SELECT
		COUNT(r.id)
		FROM reports AS r
		WHERE r.id = employee_id AND r.id = status_id
	);

SELECT 
	e.id, 
    e.first_name, 
    e.last_name, 
    udf_get_reports_count(e.id, 2) AS reports_count
FROM employees AS e
ORDER BY e.id;

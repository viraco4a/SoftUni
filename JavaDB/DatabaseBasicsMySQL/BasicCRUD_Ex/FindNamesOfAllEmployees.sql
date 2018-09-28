SELECT CONCAT_WS(' ', first_name, middle_name, last_name)
AS 'FULL Name'
FROM employees
WHERE salary IN (25000, 14000, 12500, 23600);
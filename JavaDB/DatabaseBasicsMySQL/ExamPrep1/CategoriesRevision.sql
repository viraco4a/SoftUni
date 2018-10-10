SELECT 
    c.name AS 'category_name',
    COUNT(r.id) AS 'reports_number',
    IF(COUNT(IF(r.status_id = 1, 1, NULL)) = COUNT(IF(r.status_id = 2, 1, NULL)),
        'equal',
        IF(COUNT(IF(r.status_id = 1, 1, NULL)) > COUNT(IF(r.status_id = 2, 1, NULL)),
            'waiting',
            'in progress')) AS 'main_status'
FROM
    categories AS c
        JOIN
    reports AS r ON c.id = r.category_id
WHERE
    r.status_id IN (1 , 2)
GROUP BY c.id
ORDER BY c.name;
SELECT 
    d.name AS 'department_name',
    c.name AS 'category_name',
    ROUND((COUNT(r.id) / (SELECT 
                COUNT(r1.id)
            FROM
                reports AS r1
                    JOIN
                categories AS c1 ON c1.id = r1.category_id
                    JOIN
                departments AS d1 ON d1.id = c1.department_id
            WHERE
                d1.id = d.id
            GROUP BY d1.id)) * 100,
        0) AS 'percentage'
FROM
    reports AS r
        JOIN
    categories AS c ON c.id = r.category_id
        JOIN
    departments AS d ON d.id = c.department_id
GROUP BY d.id , c.id
ORDER BY d.name , c.name , percentage;
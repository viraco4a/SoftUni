SELECT CONCAT(first_name, ' ' ,last_name), timestampdiff(DAY, born, died)
FROM authors
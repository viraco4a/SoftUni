USE hospital;

UPDATE employees
SET salary = salary * 1.1
WHERE job_title = 'Therapist';

SELECT salary
FROM employees
ORDER BY salary;
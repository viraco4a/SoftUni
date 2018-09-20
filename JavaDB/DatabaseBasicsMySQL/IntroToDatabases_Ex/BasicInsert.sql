use soft_uni;

INSERT INTO towns
	(id, name)
VALUES
	(1, 'Sofia'),
	(2, 'Plovdiv'),
	(3, 'Varna'),
	(4, 'Burgas');
    
INSERT INTO departments
	(id, name)
VALUES
	(1, 'Engineering'),
	(2, 'Sales'),
	(3, 'Marketing'),
	(4, 'Software Development'),
	(5, 'Quality Assurance');
    
INSERT INTO addresses
	(id, address_text, town_id)
VALUES
	(1, 'kur', 1);

INSERT INTO employees
	(id, first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)
VALUES
	(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500, 1),
	(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000, 1),
	(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 1),
	(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000, 1),
	(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 1);
    

    SELECT * FROM employees;
    
    

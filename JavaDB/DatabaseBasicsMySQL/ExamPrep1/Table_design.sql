CREATE TABLE users(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50),
	gender VARCHAR(1),
	birthdate DATETIME,
	age INT(11) UNSIGNED,
	email VARCHAR(50) NOT NULL
);

CREATE TABLE departments(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE employees(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
	gender VARCHAR(1),
	birthdate DATETIME,
	age INT(11) UNSIGNED,
	department_id INT(11) UNSIGNED,
		CONSTRAINT fk_employees_departments
		FOREIGN KEY (department_id)
		REFERENCES departments(id)
);

CREATE TABLE categories(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    department_id INT(11) UNSIGNED,
		CONSTRAINT fk_categories_departments
		FOREIGN KEY (department_id)
		REFERENCES departments(id)
);

CREATE TABLE `status`(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(30) NOT NULL
);

CREATE TABLE reports(
	id INT(11) UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT,
    category_id INT(11) UNSIGNED,
		CONSTRAINT fk_reports_categories
		FOREIGN KEY (category_id)
		REFERENCES categories(id),
	status_id INT(11) UNSIGNED,
		CONSTRAINT fk_reports_status
		FOREIGN KEY (status_id)
		REFERENCES `status`(id),
	open_date DATETIME,
    close_date DATETIME,
    `description` VARCHAR(200),
    user_id INT(11) UNSIGNED,
		CONSTRAINT fk_reports_users
		FOREIGN KEY (user_id)
		REFERENCES users(id),
	employee_id INT(11) UNSIGNED,
		CONSTRAINT fk_reports_employees
		FOREIGN KEY (employee_id)
		REFERENCES employees(id)
);


CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE addresses(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    address_text VARCHAR(200) NOT NULL,
    town_id INT(11) NOT NULL
);

CREATE TABLE departments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    department_id INT(11) NOT NULL,
    hire_date DATE NOT NULL,
    salary INT(11) NOT NULL,
    address_id INT(11) NOT NULL
);

ALTER TABLE addresses
ADD CONSTRAINT fk_addresses_towns
FOREIGN KEY (town_id)
REFERENCES towns(id);

ALTER TABLE employees
ADD CONSTRAINT fk_employees_departments
FOREIGN KEY (department_id)
REFERENCES departments(id),
ADD CONSTRAINT fk_employees_addresses
FOREIGN KEY (address_id)
REFERENCES addresses(id);

CREATE DATABASE soft_uni;
USE soft_uni;
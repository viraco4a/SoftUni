CREATE TABLE persons (
	person_id INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	salary DECIMAL(10, 2) NOT NULL DEFAULT 0,
	passport_id INT UNSIGNED NOT NULL UNIQUE
);

CREATE TABLE passports (
	passport_id INT UNSIGNED UNIQUE AUTO_INCREMENT PRIMARY KEY,
	passport_number VARCHAR(8) NOT NULL UNIQUE
) AUTO_INCREMENT=101;

INSERT 
	INTO persons (first_name, salary, passport_id) 
	VALUES 
		('Roberto', 43300, 102), 
		('Tom', 56100, 103), 
		('Yana', 60200, 101);

INSERT 
	INTO passports (passport_number) 
    VALUES ('N34FG21B'), ('K65LO4R7'), ('ZE657QP2');

ALTER TABLE persons
	ADD CONSTRAINT pk_persons
		PRIMARY KEY (person_id),
	ADD CONSTRAINT fk_persons_passports
		FOREIGN KEY(passport_id)
		REFERENCES passports(passport_id);
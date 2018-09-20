CREATE DATABASE hotel;
USE hotel;

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    title VARCHAR(30) NOT NULL,
    notes TEXT
);

INSERT INTO employees
		(id, first_name, last_name, title)
VALUES
		(1, 'Petar', 'sadsafga', 'acc'),
		(2, 'sadfPetar', 'sadsdsadafga', 'acsdac'),
		(3, 'Petfgadaar', 'sfadsdadasafga', 'acdsadc');

CREATE TABLE customers(
	account_number INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone_number VARCHAR(30) NOT NULL,
    emergency_name VARCHAR(30) NOT NULL,
    emergency_number VARCHAR(30) NOT NULL,
    notes TEXT
);

INSERT INTO customers
		(account_number, first_name, last_name, phone_number, emergency_name, emergency_number)
VALUES
		(1, 'sdada', 'sdagfa', '12324', 'sdadsa', '2345'),
		(2, 'sdada', 'sdagfa', '12324', 'sdadsa', '2345'),
		(3, 'sdada', 'sdagfa', '12324', 'sdadsa', '2345');

CREATE TABLE room_status(
	room_status INT(11) PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);

INSERT INTO room_status
		(room_status, notes)
VALUES
		(1, 'Occupied'),
        (2, 'Free'),
        (3, 'Reserved');

CREATE TABLE room_types(
	room_type INT(11) PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);

INSERT INTO room_types
		(room_type, notes)
VALUES
		(1, 'sdad'),
		(2, 'sdsdaad'),
		(3, 'sdadsdad');

CREATE TABLE bed_types(
	bed_type INT(11) PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);

INSERT INTO bed_types
		(bed_type, notes)
VALUES
		(1, 'sdad'),
		(2, 'sdsdaad'),
		(3, 'sdadsdad');
        
CREATE TABLE rooms(
	room_number INT(11) PRIMARY KEY AUTO_INCREMENT,
    room_type INT(11) NOT NULL,
    bed_type INT(11) NOT NULL,
    rate INT(11) NOT NULL,
    room_status INT(11) NOT NULL,
    notes TEXT
);

INSERT INTO rooms
		(room_number, room_type, bed_type, rate, room_status)
VALUES
		(1, 2, 3, 4, 5),
		(2, 2, 3, 4, 5),
		(3, 2, 3, 4, 5);
        
CREATE TABLE payments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11) NOT NULL,
    payment_date DATE NOT NULL,
    account_number INT(11) NOT NULL,
    first_date_occupied DATE NOT NULL,
    last_date_occupied DATE NOT NULL,
    total_days INT(11) NOT NULL,
    amount_charged INT(11) NOT NULL,
    tax_rate INT(11) NOT NULL,
    tax_amount INT(11) NOT NULL,
    payment_total INT(11) NOT NULL,
    notes TEXT
);

INSERT INTO payments
	(id, employee_id, payment_date, account_number, first_date_occupied, last_date_occupied, total_days, amount_charged, tax_rate, tax_amount, payment_total)
VALUES
	(1, 2, '2012-05-03', 3434, '2012-05-03', '2012-05-06', 4, 5, 6, 7, 8),
	(2, 2, '2012-05-03', 3434, '2012-05-03', '2012-05-06', 4, 5, 6, 7, 8),
	(3, 2, '2012-05-03', 3434, '2012-05-03', '2012-05-06', 4, 5, 6, 7, 8);

CREATE TABLE occupancies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11) NOT NULL,
    date_occupied DATE NOT NULL,
    account_number INT(11) NOT NULL,
    room_number INT(11) NOT NULL,
    rate_applied INT(11) NOT NULL,
    phone_charge INT(11) NOT NULL,
    notes TEXT
);

INSERT INTO occupancies
	(id, employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge)
VALUES
	(1, 3, '2012-05-03', 2323, 23, 2323, 5453),
	(2, 3, '2012-05-03', 2323, 23, 2323, 5453),
	(3, 3, '2012-05-03', 2323, 23, 2323, 5453);
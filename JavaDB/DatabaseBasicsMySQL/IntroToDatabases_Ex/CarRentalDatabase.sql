CREATE database minions;
USE minions;

CREATE TABLE  minions(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    age INT(11)
);

CREATE TABLE towns(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15)
);
ALTER TABLE minions
ADD COLUMN town_id INT(11);

ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY(town_id)
REFERENCES towns(id);

INSERT INTO towns(id, name)
	VALUES (1, 'Sofia'),
			 (2, 'Plovdiv'),
			 (3, 'Varna');

INSERT INTO minions(id, name, age, town_id) 
	VALUES (1, 'Kevin', 22, 1), 
			 (2, 'Bob', 15, 3),
			 (3, 'Steward', NULL, 2);

TRUNCATE minions;

DROP TABLE minions;
DROP TABLE towns;

CREATE TABLE people(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(3, 2),
    weight DOUBLE(3, 2),
    gender ENUM('m', 'f') NOT NULL,
    birthdate DATE NOT NULL,
    biography LONGTEXT
);

INSERT INTO people(name, gender, birthdate)
		VALUES 
			('User1', 'm', '1980-02-14'),
			('User2', 'f', '1981-02-14'),
            ('User3', 'm', '1982-02-14'),
            ('User4', 'f', '1983-02-14'),
            ('User5', 'm', '1984-02-14');
            
CREATE TABLE users(
	id BIGINT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    picture LONGBLOB,
    last_login_time TIMESTAMP,
    is_deleted BOOLEAN
);

INSERT INTO users
		(username, password, last_login_time, is_deleted)
VALUES
		('Gosho', 'sadagaasd', now(), TRUE),
		('Maria', 'adfasdfa', now(), TRUE),
		('Pesho', 'dsadfag', now(), TRUE),
		('Dancho', 'fhshafda', now(), TRUE),
		('Antonia', 'gcgaqyaga', now(), TRUE);
        
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY(id, username);

ALTER TABLE users
MODIFY COLUMN last_login_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT PRIMARY KEY(id),
ADD CONSTRAINT UNIQUE (username);

CREATE DATABASE movies;
USE movies;

CREATE TABLE directors(
	id INT(11) UNSIGNED PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    director_name VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE genres(
	id INT(11) UNSIGNED PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    genre_name VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE categories(
	id INT(11) UNSIGNED PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE movies(
	id INT(11) UNSIGNED PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    director_id INT(11) NOT NULL,
    copyright_year YEAR NOT NULL,
    length INT(11) NOT NULL,
    genre_id INT(11) NOT NULL,
    category_id INT(11) NOT NULL,
    rating DOUBLE DEFAULT 0,
    notes TEXT
);

INSERT INTO directors
		(id, director_name, notes)
VALUES
		(1, 'asdaagag', 'fdfgdgd'),
		(2, 'dsad', 'fdfgdgd'),
		(3, 'ghsfg', 'fdfgdgd'),
		(4, 'dfgjsj', 'fdfgdgd'),
		(5, 'sdaaga', 'fdfgdgd');
        
INSERT INTO movies
		(id, title, director_id, copyright_year, length, genre_id, category_id)
VALUES
		(1, 'fgdgfd', 2, '2018', 100, 1, 2),
		(2, 'dsfgdgdad', 2, '2018', 100, 1, 2),
		(3, 'ghshghffg', 2, '2018', 100, 1, 2),
		(4, 'jhjhjhjhjh', 2, '2018', 100, 1, 2),
		(5, 'sdaakhkjkjkjga', 2, '2018', 100, 1, 2);
        
INSERT INTO categories
		(id, category_name)
VALUES
		(1, 'dsfsg'),
		(2, 'sdagfag'),
		(3, 'sadassadgf'),
		(4, 'sdasdadadasda'),
		(5, 'xccbbnf');

INSERT INTO genres
		(id, genre_name)
VALUES
		(1, 'dsfsdadassg'),
		(2, 'sdagsdadsadsfag'),
		(3, 'sadazzssadgf'),
		(4, 'sdasdzzadadasda'),
		(5, 'xccbzzbnf');
        
CREATE DATABASE car_rental;
USE car_rental;

CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(30) NOT NULL,
    daily_rate DOUBLE DEFAULT 0,
    weekly_rate DOUBLE DEFAULT 0,
    monthly_rate DOUBLE DEFAULT 0,
    weekend_rate DOUBLE DEFAULT 0
);

CREATE TABLE cars(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    plate_number INT(11) NOT NULL,
    make VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    car_year YEAR NOT NULL,
    category_id INT(11) NOT NULL,
    doors INT(11) DEFAULT 4,
    picture BLOB,
    car_condition TEXT,
    available BOOLEAN NOT NULL
);

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    title VARCHAR(30) NOT NULL,
    notes TEXT
);

CREATE TABLE customers(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT(11) NOT NULL,
    full_name VARCHAR(200) NOT NULL,
    address TEXT NOT NULL,
    city VARCHAR(30) NOT NULL,
    zip_code INT(11) NOT NULL,
    notes TEXT
);

CREATE TABLE rental_orders(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11) NOT NULL,
    customer_id INT(11) NOT NULL,
    car_id INT(11) NOT NULL,
    car_condition TEXT,
    tank_level DOUBLE DEFAULT 1,
    kilometrage_start INT(11) NOT NULL,
    kilometrage_end INT(11) NOT NULL,
    total_kilometrage INT(11) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT(11) NOT NULL,
    rate_applied INT(11) NOT NULL,
    tax_rate INT(11) NOT NULL,
    order_status ENUM('Accepted', 'Finished', 'In process') NOT NULL,
    notes TEXT
);

INSERT INTO categories
		(id, category)
VALUES
		(1, 'sadsada'),
		(2, 'sadssada'),
		(3, 'sadsdada');
        
INSERT INTO cars
		(id, plate_number, make, model, car_year, category_id, available)
VALUES
		(1, 1223, 'Germany', 'dsada', '2017', 2, TRUE),
		(2, 9999, 'Gearsmany', 'dsasda', '2016', 3, FALSE),
		(3, 4667, 'Germsany', 'dssada', '2015', 2, TRUE);
        
INSERT INTO employees
		(id, first_name, last_name, title)
VALUES
		(1, 'Petar', 'sadsafga', 'acc'),
		(2, 'sadfPetar', 'sadsdsadafga', 'acsdac'),
		(3, 'Petfgadaar', 'sfadsdadasafga', 'acdsadc');

INSERT INTO customers
		(id, driver_licence_number, full_name, address, city, zip_code)
VALUES
		(1, 23545464, 'sdadad', 'sdada', 'sdadasd', 19345),
		(2, 23548464, 'sdasddad', 'sdsdada', 'sgdfdadasd', 19345),
		(3, 23545124, 'sdabzbzdad', 'szvdada', 'sdadavsd', 19345);
        
INSERT INTO rental_orders
		(id, employee_id, customer_id, car_id, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status)
VALUES
		(1, 1, 2, 1, 234, 256, 23, '1945-05-29', '1965-01-10', 232, 2324, 123, 'Accepted'),
		(2, 2, 3, 3, 23634, 2546, 253, '1945-05-29', '1965-01-10', 2342, 23324, 1223, 'Accepted'),
		(3, 1, 3, 2, 2374, 2556, 263, '1945-05-29', '1965-01-10', 2322, 23324, 1123, 'Accepted');


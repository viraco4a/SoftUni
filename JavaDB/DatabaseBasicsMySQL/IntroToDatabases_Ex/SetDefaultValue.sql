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
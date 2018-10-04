CREATE TABLE mountains(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE peaks(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    mountain_id INT(11) NOT NULL,
    CONSTRAINT fk_peak_mountains
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
);
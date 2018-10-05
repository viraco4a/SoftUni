CREATE TABLE manufacturers (
	manufacturer_id INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) UNIQUE NOT NULL,
	established_on DATE NOT NULL
);

CREATE TABLE models (
	model_id INT UNSIGNED UNIQUE AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
    manufacturer_id INT(11) UNSIGNED NOT NULL
) AUTO_INCREMENT=101;


ALTER TABLE manufacturers
	ADD CONSTRAINT pk_manufacturers
		PRIMARY KEY (manufacturer_id);

ALTER TABLE models
	ADD CONSTRAINT pk_models
		PRIMARY KEY (model_id),
	ADD CONSTRAINT fk_models_manufacturers
		FOREIGN KEY(manufacturer_id)
		REFERENCES manufacturers(manufacturer_id);


INSERT 
	INTO manufacturers (name, established_on)
	VALUES 
		('BMW', '1916-03-01'),
		('Tesla', '2003-01-01'),
		('Lada', '1966-05-01');

INSERT
	INTO models (name, manufacturer_id)
    VALUES
		('X1', 1),
		('i6', 1),
		('Model S', 2),
		('Model X', 2),
		('Model 3', 2),
		('Nova', 3);
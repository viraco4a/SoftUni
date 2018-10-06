CREATE TABLE students (
	student_id INT(11) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE exams (
	exam_id INT(11) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) UNIQUE NOT NULL
) AUTO_INCREMENT=101;

CREATE TABLE students_exams (
	student_id INT(11) UNSIGNED NOT NULL,
    exam_id INT(11) UNSIGNED NOT NULL
);


ALTER TABLE students
	ADD CONSTRAINT pk_students
		PRIMARY KEY (student_id);

ALTER TABLE exams
	ADD CONSTRAINT pk_exams
		PRIMARY KEY (exam_id);

ALTER TABLE students_exams
	ADD CONSTRAINT pk_students_exams
		PRIMARY KEY (student_id, exam_id),
    ADD CONSTRAINT fk_students_exam_map_students
		FOREIGN KEY(student_id)
		REFERENCES students(student_id),
	ADD CONSTRAINT fk_students_exam_map_exams
		FOREIGN KEY(exam_id)
		REFERENCES exams(exam_id);

INSERT 
	INTO students (name)
	VALUES 
		('Mila'),
		('Toni'),
		('Ron');

INSERT
	INTO exams (name)
    VALUES
		('Spring MVC'),
		('Neo4j'),
		('Oracle 11g');

INSERT 
	INTO students_exams
    VALUES  
		(1, 101),
		(1, 102),
		(2, 101),
		(3, 103),
		(2, 102),
		(2, 103);

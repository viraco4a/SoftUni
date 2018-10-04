CREATE TABLE projects(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id INT(11) NOT NULL,
    project_lead INT(11) NOT NULL
);

CREATE TABLE employees(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    project_id INT(11) NOT NULL
);

CREATE TABLE clients(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100) NOT NULL,
    project_id INT(11) NOT NULL
);
        
ALTER TABLE employees
ADD		CONSTRAINT fk_employees_projects
		FOREIGN KEY (project_id)
		REFERENCES projects(id);
        
ALTER TABLE clients
ADD		CONSTRAINT fk_client_project
		FOREIGN KEY (project_id)
		REFERENCES projects(id);

ALTER TABLE projects
ADD   	CONSTRAINT fk_project_clients
		FOREIGN KEY (client_id)
		REFERENCES clients(id),
ADD     CONSTRAINT fk_project_lead_employee
		FOREIGN KEY (project_lead)
		REFERENCES employees(id);

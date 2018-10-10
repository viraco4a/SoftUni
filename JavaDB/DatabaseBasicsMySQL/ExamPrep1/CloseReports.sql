DROP TRIGGER tr_complete_status;
DELIMITER $$
CREATE TRIGGER tr_complete_status
BEFORE UPDATE
ON reports
FOR EACH ROW
BEGIN
    IF (ISNULL(OLD.close_date) <> ISNULL(NEW.close_date)) THEN
        SET NEW.status_id = 3;
    END IF;
END $$
DELIMITER ;


UPDATE reports
SET close_date = now()
WHERE employee_id = 5;

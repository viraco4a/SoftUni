CREATE TABLE notification_emails(
	id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    recipient INT(11),
    `subject` VARCHAR(100), 
    body TEXT
);

DELIMITER $$
CREATE TRIGGER tr_changed_log_file
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails
		(recipient,
		`subject`,
		body)
	VALUES (
		NEW.account_id, 
		CONCAT('Balance change for account: ', NEW.account_id),
		CONCAT(
			'On',
			DATE_FORMAT(NOW(), '%b %d %Y at %r'), 
			'your balance was changed from ',
			ROUND(NEW.old_sum, 2),
			'to', ROUND(NEW.new_sum, 2), '.'));
END $$
DELIMITER ;

DROP TRIGGER tr_changed_log_file
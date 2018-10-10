DELIMITER $$
CREATE PROCEDURE udp_login(username VARCHAR(30), `password` VARCHAR(30))
BEGIN
	IF
		(SELECT COUNT(u.id) FROM users AS u WHERE u.username = username) = 0 
			THEN
				SIGNAL SQLSTATE '45000' 
					SET MESSAGE_TEXT =
					'Username does not exist!';
        ROLLBACK;    
    ELSEIF 
		(SELECT COUNT(u.id) FROM users AS u WHERE u.`password` = `password`) = 0
			THEN
				SIGNAL SQLSTATE '45000' 
					SET MESSAGE_TEXT =
					'Password is incorrect!';
        ROLLBACK;
	ELSEIF
		(SELECT COUNT(lu.id) FROM logged_in_users AS lu WHERE lu.username = username) != 0
			THEN
				SIGNAL SQLSTATE '45000' 
					SET MESSAGE_TEXT =
					'User is already logged in!';
		ROLLBACK;
    ELSE
		INSERT INTO logged_in_users SELECT * FROM users AS u WHERE u.username = username;
    END IF;
END $$

DELIMITER ;

CALL udp_login('doge', 'doge');

SELECT * FROM logged_in_users
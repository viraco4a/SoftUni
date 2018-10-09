DROP PROCEDURE usp_transfer_money;

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT(11),
to_account_id INT(11), money_amount DECIMAL(19, 4))
BEGIN
	IF (money_amount > 0
		AND from_account_id <> to_account_id)
        AND (SELECT a.id
			FROM accounts AS a
            WHERE a.id = from_account_id) IS NOT NULL
		AND (SELECT a.id
			FROM accounts AS a
            WHERE a.id = to_account_id) IS NOT NULL  
        
        THEN
		START TRANSACTION;
                
        UPDATE accounts AS a
        SET
			a.balance = a.balance - money_amount
			WHERE a.id = from_account_id;
            
		UPDATE accounts AS a
		SET
			a.balance = a.balance + money_amount
			WHERE a.id = to_account_id;
        
		IF (SELECT a.balance
			FROM accounts AS a
            WHERE a.id = from_account_id) < 0
			THEN ROLLBACK;
		ELSE
			COMMIT;
		END IF;
    END IF;
END $$
DELIMITER ;

CALL usp_transfer_money(2, 1, 10);

SELECT 
    a.id AS 'account_id', a.account_holder_id, a.balance
FROM
    `accounts` AS a
WHERE
    a.id < 3;
DROP PROCEDURE usp_deposit_money;

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT(11), money_amount DECIMAL (19, 4))
BEGIN
IF money_amount > 0 THEN
		START TRANSACTION;
		IF((SELECT COUNT(h.id)
				FROM account_holders AS h
				WHERE h.id LIKE account_id)<>1) THEN
		ROLLBACK;
		ELSE
			UPDATE accounts AS a
			SET balance = balance + money_amount
			WHERE a.id = account_id;
		END IF;
    END IF;
END $$
DELIMITER ;

CALL usp_deposit_money(1, 10)
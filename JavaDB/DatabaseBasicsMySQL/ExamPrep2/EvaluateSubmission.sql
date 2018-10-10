DROP PROCEDURE udp_evaluate;

DELIMITER $$
CREATE PROCEDURE udp_evaluate(id INT)
BEGIN
	IF
		(SELECT COUNT(s.id) FROM submissions AS s WHERE s.id = id) = 0 
			THEN
				SIGNAL SQLSTATE '45000' 
					SET MESSAGE_TEXT =
					'Submission does not exist!';
        ROLLBACK;
    ELSE
		INSERT INTO evaluated_submissions 
			SELECT 
				s.id,
                p.name AS problem,
                u.username AS user,
                CEIL(p.points / p.tests * s.passed_tests) AS result
			FROM submissions AS s 
            JOIN problems AS p ON p.id = s.problem_id
            JOIN users AS u ON u.id = s.user_id
			WHERE s.id = id;
    END IF;
END $$
DELIMITER ;

CALL udp_evaluate(1);

SELECT * FROM evaluated_submissions
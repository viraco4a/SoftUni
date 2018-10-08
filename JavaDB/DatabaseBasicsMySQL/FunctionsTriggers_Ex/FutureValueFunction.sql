DROP FUNCTION ufn_calculate_future_value;

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (initial_sum DECIMAL (19, 2),
 rate DOUBLE,
 years INT(11))
RETURNS DOUBLE
BEGIN
    RETURN ROUND(initial_sum * (POW((1 + rate), years)), 2);
END $$
DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.1, 5) AS Output
SELECT 
		SUM(home.deposit_amount - guest.deposit_amount) AS 'sum_difference'
FROM 
		wizzard_deposits AS home,
        wizzard_deposits AS guest
WHERE
		guest.id - home.id = 1;
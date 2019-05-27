import math

money = float(input())
coins_count = 0


if math.floor(money) == 5:
    money -= 5
    money *= 100
    money -= 50
    if money < 9:
        raise ValueError("kur")

coins = math.floor(money) // 2
money -= coins * 2
coins_count += coins

coins = math.floor(money)
money -= coins
coins_count += coins

money *= 100
coins = math.floor(money) // 50
money -= coins * 50
coins_count += coins

coins = math.floor(money) // 20
money -= coins * 20
coins_count += coins

coins = math.floor(money) // 10
money -= coins * 10
coins_count += coins

coins = math.floor(money) // 5
money -= coins * 5
coins_count += coins

coins = math.floor(money) // 2
money -= coins * 2
coins_count += coins

coins = math.floor(money)
money -= coins
coins_count += coins

print((coins_count))
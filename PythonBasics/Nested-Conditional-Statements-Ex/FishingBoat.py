budget = float(input())
season = input()
quantity = int(input())
cost = 0.0

if season == "Spring":
    cost = 3000
elif season == "Summer" or season == "Autumn":
    cost = 4200
elif season == "Winter":
    cost = 2600

if quantity <= 6:
    cost *= 0.9
elif 7 <= quantity <= 11:
    cost *= 0.85
elif 12 <= quantity:
    cost *= 0.75

if quantity % 2 == 0 and season != "Autumn":
    cost *= 0.95

if cost <= budget:
    money = budget - cost
    print(f"Yes! You have {money:.2f} leva left.")
else:
    money = cost - budget
    print(f"Not enough money! You need {money:.2f} leva.")
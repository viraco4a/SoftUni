type = input()
quantity = int(input())
budget = float(input())
price = 0.0

if  type == "Roses":
    price = quantity * 5
    if quantity > 80:
        price *= 0.9
elif type == "Dahlias":
    price = quantity * 3.8
    if quantity > 90:
        price *= 0.85
elif type == "Tulips":
    price = quantity * 2.8
    if quantity > 80:
        price *= 0.85
elif type == "Narcissus":
    price = quantity * 3
    if quantity < 120:
        price *= 1.15
elif type == "Gladiolus":
    price = quantity * 2.5
    if quantity < 80:
        price *= 1.2

if price <= budget:
    money = budget - price
    print(f"Hey, you have a great garden with {quantity} {type} and {money:.2f} leva left.")
else:
    money = price - budget
    print(f"Not enough money, you need {money:.2f} leva more.")
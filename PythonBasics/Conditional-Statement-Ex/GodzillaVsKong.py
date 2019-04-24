budget = float(input())
actors = int(input())
price_per_actor = float(input())
decor = 0.1 * budget
if actors > 150:
    price_per_actor *= 0.9
cost = actors * price_per_actor + decor
if budget < cost:
    result = cost - budget
    print("Not enough money!")
    print(f"Wingard needs {result:.2f} leva more.")
else:
    result = budget - cost
    print("Action!")
    print(f"Wingard starts filming with {result:.2f} leva left.")
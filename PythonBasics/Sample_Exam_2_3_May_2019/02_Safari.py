budget = float(input())
fuel_needed = float(input())
day = input()
total = fuel_needed * 2.1 + 100
if day == "Saturday":
    total *= 0.9
elif day == "Sunday":
    total *= 0.8
diff = abs(total - budget)
if total <= budget:
    print(f"Safari time! Money left: {diff:.2f} lv.")
else:
    print(f"Not enough money! Money needed: {diff:.2f} lv.")
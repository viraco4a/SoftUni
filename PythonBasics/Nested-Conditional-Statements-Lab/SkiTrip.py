totalDays = int(input())
typeOfRoom = input()
rate = input()
price = 0

if typeOfRoom == "room for one person":
    price = (totalDays - 1) * 18
elif typeOfRoom == "apartment":
    price = (totalDays - 1) * 25
    if totalDays < 10:
        price *= 0.7
    elif totalDays < 15:
        price *= 0.65
    elif totalDays >= 15:
        price *= 0.5
elif typeOfRoom == "president apartment":
    price = (totalDays - 1) * 35
    if totalDays < 10:
        price *= 0.9
    elif totalDays < 15:
        price *= 0.85
    elif totalDays >= 15:
        price *= 0.8

if rate == "positive":
    price *= 1.25
else:
    price *= 0.9

print(f"{price:.02f}")

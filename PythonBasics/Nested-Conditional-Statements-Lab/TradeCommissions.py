town = input()
sells = float(input())
price = 0

if town == "Sofia":
    if 0 <= sells <= 500:
        price = sells * 0.05
    elif 500 < sells <= 1000:
        price = sells * 0.07
    elif 1000 < sells <= 10000:
        price = sells * 0.08
    elif 10000 < sells:
        price = sells * 0.12
    else:
        price = -1
elif town == "Varna":
    if 0 <= sells <= 500:
        price = sells * 0.045
    elif 500 < sells <= 1000:
        price = sells * 0.075
    elif 1000 < sells <= 10000:
        price = sells * 0.1
    elif 10000 < sells:
        price = sells * 0.13
    else:
        price = -1
elif town == "Plovdiv":
    if 0 <= sells <= 500:
        price = sells * 0.055
    elif 500 < sells <= 1000:
        price = sells * 0.08
    elif 1000 < sells <= 10000:
        price = sells * 0.12
    elif 10000 < sells:
        price = sells * 0.145
    else:
        price = -1
else:
    price = -1

if price >= 0:
    print(f"{price:.2f}")
else:
    print("error")
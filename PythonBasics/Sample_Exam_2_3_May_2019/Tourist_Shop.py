budget = float(input())
product = input()
counter = 0
total = 0
while product != "Stop":
    counter += 1
    price = float(input())
    if counter % 3 == 0:
        total += price  * 0.5
    else:
        total += price
    diff = total - budget
    if diff > 0:
        print("You don't have enough money!")
        print(f"You need {diff:.2f} leva!")
        exit()
    product = input()
print(f"You bought {counter} products for {total:.2f} leva.")
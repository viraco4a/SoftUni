n = int(input())
fish = input()
counter = 0
win = 0
lose = 0
while fish != "Stop":
    counter += 1
    kg = float(input())
    price = 0
    for c in fish:
        price += ord(c)
    price /= kg
    if counter % 3 == 0:
        win += price
    else:
        lose += price
    if counter == n:
        print("Lyubo fulfilled the quota!")
        break
    fish = input()
if win > lose:
    money = win - lose
    print(f"Lyubo's profit from {counter} fishes is {money:.2f} leva.")
else:
    money = lose - win
    print(f"Lyubo lost {money:.2f} leva today.")
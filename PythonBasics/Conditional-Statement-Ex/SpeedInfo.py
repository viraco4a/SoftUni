number = float(input())
speed = ""
if number <= 10:
    speed = "slow"
elif number <= 50:
    speed = "average"
elif number <= 150:
    speed = "fast"
elif number <= 1000:
    speed = "ultra fast"
else:
    speed = "extremely fast"
print(speed)
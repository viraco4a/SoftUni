total = 0
line = input()
while line != "Going home":
    steps = int(line)
    total += steps
    if total >= 10000:
        print("Goal reached! Good job!")
        exit()
    line = input()
steps = int(input())
total += steps
if total >= 10000:
    print("Goal reached! Good job!")
else:
    print(f"{10000 - total} more steps to reach goal.")
floors = int(input())
rooms = int(input())
last_floor = ""
current = ""
for i in range(rooms):
    last_floor += "L" + str(floors) + str(i) + " "
print(last_floor)
for i in range(floors - 1, 0, -1):
    for j in range(rooms):
        if i % 2 != 0:
            current += "A" + str(i) + str(j) + " "
        else:
            current += "O" + str(i) + str(j) + " "
    current += "\n"
print(current)
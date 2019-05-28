width = int(input())
length = int(input())
cake_size = width * length
line = input()
while line != "STOP":
    pieces = int(line)
    cake_size -= pieces
    if cake_size < 0:
        print(f"No more cake left! You need {-cake_size} pieces more.")
        exit()
    line = input()
print(f"{cake_size} pieces are left.")
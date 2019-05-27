width = int(input())
length = int(input())
height = int(input())
volume = width * length * height
input_line = input()
while input_line != "Done":
    boxes = int(input_line)
    volume -= boxes
    if volume <= 0:
        print(f"No more free space! You need {-volume} Cubic meters more.")
        exit()
    input_line = input()
print(f"{volume} Cubic meters left.")
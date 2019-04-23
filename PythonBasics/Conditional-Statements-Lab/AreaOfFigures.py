import math

figure = input()
size = float(input())
area = 0
if figure == "square":
    area = size ** 2
elif figure == "rectangle":
    second = float(input())
    area = size * second
elif figure == "triangle":
    height = float(input())
    area = size * height / 2
else:
    area = math.pi * size ** 2
print(f"{area:.3f}")
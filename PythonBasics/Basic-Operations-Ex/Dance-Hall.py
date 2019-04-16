import math

length = float(input())
width = float(input())
sideA = float(input())

roomArea = length * width * 10000
bench = 0.1 * roomArea
wardrobe = (sideA * 100) ** 2
dancerSpace = 40 + 7000

freeSpace = roomArea - wardrobe - bench

count = freeSpace / dancerSpace

print(math.floor(count))
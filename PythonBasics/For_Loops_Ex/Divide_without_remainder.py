n = int(input())
two = 0
three = 0
four = 0
for i in range(0, n):
    num = int(input())
    if num % 4 == 0:
        four += 1
    if num % 2 == 0:
        two += 1
    if num % 3 == 0:
        three += 1
p2 = (two / n) * 100
p3 = (three / n) * 100
p4 = (four / n) * 100
print(f"{p2:.2f}%")
print(f"{p3:.2f}%")
print(f"{p4:.2f}%")
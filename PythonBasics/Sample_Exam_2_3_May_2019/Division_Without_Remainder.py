n = int(input())
p1 = 0
p2 = 0
p3 = 0
for i in range(n):
    num = int(input())
    if num % 2 == 0:
        p1 += 1
    if num % 3 == 0:
        p2 += 1
    if num % 4 == 0:
        p3 += 1
p1 *= 100 / n
p2 *= 100 / n
p3 *= 100 / n
print(f"{p1:.2f}%")
print(f"{p2:.2f}%")
print(f"{p3:.2f}%")
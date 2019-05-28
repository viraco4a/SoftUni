n = int(input())
one = 0
two = 0
three = 0
four = 0
five = 0
for i in range(0, n):
    num = int(input())
    if num < 200:
        one += 1
    elif 200 <= num < 400:
        two += 1
    elif 400 <= num < 600:
        three += 1
    elif 600 <= num < 800:
        four += 1
    elif 800 <= num:
        five += 1
p1 = (one / n) * 100
p2 = (two / n) * 100
p3 = (three / n) * 100
p4 = (four / n) * 100
p5 = (five / n) * 100
print(f"{p1:.2f}%")
print(f"{p2:.2f}%")
print(f"{p3:.2f}%")
print(f"{p4:.2f}%")
print(f"{p5:.2f}%")
n = int(input())
min = 10000000000000000
max = -10000000000000000
for i in range(0, n):
    num = int(input())
    if num > max:
        max = num
    if num < min:
        min = num
print(f"Max number: {max}")
print(f"Min number: {min}")
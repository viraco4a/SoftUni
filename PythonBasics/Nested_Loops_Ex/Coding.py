number = int(input())
n = len(str(number))
for row in range(n):
    num = number % 10
    if num == 0:
        print("ZERO", end="")
    else:
        c = chr(num + 33)
        for col in range(num):
            print(str(c), end="")
    number = number // 10
    print()
n = int(input())
current = 1
isBigger = False
for i in range(1, n + 1):
    for j in range(1, i + 1):
        if current > n:
            isBigger = True
            break
        print(str(current) + " ", end="")
        current += 1
    if isBigger:
        break
    print()
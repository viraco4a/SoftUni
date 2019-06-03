n = int(input())
l = int(input())
result = ""
for x1 in range(1, n):
    for x2 in range(1, n):
        for x3 in range(97, 97 + l):
            for x4 in range(97, 97 + l):
                for x5 in range(1, n + 1):
                    if x5 > x1 and x5 > x2:
                        result += str(x1) + str(x2) + chr(x3) + chr(x4) + str(x5) + " "
print(result)
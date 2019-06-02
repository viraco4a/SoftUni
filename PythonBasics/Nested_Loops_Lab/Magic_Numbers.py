n = int(input())
result = 1
final = ""
for x1 in range(1, 10):
    for x2 in range(1, 10):
        for x3 in range(1, 10):
            for x4 in range(1, 10):
                for x5 in range(1, 10):
                    for x6 in range(1, 10):
                        result = x1 * x2 * x3 * x4 * x5 * x6
                        if result == n:
                            final += str(x1) + str(x2) + str(x3) + str(x4) + str(x5) + str(x6) + " "
print(final)
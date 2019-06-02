n = int(input())
counter = 0
for x1 in range(n + 1):
    for x2 in range(n + 1):
        for x3 in range(n + 1):
            for x4 in range(n + 1):
                for x5 in range(n + 1):
                    local_sum = x1 + x2 + x3 + x4 + x5
                    if local_sum == n:
                        counter += 1
print(counter)
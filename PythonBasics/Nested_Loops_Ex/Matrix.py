a = int(input())
b = int(input())
c = int(input())
d = int(input())

for a11 in range(a, b + 1):
    for a12 in range(a, b + 1):
        for a21 in range(c, d + 1):
            for a22 in range(c, d + 1):
                if a11 != a12 and a21 != a22 and a11 + a22 == a12 + a21:
                    print(str(a11) + str(a12))
                    print(str(a21) + str(a22) + "\n")

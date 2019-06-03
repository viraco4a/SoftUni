n = int(input())
result = ""
for i in range(1111, 10000):
    isSpecial = True
    local = i
    for j in range(4):
        num = local % 10
        if num == 0 or n % num != 0:
            isSpecial = False
            break
        local //= 10
    if isSpecial:
        result += str(i) + " "
print(result)
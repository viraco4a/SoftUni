first = int(input())
second = int(input())
result = ""
for i in range(first, second + 1):
    even_sum = 0
    odd_sum = 0
    local = i
    for j in range(1, 7):
        num = local % 10
        local = local // 10
        if j % 2 == 0:
            even_sum += num
        else:
            odd_sum += num
    if even_sum == odd_sum:
        result += str(i) + " "
print(result)
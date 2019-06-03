first = int(input())
second = int(input())
result = ""
for i in range(first, second + 1):
    left_sum = 0
    right_sum = 0
    center = 0
    local = i
    for j in range(1, 6):
        num = local % 10
        local = local // 10
        if j < 3:
            left_sum += num
        elif j > 3:
            right_sum += num
        else:
            center = num
    diff = abs(left_sum - right_sum)
    if diff == 0:
        result += str(i) + " "
    elif left_sum < right_sum:
        diff = left_sum + center
        if diff == right_sum:
            result += str(i) + " "
    elif left_sum > right_sum:
        diff = right_sum + center
        if diff == left_sum:
            result += str(i) + " "
print(result)
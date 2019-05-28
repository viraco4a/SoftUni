n = int(input())
max_num = -100000000000
sum = 0
for i in range(0, n):
    num = int(input())
    if i == 0:
        max_num = num
    elif num > max_num and i != 0:
        sum += max_num
        max_num = num
    else:
        sum += num
if sum == max_num:
    print("Yes")
    print(f"Sum = {sum}")
else:
    print("No")
    print(f"Diff = {abs(max_num - sum)}")
n = int(input())
max_num = -10000000000000000
counter = 0
while counter < n:
    num = int(input())
    if num > max_num:
        max_num = num
    counter += 1
print(max_num)
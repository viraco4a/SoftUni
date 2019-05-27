n = int(input())
min_num = 10000000000000000
counter = 0
while counter < n:
    num = int(input())
    if num < min_num:
        min_num = num
    counter += 1
print(min_num)
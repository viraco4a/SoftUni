n = int(input())
odd_sum = 0
even_sum = 0
for i in range(0, n):
    num = int(input())
    if i % 2 == 0:
        even_sum += num
    else:
        odd_sum += num
if even_sum == odd_sum:
    print("Yes")
    print(f"Sum = {even_sum}")
else:
    print("No")
    print(f"Diff = {abs(even_sum - odd_sum)}")
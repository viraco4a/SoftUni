n = int(input())
max_diff = 0
previous_sum = 0
sum = 0
are_equal = True
for i in range(0, n):
    first = int(input())
    second = int(input())
    local = first + second
    if i == 0:
        sum = local
        previous_sum = local
        max_diff = abs(previous_sum - sum)
    if local != sum:
        are_equal = False
    sum = local
    diff = abs(previous_sum - sum)
    if diff > max_diff:
        max_diff = diff
    previous_sum = local
if are_equal:
    print(f"Yes, value={sum}")
else:
    print(f"No, maxdiff={max_diff}")
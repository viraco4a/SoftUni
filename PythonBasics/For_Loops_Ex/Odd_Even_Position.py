n = int(input())
odd_sum = 0
odd_min = 10000000
odd_max = -10000000
even_sum = 0
even_min = 10000000
even_max = -10000000
no_max_odd = True
no_max_even = True
no_min_odd = True
no_min_even = True
for i in range(1, n + 1):
    num = float(input())
    if i % 2 == 0:
        even_sum += num
        if num > even_max:
            even_max = num
            no_max_even = False
        if num < even_min:
            even_min = num
            no_min_even = False
    else:
        odd_sum += num
        if num > odd_max:
            odd_max = num
            no_max_odd = False
        if num < odd_min:
            odd_min = num
            no_min_odd = False
print(f"OddSum={odd_sum:.2f},")
if no_min_odd:
    print("OddMin=No,")
else:
    print(f"OddMin={odd_min:.2f},")
if no_max_odd:
    print("OddMax=No,")
else:
    print(f"OddMax={odd_max:.2f},")
print(f"EvenSum={even_sum:.2f},")
if no_min_even:
    print("EvenMin=No,")
else:
    print(f"EvenMin={even_min:.2f},")
if no_max_even:
    print("EvenMax=No")
else:
    print(f"EvenMax={even_max:.2f}")
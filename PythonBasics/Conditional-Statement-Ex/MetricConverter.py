number = float(input())
first = input()
second = input()
number_m = 0
if first == "m":
    number_m = number
elif first == "cm":
    number_m = number / 100
else:
    number_m = number / 1000
result = 0
if second == "m":
    result = number_m
elif second == "cm":
    result = number_m * 100
else:
    result = number_m * 1000
print(f"{result:.3f}")
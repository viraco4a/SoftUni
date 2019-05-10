screening_type = input()
rows = int(input())
cols = int(input())
income = 0
cinema_capacity = rows * cols

if screening_type == "Premiere":
    income = cinema_capacity * 12
elif screening_type == "Normal":
    income = cinema_capacity * 7.5
elif screening_type == "Discount":
    income = cinema_capacity * 5

print(f"{income:.2f}")
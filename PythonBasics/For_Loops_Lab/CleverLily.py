age = int(input())
laundry_price = float(input())
toy_price = float(input())
budget = 0
toys = 0
even_birthdays = 0
for i in range(1, age + 1):
    if i % 2 == 0:
        even_birthdays += 1
        budget += even_birthdays * 10 - 1
    else:
        toys += 1
budget += toy_price * toys
diff = abs(budget - laundry_price)
if budget >= laundry_price:
    print(f"Yes! {diff:.2f}")
else:
    print(f"No! {diff:.2f}")
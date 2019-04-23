first = 2.6
second = 3
third = 4.1
fourth = 8.2
fifth = 2
discount = 0.25
discount_amount = 50
rent = 0.1

excursion_price = float(input())
first_num = int(input())
second_num = int(input())
third_num = int(input())
fourth_num = int(input())
fifth_num = int(input())

profit = first_num * first + second_num * second + third_num * third + fourth_num * fourth + fifth_num * fifth
order = first_num + second_num + third_num + fourth_num + fifth_num

if order >= discount_amount:
    profit *= (1 - discount)

profit *= (1 - rent)

difference = profit - excursion_price
if difference >= 0:
    print(f"Yes! {difference:.2f} lv left.")
else:
    print(f"Not enough money! {-difference:.2f} lv needed.")
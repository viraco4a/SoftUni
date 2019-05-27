needed_money = float(input())
current_budget = float(input())
spend_counter = 0
days = 0
while True:
    days += 1
    action_type = input()
    money = float(input())
    if action_type == "spend":
        spend_counter += 1
        current_budget -= money
        if current_budget < 0:
            current_budget = 0
        if spend_counter == 5:
            print("You can't save the money.")
            print(days)
            break
    else:
        spend_counter = 0
        current_budget += money
        if current_budget >= needed_money:
            print(f"You saved the money for {days} days.")
            break
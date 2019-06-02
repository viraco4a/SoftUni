input_line = input()
while input_line != "End":
    budget = float(input())
    money = 0
    while money < budget:
        income = float(input())
        money += income
    print(f"Going to {input_line}!")
    input_line = input()
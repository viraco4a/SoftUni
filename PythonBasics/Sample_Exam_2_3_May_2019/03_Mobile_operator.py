contract = input()
type = input()
mobile = input()
months = int(input())
tax = 0
if contract == "one":
    if type == "Small":
        tax = 9.98
    elif type == "Middle":
        tax = 18.99
    elif type == "Large":
        tax = 25.98
    elif type == "ExtraLarge":
        tax = 35.99
elif contract == "two":
    if type == "Small":
        tax = 8.58
    elif type == "Middle":
        tax = 17.09
    elif type == "Large":
        tax = 23.59
    elif type == "ExtraLarge":
        tax = 31.79
if mobile == "yes":
    if tax <= 10:
        tax += 5.5
    elif tax <= 30:
        tax += 4.35
    else:
        tax += 3.85
tax *= months
if contract == "two":
    tax *= (1 - 0.0375)
print(f"{tax:.2f} lv.")
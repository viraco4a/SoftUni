payments = int(input())
counter = 0
balance = 0
while counter < payments:
    sum = float(input())
    if  sum < 0:
        print("Invalid operation!")
        break
    else:
        print(f"Increase: {sum:.2f}")
        balance += sum
        counter += 1
print(f"Total: {balance:.2f}")

n = int(input())
presentation = input()
total = 0
counter = 0
while presentation != "Finish":
    sum = 0
    for i in range(n):
        num = float(input())
        sum += num
    avr = sum / n
    total += avr
    print(f"{presentation} - {avr:.2f}.")
    presentation = input()
    counter += 1
total /= counter
print(f"Student's final assessment is {total:.2f}.")
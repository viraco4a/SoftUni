name = input()
max_sum = 0
winner = ""
while name != "STOP":
    sum = 0
    for i in name:
        sum += ord(i)
    if sum > max_sum:
        max_sum = sum
        winner = name
    name = input()
print(f"Winner is {winner} - {max_sum}!")
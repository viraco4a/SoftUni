days = int(input())
hours = int(input())
total = 0
for i in range(1, days + 1):
    local = 0
    for j in range(1, hours + 1):
        if i % 2 == 0 and j % 2 != 0:
            local += 2.5
        elif i % 2 != 0 and j % 2 == 0:
            local += 1.25
        else:
            local += 1
    print(f"Day: {i} - {local:.2f} leva")
    total += local
print(f"Total: {total:.2f} leva")
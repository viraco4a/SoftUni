hours = int(input())
minutes = int(input())
minutes += 15
if minutes >= 60:
    minutes -= 60
    hours += 1
    if hours == 24:
        hours -= 24
print(f"{hours}:{minutes:02d}")
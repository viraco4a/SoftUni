budget = float(input())
season = input()
destination = None
holiday = None

if budget <= 100:
    destination = "Bulgaria"
    if season == "summer":
        budget *= 0.3
        holiday = "Camp"
    else:
        budget *= 0.7
        holiday = "Hotel"
elif budget <= 1000:
    destination = "Balkans"
    if season == "summer":
        budget *= 0.4
        holiday = "Camp"
    else:
        budget *= 0.8
        holiday = "Hotel"
else:
    destination = "Europe"
    budget *= 0.9
    holiday = "Hotel"

print(f"Somewhere in {destination}")
print(f"{holiday} - {budget:.2f}")
chicken_menus = int(input())
fish_menus = int(input())
vegan_menus = int(input())
total = chicken_menus * 10.35 + fish_menus * 12.4 + vegan_menus * 8.15
total *= 1.2
total += 2.5
print(f"Total: {total:.2f}")
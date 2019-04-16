dogFoodPrice = 2.5
nonDogFoodPrice = 4.0
dogsCount = int(input())
nonDogsCount = int(input())
result = dogsCount * dogFoodPrice + nonDogsCount * nonDogFoodPrice
print(f'{result:.2f} lv.')
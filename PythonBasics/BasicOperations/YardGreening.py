pricePerSquareMeter = 7.61
discount = 0.18
area = float(input())
tmpPrice = pricePerSquareMeter * area
discountedPrice = discount * tmpPrice
finalPrice = tmpPrice - discountedPrice
print(f'The final price is: {finalPrice:.2f} lv.')
print(f'The discount is: {discountedPrice:.2f} lv.')

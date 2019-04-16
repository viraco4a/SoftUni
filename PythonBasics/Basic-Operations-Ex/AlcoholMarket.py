wiskeyPrice = float(input())
beerQuantity = float(input())
wineQuantity = float(input())
rakiaQuantity = float(input())
wiskeyQuantity = float(input())
rakiaPrice = wiskeyPrice / 2
winePrice = 0.6 * rakiaPrice
beerPrice = 0.2 * rakiaPrice

cost = wiskeyPrice * wiskeyQuantity + winePrice * wineQuantity + beerPrice * beerQuantity + rakiaPrice * rakiaQuantity

print('%.2f' % cost)
cake = 45
waffle = 5.8
pancake = 3.2

campaignDays = int(input())
confectionersCount = int(input())
cakesCount = int(input())
wafflesCount = int(input())
pancakeCount = int(input())

total = (cake * cakesCount + waffle * wafflesCount + pancake * pancakeCount) * confectionersCount * campaignDays
result = total * (7 / 8)

print('%.2f' % result)

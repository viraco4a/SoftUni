fixing = 1.85
blanketPriec = 7
quadrantPrice = 9
tables = int(input())
length = float(input())
width = float(input())

blanketAreaPerTable = (length + 2 * 0.3) * (width + 2 * 0.3)
quadrantAreaPerTable = (length / 2) ** 2

usd = tables * (blanketAreaPerTable * blanketPriec + quadrantAreaPerTable * quadrantPrice)
bgn = usd * fixing

print('%.2f USD' % usd)
print('%.2f BGN' % bgn)
import math

x1 = float(input())
y1 = float(input())
x2 = float(input())
y2 = float(input())

a = math.fabs(x1 - x2)
b = math.fabs(y1 - y2)

area = a * b
perimeter = 2 * (a + b)

print('%.2f' % area)
print('%.2f' % perimeter)
#print(str(area).rstrip('0').rstrip('.'))
#print(str(perimeter).rstrip('0').rstrip('.'))
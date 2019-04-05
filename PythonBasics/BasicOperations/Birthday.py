length = float(input())
width = float(input())
height = float(input())
percent = float(input()) / 100
volume = length * width * height * 0.001
result = volume * (1 - percent)
print('%.3f' % result)
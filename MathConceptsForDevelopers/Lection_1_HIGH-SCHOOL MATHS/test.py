import math
def solve_linear_equation(a, b):
    if  a == 0:
        if b == 0:
            return []
        else:
            return math.nan
    else:
        return -b / a

print(solve_linear_equation(2.5, -5.3))
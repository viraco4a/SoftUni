import math

def get_year_XX_century(EGN):
    year = 1900 + math.floor(EGN / 100000000)
    return year

def get_year_XIX_century(EGN):
    year = 1800 + math.floor(EGN / 100000000)
    return year

def get_year_XXI_century(EGN):
    year = 2000 + math.floor(EGN / 100000000)
    return year

def zero_year_correction(EGN, zeroes, century):
    if zeroes == 1:
        return century + math.floor(EGN / 100000000)
    elif zeroes == 2:
        return century + math.floor(EGN / 10000000)
    else:
        return century + math.floor(EGN / 1000000)

def zero_year_check(EGN, century):
    if EGN < 10000000:
        return zero_year_correction(EGN, 3, century)
    elif EGN < 100000000:
        return zero_year_correction(EGN, 2, century)
    else:
        return zero_year_correction(EGN, 1, century)

def get_year_from_EGN(EGN):
    months = math.floor(EGN / 1000000) % 100
    if EGN >= 1000000000:
        if months < 20:
            year = get_year_XX_century(EGN)
        elif months > 40:
            year = get_year_XXI_century(EGN)
        else:
            year = get_year_XIX_century(EGN)
    else:
        if months < 20:
            year = zero_year_check(EGN, 1900)
        elif months > 40:
            year = zero_year_check(EGN, 2000)
        else:
            year = zero_year_check(EGN, 1800)
    return year

print(get_year_from_EGN(171171))


number = int(input())


def number_checker(num):
    switcher = {
        1: "one",
        2: "two",
        3: "three",
        4: "four",
        5: "five",
        6: "six",
        7: "seven",
        8: "eight",
        9: "nine"
    }
    return switcher.get(num, "number too big")


print(number_checker(number))
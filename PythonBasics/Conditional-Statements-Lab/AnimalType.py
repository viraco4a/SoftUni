animal = input()


def zoo(animal):
    if animal == "dog":
        return "mammal"
    elif animal == "crocodile" or animal == "tortoise" or animal == "snake":
        return "reptile"
    return "unknown"

print(zoo(animal))
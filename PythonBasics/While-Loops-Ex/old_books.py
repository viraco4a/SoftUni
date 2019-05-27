seeked_book = input()
n = int(input())
counter = 0
while counter < n:
    book = input()
    if book == seeked_book:
        print(f"You checked {counter} books and found it.")
        exit()
    counter += 1
print("The book you search is not here!")
print(f"You checked {n} books.")
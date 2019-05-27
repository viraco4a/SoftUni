bad_grades = int(input())
bad_grades_counter = 0
avr_score = 0
counter = 0
line = input()
last = line
while line != "Enough":
    grade = int(input())
    if grade <= 4:
        bad_grades_counter += 1
    if bad_grades == bad_grades_counter:
        print(f"You need a break, {bad_grades} poor grades.")
        exit()
    avr_score += grade
    last = line
    line = input()
    counter += 1
avr_score /= counter
print(f"Average score: {avr_score:.2f}")
print(f"Number of problems: {counter}")
print(f"Last problem: {last}")
student_name = input()
sum = 0.0
counter = 0
expelling_counter = 0
while counter < 12:
    grade = float(input())
    if grade < 4.0:
        expelling_counter += 1
        if expelling_counter == 1:
            continue
        else:
            print(f"{student_name} has been excluded at {counter + 1} grade")
            exit()
    sum += grade
    counter += 1
final_grade = sum / 12.0
print(f"{student_name} graduated. Average grade: {final_grade:.2f}")
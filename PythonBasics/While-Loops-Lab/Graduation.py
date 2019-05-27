student_name = input()
sum = 0.0
counter = 0
while counter < 12:
    grade = float(input())
    if grade < 4.0:
        continue
    sum += grade
    counter += 1
final_grade = sum / 12.0
print(f"{student_name} graduated. Average grade: {final_grade:.2f}")
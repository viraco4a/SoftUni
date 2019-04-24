import math

income = float(input())
average_grade = float(input())
min_wage = float(input())
social_scholarship = 0.35 * min_wage
grade_scholarship = average_grade * 25
has_grade = average_grade >= 5.5
has_social = average_grade >= 4.5 and income < min_wage
if has_grade and has_social:
    if grade_scholarship >= social_scholarship:
        scholarship = math.floor(grade_scholarship)
        print(f"You get a scholarship for excellent results {scholarship} BGN")
    else:
        scholarship = math.floor(social_scholarship)
        print(f"You get a Social scholarship {scholarship} BGN")
elif has_social:
    scholarship = math.floor(social_scholarship)
    print(f"You get a Social scholarship {scholarship} BGN")
elif has_grade:
    scholarship = math.floor(grade_scholarship)
    print(f"You get a scholarship for excellent results {scholarship} BGN")
else:
    print("You cannot get a scholarship!")
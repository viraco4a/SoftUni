n = int(input())
salary = int(input())
for i in range(0, n):
    site = input()
    if site == "Facebook":
        salary -= 150
    elif site == "Instagram":
        salary -= 100
    elif site == "Reddit":
        salary -= 50
    if salary <= 0:
        print("You have lost your salary.")
        exit()
print(salary)
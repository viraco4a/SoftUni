def is_prime(num):
    if number < 2:
        return False
    for i in range(2, num // 2 + 1):
        if num % i == 0:
            return False
    return True


line = input()
prime_sum = 0
non_prime_sum = 0
while line != "stop":
    number = int(line)
    if number < 0:
        line = input()
        print("Number is negative.")
        continue
    if is_prime(number):
        prime_sum += number
    else:
        non_prime_sum += number
    line = input()

print(f"Sum of all prime numbers is: {prime_sum}")
print(f"Sum of all non prime numbers is: {non_prime_sum}")
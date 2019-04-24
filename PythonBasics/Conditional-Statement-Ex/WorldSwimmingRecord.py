import math

record = float(input())
distance = float(input())
second_1m = float(input())
time = distance * second_1m
delay = math.floor((distance / 15))
delay *= 12.5
total_time = time + delay
if total_time < record:
    print(f"Yes, he succeeded! The new world record is {total_time:.2f} seconds.")
else:
    print(f"No, he failed! He was {(total_time - record):.2f} seconds slower.")
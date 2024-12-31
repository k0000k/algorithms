import sys

num = sys.stdin.readline().rstrip()
numbers = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

for i in num:
    numbers[int(i)] += 1

sum = (numbers[9] + numbers[6]) // 2
if ((numbers[9] + numbers[6]) % 2 == 1):
    sum += 1

numbers[9] = 0
numbers[6] = sum

print(max(numbers))
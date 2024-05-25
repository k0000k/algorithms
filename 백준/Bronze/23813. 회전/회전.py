str_num = input()
length = len(str_num)

sum = 0
for i in str_num:
    sum += int(i)

ten = 1
result = 0
for i in range(length):
    result += (ten * sum)
    ten *= 10

print(result)
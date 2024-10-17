import sys

n = int(sys.stdin.readline().rstrip())
scores = 0

for i in range(n):
    num = sys.stdin.readline().rstrip()
    if (num == "100"):
        scores += 100
    else:
        new_num = ""
        for j in num:
            if (j == "0" or j == "6" or j == "9"):
                new_num += "9"
            else:
                new_num += j
        scores += int(new_num)

answer = scores / n
if (answer - int(answer) >= 0.5):
    print(int(answer) + 1)
else:
    print(int(answer))
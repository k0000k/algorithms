import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
numbers = []

for _ in range(n):
    temp = list(map(int, sys.stdin.readline().rstrip().split()))
    numbers.append(temp)

camulative = [[0 for i in range(n)] for j in range(n)]
for i in range(n):
    sum = 0
    for j in range(n):
        sum += numbers[j][i]
        camulative[j][i] = sum

for i in range(n):
    sum = 0
    for j in range(n):
        sum += camulative[i][j]
        camulative[i][j] = sum

for _ in range(m):
    x1, y1, x2, y2 = map(lambda x: int(x) - 1, sys.stdin.readline().rstrip().split())
    x_flag = (x1 == 0)
    y_flag = (y1 == 0)
    if (x_flag and y_flag):
        print(camulative[x2][y2])
    elif (x_flag):
        print(camulative[x2][y2] - camulative[x2][y1 - 1])
    elif (y_flag):
        print(camulative[x2][y2] - camulative[x1 - 1][y2])
    else:
        print(camulative[x2][y2] - camulative[x1 - 1][y2] - camulative[x2][y1 - 1] + camulative[x1 - 1][y1 - 1])
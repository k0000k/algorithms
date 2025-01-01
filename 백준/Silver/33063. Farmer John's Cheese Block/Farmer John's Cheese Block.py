import sys

n, q = map(int, sys.stdin.readline().rstrip().split())

cheese_x = [[0 for i in range(n)] for j in range(n)]
cheese_y = [[0 for i in range(n)] for j in range(n)]
cheese_z = [[0 for i in range(n)] for j in range(n)]

answer = 0
for _ in range(q):
    x, y, z = map(int, sys.stdin.readline().rstrip().split())
    cheese_x[y][z] += 1
    cheese_y[x][z] += 1
    cheese_z[x][y] += 1

    if (cheese_x[y][z] == n):
        answer += 1
    if (cheese_y[x][z] == n):
        answer += 1
    if (cheese_z[x][y] == n):
        answer += 1
    
    print(answer)
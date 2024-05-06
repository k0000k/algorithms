import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
classrooms = []

for i in range(n):
    classrooms.append([0, 0])

for i in range(m):
    k, s, e = map(int, sys.stdin.readline().rstrip().split())
    before_s = classrooms[k - 1][0]
    before_e = classrooms[k - 1][1]

    if (before_s <= s < before_e):
        print("NO")
    else:
        print("YES")
        classrooms[k - 1][0] = s
        classrooms[k - 1][1] = e

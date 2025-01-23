import sys

n, q = map(int, sys.stdin.readline().rstrip().split())
closing_times = list(map(int, sys.stdin.readline().rstrip().split()))
plan_times = list(map(int, sys.stdin.readline().rstrip().split()))
permit_times = []

for i in range(n):
    permit_times.append(closing_times[i] - plan_times[i])

permit_times.sort(reverse=True)

for _ in range(q):
    v, wakeup = map(int, sys.stdin.readline().rstrip().split())
    answer = 0
    if (permit_times[v - 1] > wakeup):
        print("YES")
    else:
        print("NO")

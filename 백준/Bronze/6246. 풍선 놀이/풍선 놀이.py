import sys

slot, q = map(int, sys.stdin.readline().rstrip().split())

ballons = [0 for i in range(slot + 1)]
for i in range(q):
    l, i = map(int, sys.stdin.readline().rstrip().split())
    while (l <= slot):
        ballons[l] = 1
        l += i
print(ballons.count(0) - 1)
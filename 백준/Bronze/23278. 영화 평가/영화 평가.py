import sys

n, l, h = map(int, sys.stdin.readline().split())
scores = list(map(int, sys.stdin.readline().split()))

result = 0
scores.sort()
for i in range(l, n - h):
    result += scores[i]

print(result / (n - l - h))
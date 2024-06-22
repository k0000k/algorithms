import sys

n, l, h = map(int, sys.stdin.readline().split())
scores = list(map(int, sys.stdin.readline().split()))

scores.sort()
result = 0
for i in range(l, n - h):
    result += scores[i]

print(result / (n - l - h))
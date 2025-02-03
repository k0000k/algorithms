import sys
from collections import defaultdict

n = int(sys.stdin.readline().rstrip())
temp = list(map(int, sys.stdin.readline().rstrip().split()))
m = int(sys.stdin.readline().rstrip())
target = list(map(int, sys.stdin.readline().rstrip().split()))
count = defaultdict(int)

for num in temp:
    count[num] += 1

for num in target:
    print(count[num], end=" ")
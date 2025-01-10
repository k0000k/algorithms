import sys

n = int(sys.stdin.readline().rstrip())
grass = list(map(int, sys.stdin.readline().rstrip().split()))
answer = 0
total_effect = 0
effect = 0

for i in range(n):
    total_effect += effect
    diff = -(grass[i] + total_effect)
    effect += diff
    total_effect += diff
    answer += abs(diff)

print(answer)
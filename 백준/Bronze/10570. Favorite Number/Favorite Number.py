import sys

n = int(sys.stdin.readline().rstrip())

for i in range(n):
    v = int(sys.stdin.readline().rstrip())
    nums = [0 for i in range(1001)]
    for j in range(v):
        s = int(sys.stdin.readline().rstrip())
        nums[s] += 1
    print(nums.index(max(nums)))
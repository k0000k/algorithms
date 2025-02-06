import sys

zero = [1, 0]
one = [0, 1]
for i in range(39):
    zero.append(zero[i] + zero[i + 1])
    one.append(one[i] + one[i + 1])

n = int(sys.stdin.readline())
for _ in range(n):
    num = int(sys.stdin.readline())
    print(zero[num], one[num])

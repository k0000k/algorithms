import sys

n = int(sys.stdin.readline().rstrip())

turn = 1
current = 1
while True:
    if (n - current >= 0):
        n -= current
        current += 1
        turn += 1
    else:
        break

if (turn % 2 == 1):
    print(current - n)
else:
    print(0)
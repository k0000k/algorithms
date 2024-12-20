import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
essay = list(sys.stdin.readline().rstrip().split())

current = 0
for i in range(n):
    if (current + len(essay[i]) <= k):
        current += len(essay[i])
        if (i != n - 1 and current + len(essay[i + 1]) > k):
            print(essay[i], end="")
        elif (i == n - 1):
            print(essay[i], end="")
        else:
            print(essay[i], end=" ")
        
    else:
        print()
        current = len(essay[i])
        if (i != n - 1 and current + len(essay[i + 1]) > k):
            print(essay[i], end="")
        elif (i == n - 1):
            print(essay[i], end="")
        else:
            print(essay[i], end=" ")

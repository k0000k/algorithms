import sys

n,k=map(int,sys.stdin.readline().rstrip().split())
essay=list(sys.stdin.readline().rstrip().split())

count=0
for i in range(n):
    count+=len(essay[i])
    if (count > k):
        print()
        count=len(essay[i])

    # print(essay[i],end=' ') # 이 한줄이 아래와 같이 바뀜..
    if (i != n - 1 and count + len(essay[i + 1]) > k):
        print(essay[i],end='')
    elif (i == n - 1):
        print(essay[i],end='')
    else:
        print(essay[i],end=' ')

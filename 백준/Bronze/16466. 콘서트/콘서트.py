n=int(input())
a=list(map(int,input().split()))

a.sort()

min = 1
for i in a:
    if (i != min):
        break
    min += 1

print(min)
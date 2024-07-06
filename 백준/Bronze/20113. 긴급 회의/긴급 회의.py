import sys
n=int(sys.stdin.readline().rstrip())
list1=list(map(int,sys.stdin.readline().rstrip().split()))

reallist=[]
for i in range(n+1):
    reallist.append(0)

for i in list1:
    reallist[i]+=1

reallist[0] = -1
maximum=max(reallist)

cnt=reallist.count(maximum)

if cnt>1:
    print("skipped")
elif cnt==1:
    print(reallist.index(maximum))
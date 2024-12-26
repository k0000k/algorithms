import sys
n=int(sys.stdin.readline().rstrip())
cows=[100,100,100,100,100,100,100,100,100,100,100]
answer = 0

for i in range(n):
    number,location=map(int,sys.stdin.readline().rstrip().split())
    if (cows[number] == 100): # number번째 소의 위치가 처음 나옴
        cows[number] = location
    else:
        if (cows[number] != location):
            cows[number] = location
            answer += 1

print(answer)
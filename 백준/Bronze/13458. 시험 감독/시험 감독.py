import sys

n = int(sys.stdin.readline().rstrip())
rooms = list(map(int, sys.stdin.readline().rstrip().split()))
b, c = map(int, sys.stdin.readline().rstrip().split())

answer = 0
for room in rooms:
    room -= b
    answer += 1
    if (room > 0):
        answer += (room // c)
        if (room % c != 0):
            answer += 1

print(answer)
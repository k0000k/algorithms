import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
j = int(sys.stdin.readline().rstrip())
basket_start = 1
basket_end = m

answer = 0
for i in range(j):
    fall = int(sys.stdin.readline().rstrip())
    if (fall > basket_end):
        diff = fall - basket_end
        answer += diff
        basket_start += diff
        basket_end += diff
    elif (fall < basket_start):
        diff = basket_start - fall
        answer += diff
        basket_start -= diff
        basket_end -= diff

print(answer)

import sys

n, start = map(int, sys.stdin.readline().rstrip().split())
board = [[0, 0] for i in range(n + 1)]
total_target = 0
for i in range(n):
    q, v = map(int, sys.stdin.readline().rstrip().split())
    board[i + 1][0] = q
    board[i + 1][1] = v
    if (q == 1):
        total_target += 1

answer = 0
direction = 1
power = 1
loop = 0
while (1 <= start <= n and loop <= 1000000):
    current_q = board[start][0]
    current_v = board[start][1]
    if (current_q == 0): # jump pad
        direction *= -1
        power += current_v
    elif (current_q == 1 and power >= current_v): # target
        answer += 1
        board[start][0] = 2
    
    start += (direction * power)

    loop += 1

print(answer)

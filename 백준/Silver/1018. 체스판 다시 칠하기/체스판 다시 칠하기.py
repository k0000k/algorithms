import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
big_board = []
rows = ["WBWBWBWB", "BWBWBWBW"]

def find_diff(x, y, flag):
    diff = 0
    for i in range(x, x + 8):
        idx = flag % 2
        for j in range(8):
            if (big_board[i][y + j] != rows[idx][j]):
                diff += 1
        flag += 1
    return diff


for _ in range(n):
    temp = sys.stdin.readline().rstrip()
    big_board.append(temp)

answer = 64
for i in range(n - 8 + 1):
    for j in range(m - 8 + 1):
        for flag in range(2):
            val = find_diff(i, j, flag)
            if (val < answer):
                answer = val

print(answer)
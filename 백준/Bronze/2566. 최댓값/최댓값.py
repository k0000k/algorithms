import sys

board = []
for i in range(9):
    temp = list(map(int, sys.stdin.readline().rstrip().split()))
    board.append(temp)

max_value = -1
max_i = -1
max_j = -1
for i in range(9):
    for j in range(9):
        if (board[i][j] > max_value):
            max_value = board[i][j]
            max_i = i
            max_j = j

print(max_value)
print(max_i + 1, max_j + 1)
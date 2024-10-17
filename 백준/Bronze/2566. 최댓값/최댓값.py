import sys

board=[]

for i in range(9):
    temp=list(map(int,sys.stdin.readline().rstrip().split()))
    board.append(temp)

max_val=-1
max_i=0
max_j=0

for i in range(9):
    for j in range(9):
        if board[i][j]>max_val:
            max_val=board[i][j]
            max_i=i
            max_j=j

print(max_val)
print(max_i+1,max_j+1)
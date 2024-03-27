import sys

# 입력 받기
n, m = map(int, input().split())
board = [int(input()) for _ in range(n)]
dice = [int(input()) for _ in range(m)]

# 초기 위치와 결과 값 설정
pos = 1
result = 0

# 주사위 굴리기
for num in dice:
    pos += num
    result += 1
    if pos >= n:
        break
    instruction = board[pos - 1]
    pos += instruction
    if pos >= n:
        break

print(result)
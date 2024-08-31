n = int(input())
games = []

for i in range(n):
    a, b = map(int, input().split())
    games.append([a, b])

# 1번 케이스일때 player1이 이긴 횟수 세기
case1 = 0
for game in games:
    player1 = game[0]
    player2 = game[1]

    if (player1 == 1 and player2 == 2):
        case1 += 1
    elif (player1 == 2 and player2 == 3):
        case1 += 1
    elif (player1 == 3 and player2 == 1):
        case1 += 1

# 2번 케이스일때 player1이 이긴 횟수 세기
case2 = 0
for game in games:
    player1 = game[0]
    player2 = game[1]

    if (player1 == 2 and player2 == 1):
        case2 += 1
    elif (player1 == 3 and player2 == 2):
        case2 += 1
    elif (player1 == 1 and player2 == 3):
        case2 += 1

if (case1 > case2):
    print(case1)
else:
    print(case2)
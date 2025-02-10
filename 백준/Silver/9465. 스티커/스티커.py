import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    stickers = []
    n = int(sys.stdin.readline().rstrip())
    for _ in range(2):
        temp = list(map(int, sys.stdin.readline().rstrip().split()))
        stickers.append(temp)
    dp = [[0 for i in range(n)] for j in range(2)]
    dp[0][0] = stickers[0][0]
    dp[1][0] = stickers[1][0]
    for j in range(n):
        for i in range(2):
            target_idx = (i + 1) % 2
            if (j <= n - 2):
                dp[target_idx][j + 1] = max(dp[target_idx][j + 1], dp[i][j] + stickers[target_idx][j + 1])
            if (j <= n - 3):
                # print(i, j)
                dp[target_idx][j + 2] = max(dp[target_idx][j + 2], dp[i][j] + stickers[target_idx][j + 2])
    max0 = max(dp[0])
    max1 = max(dp[1])
    print(max(max0, max1))
    # print(dp)
    
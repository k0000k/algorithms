n = int(input())

num = 666
cnt = 0
while True:
    if (str(num).find("666") != -1):
        cnt += 1
    if (cnt == n):
        print(num)
        break
    num += 1
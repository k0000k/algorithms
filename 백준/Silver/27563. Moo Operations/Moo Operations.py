import sys

cnt = int(sys.stdin.readline().rstrip())

for i in range(cnt):
    string = sys.stdin.readline().rstrip()
    if ("MOO" in string):
        print(len(string) - 3)
    elif (("MOM" in string) or ("OOO" in string)):
        print(len(string) - 3 + 1)
    elif ("OOM" in string):
        print(len(string) - 3 + 2)
    else:
        print(-1)
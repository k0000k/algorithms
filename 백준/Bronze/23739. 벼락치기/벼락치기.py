import sys

n = int(sys.stdin.readline().rstrip())

answer = 0
minute = 30
for i in range(n):
    t = int(sys.stdin.readline().rstrip())
    study_time = 0

    # 챕터 공부시간 구하기
    if (minute >= t):
        study_time = t
        minute -= t
    else:
        study_time = minute
        minute = 0
    
    # 절반 넘게 공부했는지 확인
    if (study_time >= t / 2):
        answer += 1
    
    # 30분 지났는지 판단
    if (minute == 0):
        minute = 30

print(answer)
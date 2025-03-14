import sys

def solution():
    N, L = map(int, sys.stdin.readline().split())

    maps = []
    for i in range(N):
        maps.append(list(map(int, sys.stdin.readline().split())))

    answer = 0
    for i in range(N):
        prev = maps[i][0]
        cnt = 1
        is_load = True
        j = 1
        while j < N:
            if maps[i][j] == prev:
                cnt += 1
            elif maps[i][j] - 1 == prev:
                if cnt < L:
                    is_load = False
                    break
                else:
                    cnt = 1
                    prev = maps[i][j]
            elif maps[i][j] + 1 == prev:
                chk_cnt = 1
                for k in range(j + 1, min(j + L, N)):
                    if maps[i][k] != maps[i][j]:
                        break
                    else:
                        chk_cnt += 1
                if chk_cnt < L:
                    is_load = False
                    break
                else:
                    cnt = 0
                    prev = maps[i][j + L - 1]
                    j = j + L - 1
            else:
                is_load = False
            j += 1
        if is_load:
            answer += 1

    for i in range(N):
        prev = maps[0][i]
        cnt = 1
        is_load = True
        j = 1
        while j < N:
            if maps[j][i] == prev:
                cnt += 1
            elif maps[j][i] - 1 == prev:
                if cnt < L:
                    is_load = False
                    break
                else:
                    cnt = 1
                    prev = maps[j][i]
            elif maps[j][i] + 1 == prev:
                chk_cnt = 1
                for k in range(j + 1, min(j + L, N)):
                    if maps[k][i] != maps[j][i]:
                        break
                    else:
                        chk_cnt += 1
                if chk_cnt < L:
                    is_load = False
                    break
                else:
                    cnt = 0
                    prev = maps[j + L - 1][i]
                    j = j + L - 1
            else:
                is_load = False
            j += 1
        if is_load:
            answer += 1
    return answer
print(solution())
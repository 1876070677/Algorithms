from collections import deque

def cntDungeons():
    global comb, K, D
    k = K
    cnt = 0
    for i in comb:
        if D[i][0] <= k:
            k -= D[i][1]
            cnt += 1
        else:
            break
    return cnt
    

def dfs(depth):
    global N, comb, answer
    if depth == N:
        answer = max(answer, cntDungeons())
    else:
        for i in range(N):
            if i not in comb:
                comb.append(i)
                dfs(depth + 1)
                comb.pop()
    
def solution(k, dungeons):
    global answer, N, K, D
    D = dungeons
    N = len(dungeons)
    K = k
    dfs(0)
    return answer

N = -1
K = -1
D = []
answer = 0
comb = deque()
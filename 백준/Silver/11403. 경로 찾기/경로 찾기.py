import sys
import copy

N = int(sys.stdin.readline())
adj = []
for i in range(N):
    temp = list(map(int, sys.stdin.readline().strip().split(" ")))
    adj.append(temp)

dp = copy.deepcopy(adj)

for i in range(N):
    # i는 현재 탐색 중인 점
    for j in range(N):
        # j는 i로 간선이 있는 점
        if adj[j][i] == 1 or dp[j][i] == 1:
            for k in range(N):
                # k는 i와 연결된 점
                if adj[i][k] == 1 or dp[i][k] == 1:
                    dp[j][k] = 1

for i in range(N):
    print(" ".join(map(str, dp[i])))
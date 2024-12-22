import sys

# 한 도시에서 다른 도시로 가는 여러 버스가 존재할 수 있음

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

adj = [[-1 for _ in range(N)] for _ in range(N)]
for i in range(M):
    start, end, cost = map(int, sys.stdin.readline().strip().split(" "))
    if adj[start-1][end-1] > -1:
        adj[start-1][end-1] = min(adj[start-1][end-1], cost)
    else:
        adj[start-1][end-1] = cost

start, end = map(int, sys.stdin.readline().strip().split(" "))

costMatrix = [100000000 for _ in range(N)]
visited = [False for _ in range(N)]
costMatrix[start-1] = 0
while True:
    next = N
    minCost = 100000000
    for i in range(N):
        if visited[i] == False and minCost > costMatrix[i]:
            minCost = costMatrix[i]
            next = i
    if next == N:
        break
    visited[next] = True
    for i in range(N):
        if adj[next][i] > -1:
            costMatrix[i] = min(costMatrix[i], costMatrix[next] + adj[next][i])

print(costMatrix[end-1])



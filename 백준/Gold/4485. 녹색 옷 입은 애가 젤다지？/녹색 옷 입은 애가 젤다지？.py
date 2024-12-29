import sys
import heapq

def isInTheMap(x, y, n):
    if x > -1 and y > -1 and x < n and y < n:
        return True
    return False
cnt = 0
while True:
    N = int(sys.stdin.readline())
    if N == 0:
        break
    cnt += 1
    maps = []
    for i in range(N):
        row = list(map(int, sys.stdin.readline().strip().split()))
        maps.append(row)

    q = []
    heapq.heappush(q, [maps[0][0], 0, 0])
    distance = [[125*9 for _ in range(N)] for _ in range(N)]
    visited = [[False for _ in range(N)] for _ in range(N)]


    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    while q:
        dist, x, y = heapq.heappop(q)

        if visited[x][y]:
            continue

        visited[x][y] = True
        distance[x][y] = min(distance[x][y], dist)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if isInTheMap(nx, ny, N):
               heapq.heappush(q, [distance[x][y] + maps[nx][ny], nx, ny])

    print(f"Problem {cnt}: {distance[N-1][N-1]}")

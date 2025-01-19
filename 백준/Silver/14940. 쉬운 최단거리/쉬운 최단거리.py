import sys
from collections import deque
import heapq

def isInTheMap(x, y, limX, limY):
    if x > -1 and y > -1 and x < limX and y < limY:
        return True
    return False

n, m = map(int, sys.stdin.readline().strip().split())

maps = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n):
    maps.append(list(map(int, sys.stdin.readline().strip().split())))

dest = []
for i in range(n):
    for j in range(m):
        if maps[i][j] == 2:
            dest = [i, j]

q = deque()
q.append([dest[0], dest[1], 0])
visited = [[False for _ in range(m)] for _ in range(n)]
newMaps = [[0 for _ in range(m)] for _ in range(n)]
while q:
    x, y, cnt = q.popleft()
    if visited[x][y]:
        continue
    if maps[x][y] == 0:
        newMaps[x][y] = 0
        visited[x][y] = True
        continue
    visited[x][y] = True
    newMaps[x][y] = cnt
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if isInTheMap(nx, ny, n, m) and maps[nx][ny] != 0 and not visited[nx][ny]:
            q.append([nx, ny, cnt + 1])

for i in range(n):
    for j in range(m):
        if maps[i][j] == 1 and newMaps[i][j] == 0:
            newMaps[i][j] = -1

# q = []
# heapq.heappush(q, [0, dest[0], dest[1]])
# visited = [[False for _ in range(m)] for _ in range(n)]
# newMaps = [[0 for _ in range(m)] for _ in range(n)]
# while q:
#     cnt, x, y = heapq.heappop(q)
#     if visited[x][y]:
#         continue
#     if maps[x][y] == 0:
#         newMaps[x][y] = 0
#         visited[x][y] = True
#         continue
#     visited[x][y] = True
#     newMaps[x][y] = cnt
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if isInTheMap(nx, ny, n, m) and not visited[nx][ny]:
#             heapq.heappush(q, [cnt+1, nx, ny])

for i in newMaps:
    strList = map(str, i)
    print(" ".join(strList))
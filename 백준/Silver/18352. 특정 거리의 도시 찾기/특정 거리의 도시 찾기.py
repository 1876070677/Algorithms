import sys
from collections import defaultdict
import heapq

N, M, K, X = map(int, sys.stdin.readline().strip().split())

graph = defaultdict(list)

for i in range(M):
    x, y = map(int, sys.stdin.readline().strip().split())
    graph[x].append(y)

visited = [False for _ in range(300001)]
distance = [300001 for _ in range(300001)]

q = []
heapq.heappush(q, [0, X])

while q:
    dist, cur = heapq.heappop(q)

    if visited[cur]:
        continue
    visited[cur] = True
    distance[cur] = min(distance[cur], dist)
    for i in graph[cur]:
        heapq.heappush(q, [dist+1, i])

answer = []
for idx, i in enumerate(distance):
    if i == K:
        answer.append(idx)

if len(answer) == 0:
    print(-1)
else:
    for i in answer:
        print(i)
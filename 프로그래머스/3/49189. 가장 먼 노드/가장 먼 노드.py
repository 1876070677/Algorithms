import heapq
from collections import deque, defaultdict
def solution(n, edge):
    answer = 0
    
    graph = defaultdict(list)
    for (x, y) in edge:
        graph[x].append(y)
        graph[y].append(x)
        
    q = []
    distance = [20001 for _ in range(n + 1)]
    heapq.heappush(q, [0, 1])
    
    while q:
        dist, node = heapq.heappop(q)
        if distance[node] != 20001:
            continue
        distance[node] = dist
        for i in graph[node]:
            heapq.heappush(q, [dist+1, i])
    maxDist = max(distance[1:])
    answer = distance.count(maxDist)
    return answer
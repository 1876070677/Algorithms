import sys
import heapq

N, K = map(int, sys.stdin.readline().strip().split())
answer = 0
if N >= K:
    answer = N - K
else:
    q = []
    visited = [False for _ in range(100001)]
    heapq.heappush(q, [0, N])
    while q:
        cnt, cur = heapq.heappop(q)
        if visited[cur]:
            continue
        if cur == K:
            answer = cnt
        visited[cur] = True

        if cur < K and cur * 2 < 100001:
            heapq.heappush(q, [cnt, cur*2])
        if cur + 1 < 100001:
            heapq.heappush(q, [cnt+1, cur+1])
        if cur -1 > -1:
            heapq.heappush(q, [cnt+1, cur-1])
print(answer)
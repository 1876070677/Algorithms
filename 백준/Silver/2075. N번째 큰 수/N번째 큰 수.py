import sys
import heapq

N = int(sys.stdin.readline())
heap = []

for i in range(N):
    temp = list(map(int, sys.stdin.readline().strip().split(" ")))
    for j in range(len(temp)):
        if len(heap) < N:
            heapq.heappush(heap, temp[j])
        else:
            if heap[0] < temp[j]:
                heapq.heappop(heap)
                heapq.heappush(heap, temp[j])

print(heap[0])
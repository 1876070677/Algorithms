from collections import deque
def solution(n, wires):
    answer = 101
    
    tree = [[0 for _ in range(n)] for _ in range(n)]
    
    for (x, y) in wires:
        tree[x-1][y-1] = 1
        tree[y-1][x-1] = 1
        
    for (x, y) in wires:
        tree[x-1][y-1] = 0
        tree[y-1][x-1] = 0
        visited = [False for _ in range(n)]
        
        sub = []
        
        for i in range(n):
            if not visited[i]:
                count = 0
                q = deque()
                q.append(i)
                while q:
                    node = q.popleft()
                    
                    if visited[node]:
                        continue
                    visited[node] = True
                    count += 1
                    
                    for idx, j in enumerate(tree[node]):
                        if j > 0:
                            q.append(idx)
                sub.append(count)
        answer = min(answer, abs(sub[0] - sub[1]))
        tree[x-1][y-1] = 1
        tree[y-1][x-1] = 1
                    
    return answer
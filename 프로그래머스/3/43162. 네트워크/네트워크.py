from collections import defaultdict, deque
def solution(n, computers):
    answer = 0
    
    graph = defaultdict(list)
    for idx, row in enumerate(computers):
        for j in range(len(row)):
            if idx != j and row[j] == 1:
                graph[idx].append(j)
                
    visited = [False for _ in range(len(computers))]
    
    for i in range(len(visited)):
        if not visited[i]:
            answer += 1
            q = deque()
            q.append(i)
            while q:
                x = q.popleft()
                if visited[x]:
                    continue
                visited[x] = True
                
                for next in graph[x]:
                    q.append(next)
            
    return answer
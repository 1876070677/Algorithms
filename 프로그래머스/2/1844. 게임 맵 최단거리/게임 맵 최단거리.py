from collections import deque
def isInTheMap(x, y, N, M):
    if x > -1 and x < N and y > -1 and y < M:
        return True
    return False

def solution(maps):
    answer = -1
    
    q = deque()
    
    N = len(maps)
    M = len(maps[0])
    
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    q.append([0, 0, 1])
    
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]
    while q:
        data = q.popleft()
        cx = data[0]
        cy = data[1]
        cnt = data[2]
        
        if visited[cx][cy]:
            continue
        if cx == N - 1 and cy == M - 1:
            answer = cnt
            break
        visited[cx][cy] = True
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if isInTheMap(nx, ny, N, M) and maps[nx][ny] != 0:
                q.append([nx, ny, cnt + 1])
    return answer
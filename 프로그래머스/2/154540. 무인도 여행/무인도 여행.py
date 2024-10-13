from collections import deque

def check(x, y, maxX, maxY):
    if x < 0 or y < 0 or x >= maxX or y >= maxY:
        return False
    return True

def solution(maps):
    answer = []
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    for idx, row in enumerate(maps):
        maps[idx] = list(row)

    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if not visited[i][j] and maps[i][j] != 'X':
                ## BFS 시작
                queue = deque()
                queue.append([i, j])
                totalFood = 0
                while queue:
                    data = queue.popleft()
                    cx = data[0]
                    cy = data[1]
                    if visited[cx][cy]:
                        continue
                    visited[cx][cy] = True
                    totalFood += int(maps[cx][cy])

                    for k in range(4):
                        nx = cx + dx[k]
                        ny = cy + dy[k]
                        if check(nx, ny, len(maps), len(maps[0])) and maps[nx][ny] != 'X':
                            queue.append([nx, ny])
                answer.append(totalFood)
    answer.sort()
    if len(answer) == 0:
        answer.append(-1)
    return answer
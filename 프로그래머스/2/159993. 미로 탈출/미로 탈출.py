from collections import deque
def check(x, y, mX, mY):
    if x < 0 or y < 0 or x >= mX or y >= mY:
        return False
    return True
def solution(maps):
    # S -> L 까지 BFS
    # L -> E 까지 BFS
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    answer = 0
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    queue = deque()

    startPoint = []
    endPoint = []
    button = []
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == "S":
                startPoint = [i, j]
            elif maps[i][j] == "E":
                endPoint = [i, j]
            elif maps[i][j] == "L":
                button = [i, j]
    cnt = 0
    chk = False
    queue.append([startPoint, cnt])
    while queue:
        data = queue.popleft()
        cx = data[0][0]
        cy = data[0][1]
        cnt = data[1]
        if visited[cx][cy]:
            continue
        elif maps[cx][cy] == "L":
            answer += cnt
            chk = True
            break
        visited[cx][cy] = True
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if check(nx, ny, len(maps), len(maps[0])) and maps[nx][ny] != "X":
                queue.append([[nx, ny], cnt+1])

    if not chk:
        return -1

    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    queue = deque()
    cnt = 0
    chk = False
    queue.append([button, cnt])
    while queue:
        data = queue.popleft()
        cx = data[0][0]
        cy = data[0][1]
        cnt = data[1]
        if visited[cx][cy]:
            continue
        elif maps[cx][cy] == "E":
            answer += cnt
            chk = True
            break
        visited[cx][cy] = True
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if check(nx, ny, len(maps), len(maps[0])) and maps[nx][ny] != "X":
                queue.append([[nx, ny], cnt + 1])

    if not chk:
        return -1
    return answer
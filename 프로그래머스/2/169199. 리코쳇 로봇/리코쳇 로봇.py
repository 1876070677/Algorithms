from collections import deque

"""
    .: 빈공간
    D: 장애물
    R: 시작위치
    G: 목표지점
"""

def check(x, y, sizeX, sizeY):
    if x >= sizeX or y >= sizeY or x < 0 or y < 0:
        return False
    return True

def bfs(m):
    visited = [[False for _ in range(len(m[0]))] for _ in range(len(m))]

    queue = deque()

    # # 이동 좌표 설정
    # # 오, 아래, 왼, 위
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    startPoint = []
    # Start point 찾기
    for i in range(len(m)):
        for j in range(len(m[0])):
            if m[i][j] == "R":
                startPoint = [i, j]
                break
        if len(startPoint) > 0:
            break

    # queue는 좌표와 해당 좌표까지 도달한 횟수
    queue.append([startPoint, 0])
    answer = 10001
    chk = False
    while queue:
        data = queue.popleft()
        cx = data[0][0]
        cy = data[0][1]
        cnt = data[1]
        if visited[cx][cy]:
            continue
        visited[cx][cy] = True
        for i in range(4):
            nx = cx
            ny = cy
            while True:
                nx += dx[i]
                ny += dy[i]
                if not check(nx, ny, len(m), len(m[0])):
                    nx -= dx[i]
                    ny -= dy[i]
                    break
                elif m[nx][ny] == "D":
                    nx -= dx[i]
                    ny -= dy[i]
                    break
            if nx == cx and ny == cy:
                continue
            elif m[nx][ny] == "G":
                answer = min(answer, cnt+1)
                chk = True
                break

            queue.append([[nx, ny], cnt + 1])
        if chk:
            break
    return answer
def solution(board):
    answer = 0
    map = list()
    for row in board:
        map.append(list(row))
    answer = bfs(map)
    if answer == 10001:
        answer = -1
    return answer
import sys
import math

def check(x, y):
    if x >= 0 and y >= 0 and x < N and y < N:
        return True
    return False

N = int(sys.stdin.readline())

def solution():
    maps = []
    for i in range(N):
        maps.append(list(map(int, sys.stdin.readline().split())))

    currX = N // 2
    currY = N // 2

    directions = ["left", "down", "right", "up"]
    points = [[0, -1], [1, 0], [0, 1], [-1, 0]]
    filter = {
        "left": [
            [0, 0, 2, 0, 0],
            [0, 10, 7, 1, 0],
            [5, 0, 0, 0, 0],
            [0, 10, 7, 1, 0],
            [0, 0, 2, 0, 0]
        ],
        "right": [
            [0, 0, 2, 0, 0],
            [0, 1, 7, 10, 0],
            [0, 0, 0, 0, 5],
            [0, 1, 7, 10, 0],
            [0, 0, 2, 0, 0]
        ],
        "down": [
            [0, 0, 0, 0, 0],
            [0, 1, 0, 1, 0],
            [2, 7, 0, 7, 2],
            [0, 10, 0, 10, 0],
            [0, 0, 5, 0, 0]
        ],
        "up": [
            [0, 0, 5, 0, 0],
            [0, 10, 0, 10, 0],
            [2, 7, 0, 7, 2],
            [0, 1, 0, 1, 0],
            [0, 0, 0, 0, 0]
        ]
    }

    move_cnt = 1
    dir = 0
    answer = 0
    while True:
        if move_cnt < N-1:
            for i in range(2):
                for l in range(move_cnt):
                    baseX = currX + points[dir][0]
                    baseY = currY + points[dir][1]
                    d = directions[dir]

                    if maps[baseX][baseY] == 0:
                        currX = baseX
                        currY = baseY
                        continue

                    temp = maps[baseX][baseY]
                    for j in range(5):
                        for k in range(5):
                            nx = baseX + j - 2
                            ny = baseY + k - 2
                            move = int(maps[baseX][baseY] * filter[d][j][k] / 100)
                            temp -= move
                            if not check(nx, ny):
                                answer += move
                            else:
                                maps[nx][ny] += move
                    if check(baseX + points[dir][0], baseY + points[dir][1]):
                        maps[baseX + points[dir][0]][baseY + points[dir][1]] += temp
                    else:
                        answer += temp
                    maps[baseX][baseY] = 0
                    currX = baseX
                    currY = baseY
                dir = (dir + 1) % 4
            move_cnt += 1
        else:
            for i in range(3):
                for l in range(move_cnt):
                    baseX = currX + points[dir][0]
                    baseY = currY + points[dir][1]
                    d = directions[dir]

                    if maps[baseX][baseY] == 0:
                        currX = baseX
                        currY = baseY
                        continue

                    temp = maps[baseX][baseY]
                    for j in range(5):
                        for k in range(5):
                            nx = baseX + j - 2
                            ny = baseY + k - 2
                            move = int(maps[baseX][baseY] * filter[d][j][k] / 100)
                            temp -= move
                            if not check(nx, ny):
                                answer += move
                            else:
                                maps[nx][ny] += move
                    if check(baseX + points[dir][0], baseY + points[dir][1]):
                        maps[baseX + points[dir][0]][baseY + points[dir][1]] += temp
                    else:
                        answer += temp
                    maps[baseX][baseY] = 0
                    currX = baseX
                    currY = baseY
                dir = (dir + 1) % 4
            break
    return answer
print(solution())
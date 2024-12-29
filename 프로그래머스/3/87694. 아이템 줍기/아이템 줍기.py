from collections import deque, defaultdict

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    lines = defaultdict(list)
    
    for (x1, y1, x2, y2) in rectangle:
        for i in range(x1, x2):
            lines[(i, y1)].append((i+1, y1))
            lines[(i+1, y1)].append((i, y1))
            
            lines[(i, y2)].append((i+1, y2))
            lines[(i+1, y2)].append((i, y2))
        for i in range(y1, y2):
            lines[(x1, i)].append((x1, i+1))
            lines[(x1, i+1)].append((x1, i))
            
            lines[(x2, i)].append((x2, i+1))
            lines[(x2, i+1)].append((x2, i))
    
    pointsInRectangle = []
    
    # 내부 점들 모두 제거
    for (x, y) in lines:
        for (x1, y1, x2, y2) in rectangle:
            if x > x1 and x < x2 and y > y1 and y < y2:
                pointsInRectangle.append((x, y))
    for (x, y) in pointsInRectangle:
        lines.pop((x, y), None)
        
    # 사각형을 가로지르는 선분들 제거, 가로나 세로의 길이가 1인 사각형들에서만 발생함
    for (x1, y1, x2, y2) in rectangle:
        if x2 - x1 == 1:
            for i in range(y1+1, y2):
                if (x2, i) in lines[(x1, i)]:
                    lines[(x1, i)].remove((x2, i))
                if (x1, i) in lines[(x2, i)]:
                    lines[(x2, i)].remove((x1, i))
        if y2 - y1 == 1:
            for i in range(x1+1, x2):
                if (i, y2) in lines[(i, y1)]:
                    lines[(i, y1)].remove((i, y2))
                if (i, y1) in lines[(i, y2)]:
                    lines[(i, y2)].remove((i, y1))
            
        
    print(len(lines))
        
    q = deque()
    q.append([characterX, characterY, 0])
    
    while q:
        data = q.popleft()
        cx = data[0]
        cy = data[1]
        cnt = data[2]
        
        if (cx, cy) not in lines:
            continue
        print(cx, cy)
        if cx == itemX and cy == itemY:
            answer = cnt
            break
        
        nexts = lines[(cx, cy)]
        lines.pop((cx, cy), None)
        for (nx, ny) in nexts:
            q.append([nx, ny, cnt + 1])
    return answer
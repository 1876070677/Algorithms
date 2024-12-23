from collections import deque, defaultdict
def solution(begin, target, words):
    answer = 0
    N = len(target)
    
    q = deque()
    canChange = defaultdict(list)
    for word in words:
        for idx, j in enumerate(word):
            if j not in canChange[idx]:
                canChange[idx].append(j)
    
    q.append([begin, 0])
    
    canMake = {}
    while q:
        data = q.popleft()
        cw = data[0]
        cnt = data[1]

        if cw in canMake:
            continue
        if cw == target:
            answer = cnt
        canMake[cw] = 1
        
        for i in range(N):
            for j in canChange[i]:
                if cw[i] != j:
                    nw = list(cw)
                    nw[i] = j
                    nw = "".join(nw)
                    if nw in words:
                        q.append([nw, cnt + 1])
    return answer
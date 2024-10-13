from collections import defaultdict, deque
def solution(edges):
    answer = [0 for _ in range(4)]
    graph = defaultdict(list)
    ingoingCheck = [0 for _ in range(1000001)]

    for x, y in edges:
        graph[x].append(y)
        if y not in graph:
            graph[y] = list()
        ingoingCheck[y] += 1

    for key in graph:
        if len(graph[key]) >= 2 and ingoingCheck[key] == 0:
            newPoint = key
    answer[0] = newPoint
    for start in graph[newPoint]:
        if len(graph[start]) == 2:
            ## outgoing이 두개있어 -> 8자 그래프 중앙
            answer[3] += 1
        elif len(graph[start]) == 0:
            ## outgoing이 없어 -> 막대그래프
            answer[2] += 1
        else:
            queue = deque()
            edge = 1
            node = 1
            chk = False
            queue.append(graph[start][0])
            while queue:
                cNode = queue.popleft()
                if len(graph[cNode]) == 2:
                    ## 8자 그래프 중앙
                    chk = True
                    break
                if cNode == start:
                    continue
                node += 1
                for i in graph[cNode]:
                    edge += 1
                    queue.appendleft(i)
            if chk:
                answer[3] += 1
            elif edge == node:
                answer[1] += 1
            elif node > edge:
                answer[2] += 1


    return answer
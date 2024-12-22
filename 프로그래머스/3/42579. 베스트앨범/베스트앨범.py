import heapq
from collections import defaultdict

def solution(genres, plays):
    answer = []
    
    hash = defaultdict(list)
    playCnt = {}
    for idx, (gen, play) in enumerate(zip(genres, plays)):
        hash[gen].append([play, idx])
        if gen in playCnt:
            playCnt[gen] += play
        else:
            playCnt[gen] = play
    
    h = []
    for key in hash:
        heapq.heappush(h, [-playCnt[key], key])
    
    for i in range(len(hash)):
        gen = heapq.heappop(h)[1]
        if len(hash[gen]) == 1:
            answer.append(hash[gen][0][1])
        else:
            hash[gen].sort(key=lambda x: (-x[0], x[1]))
            answer.append(hash[gen][0][1])
            answer.append(hash[gen][1][1])
    return answer
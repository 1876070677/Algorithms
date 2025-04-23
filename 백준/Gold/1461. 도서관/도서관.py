import sys

def solution(N, M, book):
    positive = []
    negative = []
    for i in book:
        if i < 0:
            negative.append(i)
        else:
            positive.append(i)

    positive.sort(reverse=True)
    negative.sort()

    dist = []
    for i in range(0, len(positive), M):
        dist.append(positive[i])
    for i in range(0, len(negative), M):
        dist.append(abs(negative[i]))

    dist.sort(reverse=True)
    answer = dist[0]
    for i in range(1, len(dist)):
        answer += (dist[i] * 2)

    return answer

N, M = map(int, sys.stdin.readline().strip().split())
book = list(map(int, sys.stdin.readline().strip().split()))
print(solution(N, M, book))
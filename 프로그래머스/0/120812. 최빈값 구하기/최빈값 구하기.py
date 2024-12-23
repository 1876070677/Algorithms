def solution(array):
    answer = []
    for i in set(array):
        answer.append([i, array.count(i)])
    answer.sort(key = lambda x:x[1], reverse=True)
    if len(answer) == 1:
        return answer[0][0]
    elif answer[0][1] == answer[1][1]:
        return -1
    return answer[0][0]
def solution(people, limit):
    answer = 0
    array = [0 for _ in range(241)]
    for p in people:
        array[p] += 1

    idx = 1
    while idx <= 240:
        if array[idx] > 0:
            array[idx] -= 1
            diff = limit - idx
            if array[diff] > 0:
                array[diff] -= 1
            else:
                for i in range(diff, idx-1, -1):
                    if array[i] > 0:
                        array[i] -= 1
                        break
            answer += 1

        else:
            idx += 1
    return answer
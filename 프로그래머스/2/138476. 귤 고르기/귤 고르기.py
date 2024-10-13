def solution(k, tangerine):
    answer = 0
    sizes = [0 for _ in range(10000000)]

    for t in tangerine:
        sizes[t-1] += 1

    array = []
    for size, n in enumerate(sizes):
        if n > 0:
            array.append([size + 1, n])
    array.sort(key=lambda x: x[1], reverse=True)

    for element in array:
        if k != 0:
            if element[1] <= k:
                k -= element[1]
                answer += 1
            elif element[1] > k:
                answer += 1
                break
        else:
            break
    return answer
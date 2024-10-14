def solution(targets):
    answer = 0
    targets.sort(key=lambda x: (x[1]))

    pointer = 0
    for target in targets:
        if pointer > target[0]:
            continue
        pointer = target[1]
        answer += 1
    return answer
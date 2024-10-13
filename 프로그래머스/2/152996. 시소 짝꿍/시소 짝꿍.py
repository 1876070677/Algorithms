def solution(weights):
    answer = 0
    memories = [0 for _ in range(100001)]

    for weight in weights:
        memories[weight] += 1

    for w in range(len(weights)):
        temp = list()
        currentWeight = weights[w]
        memories[currentWeight] -= 1

        for i in range(2, 5):
            for j in range(2, 5):
                if currentWeight * i / j >= 100 and (currentWeight * i) % j == 0:
                    temp.append(int(currentWeight * i / j))
        temp = list(set(temp))
        for k in temp:
            if memories[k] > 0:
                answer += memories[k]
    return answer
import math
def solution(k, d):
    answer = 0
    count = [0 for _ in range(1000001)]
    count[0] = 1

    limitation = d**2
    a = 1

    make = []
    make.append(0)
    for i in range(1, d+1):
        if (a*k)**2 > limitation:
            count[i] = count[i-1]
        if i == a*k:
            make.append(a*k)
            count[i] = count[i-1] + 1
            a += 1
        else:
            count[i] = count[i-1]
    for number in make:
        result = limitation - number**2
        result = int(math.sqrt(result))
        answer += count[result]
    return answer
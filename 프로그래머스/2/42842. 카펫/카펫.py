import math
def solution(brown, yellow):
    answer = []
    
    limitX = (brown + 4) // 2
    
    for x in range(limitX, math.ceil(limitX / 2) - 1, -1):
        y = limitX - x
        if (x-2)*(y-2) == yellow:
            answer.append(x)
            answer.append(y)
            break
    return answer
from collections import deque
def combination(number, cnt, depth):
    global maxStone, queue
    if cnt >= depth:
        maxStone = min(maxStone, sum(queue))
    else:
        targetNumber = number % (10**(cnt+1))
        targetNumber = targetNumber // (10**cnt)

        if targetNumber < 5:
            minus = targetNumber * (10**cnt)
            queue.append(targetNumber)
            number -= minus
            combination(number, cnt + 1, len(str(number)))
            number += minus
            queue.pop()
        elif targetNumber > 5:
            plus = (10-targetNumber)*(10**cnt)
            queue.append((10-targetNumber))
            number += plus
            combination(number, cnt + 1, len(str(number)))
            number -= plus
            queue.pop()
        else:
            for i in [targetNumber, targetNumber*-1]:
                queue.append(abs(i))
                alpha = i * (10**cnt)
                number += alpha
                combination(number, cnt + 1, len(str(number)))
                number -= alpha
                queue.pop()
def solution(storey):
    global string
    answer = 0
    depth = len(str(storey))
    number = storey
    combination(number, 0, depth)
    answer = maxStone
    return answer

maxStone = 50
queue = deque()
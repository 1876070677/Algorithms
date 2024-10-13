from collections import deque
def timeToMinute(t):
    hh, mm = t.split(":")
    return int(hh) * 60 + int(mm)
def solution(plans):
    answer = []

    # 계산을 쉽게 하기 위해 시간을 숫자로 변경
    # 몇 분에 끝나는지가 중요한 게 아니므로 대소 관계만 계산할 수 있으면 됨
    for plan in plans:
        plan[1] = timeToMinute(plan[1])
    ## 정렬
    plans.sort(key=lambda x: x[1])
    stack = deque()
    for idx, plan in enumerate(plans):
        t = int(plan[2])
        if idx == len(plans) - 1:
            answer.append(plan[0])
            break
        # 정수에서의 차이를 시간 차이로 바꿔줌
        diff = plans[idx+1][1] - plan[1]
        ## 이제부터 연산
        if t == diff:
            answer.append(plan[0])
        elif t > diff:
            stack.appendleft([plan[0], t-diff])
        else:
            answer.append(plan[0])
            diff -= t
            while diff > 0 and stack:
                remain = stack.popleft()
                if remain[1] == diff:
                    answer.append(remain[0])
                    break
                elif remain[1] < diff:
                    diff -= remain[1]
                    answer.append(remain[0])
                else:
                    remain[1] -= diff
                    stack.appendleft([remain[0], remain[1]])
                    break

    for remain in stack:
        answer.append(remain[0])
    return answer
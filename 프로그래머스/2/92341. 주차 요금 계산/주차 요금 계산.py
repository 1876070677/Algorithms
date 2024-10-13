def timeToMinute(t):
    hh, mm = t.split(":")
    return int(hh) * 60 + int(mm)
def solution(fees, records):
    answer = []

    currentStatus = [-1 for _ in range(10000)]
    sumStatus = [0 for _ in range(10000)]


    for record in records:
        time, number, stat = record.split(" ")
        time = timeToMinute(time)
        number = int(number)
        if stat == "IN":
            currentStatus[number] = time
        elif stat == "OUT":
            sumStatus[number] += (time - currentStatus[number])
            currentStatus[number] = -1
    ## 출차 안된차 확인
    for i in range(10000):
        if currentStatus[i] > -1:
            sumStatus[i] += (timeToMinute("23:59") - currentStatus[i])

    # 요금 계산
    for idx, i in enumerate(sumStatus):
        if i > 0 and i <= fees[0]:
            answer.append(fees[1])
        elif i > 0 and i > fees[0]:
            cost = fees[1]
            t = i - fees[0]
            if t % fees[2] == 0:
                cost += (t // fees[2] * fees[3])
            else:
                cost += (((t // fees[2]) + 1) * fees[3])
            answer.append(cost)
    return answer
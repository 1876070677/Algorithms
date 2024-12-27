def solution(babbling):
    answer = 0
    canSpeak = ['aya', 'ye', 'woo', 'ma']
    for i in babbling:
        for j in canSpeak:
            i = i.replace(j, " ")
        if i == " "* len(i):
            answer += 1
    return answer
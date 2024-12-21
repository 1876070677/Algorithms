def solution(phone_book):
    answer = True
    hash = {}
    for number in phone_book:
        hash[number] = True
        
    for number in phone_book:
        for i in range(len(number) - 1):
            makeNum = "".join(number[:i+1])
            if makeNum in hash:
                answer = False
                break
        if not answer:
            break
    return answer
def solution(sequence, k):
    answer = []
    answerLen = 1000001
    subSum = sequence[0]
    L = 0
    R = 0

    while R < len(sequence):
        if subSum < k:
            if R == len(sequence) - 1:
                break
            R += 1
            subSum += sequence[R]
        elif subSum >= k:
            if subSum == k and R-L < answerLen:
                answer = [L, R]
                answerLen = R-L
            subSum -= sequence[L]
            L += 1
    return answer
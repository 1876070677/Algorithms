def solution(N, number):
    answer = 0
    dp = [[] for _ in range(8)]
    dp[0].append(N)
    for i in range(1, 8):
        dp[i].append(int(str(N)*(i+1)))
    for i in range(2, 9):
        for j in range(1, i):
            for num1 in dp[j - 1]:
                for num2 in dp[i-j-1]:
                    #print(num1, num2)
                    dp[i-1].append(num1 + num2)
                    if num1 - num2 >= 0:
                        dp[i-1].append(num1 - num2)
                    dp[i-1].append(num1 * num2)
                    if num2 != 0:
                        dp[i-1].append(num1 // num2)
                    
    for i in range(8):
        if number in dp[i]:
            answer = i + 1
            break
    if answer == 0:
        answer = -1
    return answer
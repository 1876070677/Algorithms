def dfs(result, depth):
    global answer, n, t
    if depth == len(n) and result == t:
        answer += 1
    elif depth < len(n):
        for i in range(1, 3):
            result += n[depth]*((-1)**i)
            dfs(result, depth+1)
            result -= n[depth]*((-1)**i)
            
q = []
def solution(numbers, target):
    global answer, n, t
    n = numbers
    t = target
    
    dfs(0, 0)
    return answer

answer = 0
n = []
t = 0
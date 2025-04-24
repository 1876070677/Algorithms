def solution(n, lost, reserve):
    answer = 0
    clothes = [1 for _ in range(n)]
    
    for i in reserve:
        clothes[i - 1] += 1
        
    for i in lost:
        clothes[i-1] -= 1
        
    for i in range(len(clothes)):
        if clothes[i] == 0:
            if i > 0 and clothes[i-1] > 1:
                clothes[i-1] -= 1
                clothes[i] += 1
            elif i < n - 1 and clothes[i + 1] > 1:
                clothes[i] += 1
                clothes[i + 1] -= 1
    
    for i in clothes:
        if i > 0:
            answer += 1
    return answer
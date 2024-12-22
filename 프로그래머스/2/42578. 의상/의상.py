from collections import defaultdict
def solution(clothes):
    answer = 1
    hash = defaultdict(list)
    
    for cloth, key in clothes:
        hash[key].append(cloth)
    
    for key, item in hash.items():
        answer *= (len(item) + 1)
    answer -= 1
    return answer
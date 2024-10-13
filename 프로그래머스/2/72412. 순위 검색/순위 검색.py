from collections import defaultdict, deque
def binarySearch(array, target, start, end):
    while start < end:
        mid = (start + end) // 2
        if array[mid] >= target:
            end = mid
        elif array[mid] < target:
            start = mid + 1
    return start
def solution(info, query):
    answer = []
    langs = ['-', 'cpp', 'java', 'python']
    techs = ['-', 'backend', 'frontend']
    poss = ['-', 'junior', 'senior']
    foods = ['-', 'chicken', 'pizza']
    tree = defaultdict(list)

    for i in info:
        lang, tech, pos, food, score = i.split(" ")
        score = int(score)
        comb = deque()
        for i in langs:
            if i in [lang, '-']:
                comb.append(i)
                for j in techs:
                    if j in [tech, '-']:
                        comb.append(j)
                        for k in poss:
                            if k in [pos, '-']:
                                comb.append(k)
                                for l in foods:
                                    if l in [food, '-']:
                                        comb.append(l)
                                        tree["".join(comb)].append(score)
                                        comb.pop()
                                comb.pop()
                        comb.pop()
                comb.pop()

    for key in tree:
        tree[key] = sorted(tree[key])

    for q in query:
        token = q.split(" ")
        score = int(token[-1])
        key = ""
        for idx, word in enumerate(token[:-1]):
            if idx % 2 == 0:
                key += word
        result = binarySearch(tree[key], score, 0, len(tree[key]) - 1)

        if result == len(tree[key]) - 1 and tree[key][result] < score:
            answer.append(0)
        else:
            answer.append(len(tree[key]) - result)
    return answer
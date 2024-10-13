def dfs(depth, use, maxCnt, minerals):
    global situations, answer, value
    if depth == maxCnt:
        score = 0
        for idx, tool in enumerate(situations):
            for m in minerals[idx*5:idx*5 + 5]:
                score += value[index[tool]][index[m]]
        answer = min(answer, score)
    else:
        for i in range(3):
            if use[i] > 0:
                use[i] -= 1
                situations.append(tools[i])
                dfs(depth + 1, use, maxCnt, minerals)
                situations.pop()
                use[i] += 1
tools = ["diamond", "iron", "stone"]
def solution(picks, minerals):
    global answer

    maxCnt = sum(picks)
    dfs(0, picks, maxCnt, minerals)

    return answer

answer = 1251
situations = []
value = [
    [1, 1, 1],
    [5, 1, 1],
    [25, 5, 1]
]

index = {
    "diamond": 0,
    "iron": 1,
    "stone": 2
}

from collections import deque
def dfs(cnt, depth):
    global combination, globalUsers, globalEmoticons, result
    if cnt == depth:
        membership = 0
        sell = 0
        for user in globalUsers:
            money = 0
            for idx, comb in enumerate(combination):
                if comb >= user[0]:
                    money += (globalEmoticons[idx] * (100-comb) // 100)
            if money >= user[1]:
                membership += 1
            else:
                sell += money

        if result[0] < membership:
            result[0] = membership
            result[1] = sell
        elif result[0] == membership:
            if result[1] < sell:
                result[1] = sell

    else:
        for i in [10, 20, 30, 40]:
            combination.append(i)
            dfs(cnt + 1, depth)
            combination.pop()
def solution(users, emoticons):
    global globalUsers, globalEmoticons, result
    answer = []
    globalUsers = users.copy()
    globalEmoticons = emoticons.copy()

    dfs(0, len(emoticons))
    answer = result
    return answer

combination = deque()
globalUsers = []
globalEmoticons = []
result = [0, 0]
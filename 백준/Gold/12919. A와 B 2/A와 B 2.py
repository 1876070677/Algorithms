import sys

def dfs(str):
    global answer, S
    if len(str) == len(S):
        if "".join(str) == "".join(S):
            answer = 1
    else:
        if str[0] == "B":
            dfs(str[1:][::-1])
        if str[len(str)-1] == "A":
            dfs(str[:-1])

S = list(sys.stdin.readline().strip())
T = list(sys.stdin.readline().strip())

answer = 0

dfs(T)

print(answer)
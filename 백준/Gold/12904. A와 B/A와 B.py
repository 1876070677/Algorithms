import sys

def solution(S, T):
    while len(S) != len(T):
        if T[-1] == 'A':
            T = T[:-1]
        else:
            T = T[:-1][::-1]

    if "".join(S) == "".join(T):
        return 1
    return 0

S = sys.stdin.readline().strip()
T = sys.stdin.readline().strip()

print(solution(S, T))
import sys
input = sys.stdin.readline

# 선분의 개수
n = int(input())

lines = []
for _ in range(n):
    a, b = map(int, input().split())
    lines.append([a, 1])
    lines.append([b, -1])

lines.sort()

maxcount = 0
count = 0

for _, value in lines:
    count += value
    maxcount = max(maxcount, count)

print(maxcount)
import sys

def solution():
    N, K = map(int, sys.stdin.readline().split())
    belt = list(map(int, sys.stdin.readline().split()))

    pointer = 0
    answer = 1

    robots = [0 for _ in range(2 * N)]

    zero_cnt = 0
    while True:
        # 컨베이어 벨트 회전
        pointer = (pointer - 1) % (2 * N)

        # N에 있는 로봇 내려놓기
        robots[(pointer + N - 1) % (2 * N)] = 0

        # 로봇들이 있으면 이동
        for i in range(N - 2, -1, -1):
            curr = (pointer + i) % (2 * N)
            next = (pointer + i + 1) % (2 * N)
            if robots[curr] == 1 and robots[next] == 0 and belt[next] > 0:
                robots[curr] = 0
                robots[next] = 1
                belt[next] -= 1
                if belt[next] == 0:
                    zero_cnt += 1

        robots[(pointer + N - 1) % (2 * N)] = 0

        # 첫 번째 칸에 로봇 올리기
        if robots[pointer] == 0 and belt[pointer] > 0:
            robots[pointer] = 1
            belt[pointer] -= 1
            if belt[pointer] == 0:
                zero_cnt += 1

        if zero_cnt >= K:
            break;

        answer += 1

    print(answer)

solution()

from functools import cmp_to_key

def compare(x, y):
    ## X, Y 순서로 되어 있을 때
    ## 만약 Y, X로 바뀌어야 한다면
    ## return -1을 날리면 된다.
    if x+y > y+x:
        return -1
    else:
        return 1

def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))

    numbers.sort(key=cmp_to_key(compare))

    answer = "".join(numbers)
    return str(int(answer))
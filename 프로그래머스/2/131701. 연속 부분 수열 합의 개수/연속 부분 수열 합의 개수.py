def solution(elements):
    answer = 0

    numbers = [[0 for _ in range(len(elements))] for _ in range(len(elements))]
    for i in range(len(elements)):
        numbers[i][i] = elements[i]

    for i in range(len(elements)):
        for j in range(1, len(elements)):
            column = (i + j) % len(elements)
            numbers[i][column] = numbers[i][column-1] + elements[column]

    make = []
    for i in numbers:
        for j in i:
            make.append(j)
    answer = len(set(make))
    return answer
def checkBingo(board, mark):
    chk = 0
    ## 가로 빙고
    for i in range(3):
        if board[i].count(mark) == 3:
            chk += 1
    ## 세로 빙고는 전치 행렬을 만들어서 구함
    transposeBoard = list(map(list, zip(*board)))
    for i in range(3):
        if transposeBoard[i].count(mark) == 3:
            chk += 1
    ## 우 하향 대각 빙고
    if board[0][0] == board[1][1] and board[1][1] == board[2][2] and board[1][1] == mark:
        chk += 1
    ## 우 상향 대각 빙고
    if board[2][0] == board[1][1] and board[1][1] == board[0][2] and board[1][1] == mark:
        chk += 1
    return chk
def solution(board):
    answer = 1
    newBoard = []
    for i in board:
        newBoard.append(list(i))

    numX = 0
    numO = 0
    for i in board:
        for j in i:
            if j == "O":
                numO += 1
            elif j == "X":
                numX += 1
    bingoO = checkBingo(newBoard, "O")
    bingoX = checkBingo(newBoard, "X")
    if numX > numO:
        return 0
    elif numO - numX > 1:
        return 0
    elif bingoO > 0 and numX == numO:
        return 0
    elif bingoO > 0 and bingoX > 0:
        return 0
    elif bingoO > 2:
        return 0
    elif bingoX > 0 and numO > numX:
        return 0

    return answer
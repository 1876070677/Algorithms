def timesToMinute(time):
    hh, mm = time.split(":")
    return int(hh) * 60 + int(mm)
def solution(book_time):
    answer = 0
    room = list()

    newBookArray = []
    for book in book_time:
        newBookArray.append([timesToMinute(book[0]), timesToMinute(book[1]) + 10])

    newBookArray.sort(key=lambda x:x[0])

    for newBook in newBookArray:
        if len(room) == 0:
            room.append(newBook)
        else:
            chk = False
            for r in range(len(room)):
                if room[r][1] <= newBook[0]:
                    room[r] = newBook
                    chk = True
                    break
            if not chk:
                room.append(newBook)
    answer = len(room)
    return answer
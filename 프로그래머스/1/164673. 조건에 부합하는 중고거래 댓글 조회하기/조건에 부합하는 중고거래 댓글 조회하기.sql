-- 코드를 입력하세요
SELECT TITLE, A.BOARD_ID, REPLY_ID, A.WRITER_ID, A.CONTENTS, DATE_FORMAT(A.CREATED_DATE, "%Y-%m-%d") CREATED_DATE from USED_GOODS_REPLY A left outer join USED_GOODS_BOARD B on A.BOARD_ID = B.BOARD_ID where B.CREATED_DATE between 20221001 and 20221031 order by A.CREATED_DATE, TITLE;
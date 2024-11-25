-- 코드를 입력하세요
SELECT A.NAME from (select ROW_NUMBER() over(order by DATETIME) ROWNUM, NAME from ANIMAL_INS) A limit 1;
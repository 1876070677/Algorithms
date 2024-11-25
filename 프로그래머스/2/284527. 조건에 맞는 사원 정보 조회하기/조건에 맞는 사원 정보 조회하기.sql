-- 코드를 작성해주세요
select C.SCORE, C.EMP_NO, C.EMP_NAME, C.POSITION, C.EMAIL from (select B.SCORE, A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL from HR_EMPLOYEES A left outer join (select EMP_NO, SUM(SCORE) as SCORE from HR_GRADE group by EMP_NO) B on A.EMP_NO = B.EMP_NO order by B.SCORE desc) C limit 1;

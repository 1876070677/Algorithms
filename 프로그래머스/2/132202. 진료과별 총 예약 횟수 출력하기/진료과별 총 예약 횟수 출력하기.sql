-- 코드를 입력하세요
SELECT MCDP_CD as "진료과코드", count(PT_NO) as "5월예약건수" from APPOINTMENT where APNT_YMD between 20220501 and 20220531 group by 진료과코드 order by 5월예약건수, 진료과코드;
-- 코드를 입력하세요
SELECT distinct C.FLAVOR from (select A.SHIPMENT_ID, A.FLAVOR, A.TOTAL_ORDER, B.INGREDIENT_TYPE from FIRST_HALF A, ICECREAM_INFO B where A.FLAVOR = B.FLAVOR) C where C.TOTAL_ORDER > 3000 and C.INGREDIENT_TYPE = 'fruit_based';
-- select A.SHIPMENT_ID, A.FLAVOR, A.TOTAL_ORDER, B.INGREDIENT_TYPE from FIRST_HALF A, ICECREAM_INFO B where A.FLAVOR = B.FLAVOR
-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID from ONLINE_SALE group by USER_ID, PRODUCT_ID having COUNT(*) > 1 order by USER_ID, PRODUCT_ID desc;
-- select USER_ID, PRODUCT_ID from ONLINE_SALE order by USER_ID;
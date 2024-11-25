-- 코드를 작성해주세요
select A.ITEM_ID, A.ITEM_NAME from ITEM_INFO A left outer join ITEM_TREE B on A.ITEM_ID = B.ITEM_ID where B.PARENT_ITEM_ID is null order by A.ITEM_ID;
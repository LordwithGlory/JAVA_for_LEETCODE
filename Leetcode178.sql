# leetcode 178
select a.Score,
(select count(distinct b.Score) from Score as b where b.Score>=a.Score) as rank
from Score as a
order by a.Score DESC;
-- 答案这个速度最快的
-- SELECT m.Score, sub.Rank from  Scores m, (
--     SELECT s.Score, @rownum := @rownum + 1 AS Rank
--     FROM (
--         SELECT Score from Scores GROUP BY Score order by Score desc
--     ) s,
--    (SELECT @rownum := 0) temp
-- ) sub
-- WHERE m.Score = sub.Score
-- ORDER BY m.Score DESC;
# leetcode 179 Num必须设置表名称
select distinct l1.Num
as ConsecutiveNums
from Logs l1,Logs l2,Logs l3
where l1.Id=l2.Id-1
and l2.Id=l3.Id-1
and l1.Num=l2.Num
and L2.Num=l3.Num;
-- # Write your MySQL query statement below
-- SELECT DISTINCT Num AS ConsecutiveNums
-- FROM (SELECT *, @cnt := equal_last * @cnt + 1 AS cnt
-- FROM (SELECT Num, @prev = (@prev := Num) AS equal_last
-- FROM Logs, (SELECT @prev := -1) init) tmp, (SELECT @cnt := 0) init1) tmp1
-- WHERE cnt > 2;
# leetcode 181
select e1.Name as Employee
from Employee e1,Employee e2
where e1.ManagerId=e2.Id
and  e1.Salary>e2.Salary;
# leetcode 182
select alise.Email
from (
select Email,count(Email) as num
from Person
GROUP by Email
)alise
where num>1;
-- select Email(出错)
-- from Person
-- where (select count(Email) from Person)>1;
# leetcode 183
select Name
from Customers
where Customers.Id not in (select CustomerId from Orders);
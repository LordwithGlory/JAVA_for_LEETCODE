-- leetcode175
select FirstName, LastName, City, State
from Address
right join Person
on Person.PersonId=Address.PersonId;
-- leetcode176
select distinct Salary as SecondHighestSalary
from Employee
order by Salary DESC
limit 1,1;
-- ifnull也可以考虑
-- SELECT MAX(SALARY) AS SECONDHIGHESTSALARY FROM EMPLOYEE WHERE SALARY<(SELECT MAX(SALARY) FROM EMPLOYEE)
-- limit 1 offset 1;
-- leetcode177
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- 看来select语句中不能进行加减操作。。。否则就不用N-1了
BEGIN
  set n=N-1;
  RETURN (
    select Salary as SecondHighestSalary
    from Employee
    order by Salary DESC
    limit n,1
  );
END
--leetcode 178
--不想写这个🐶了
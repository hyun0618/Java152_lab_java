/*
DDL(Data Definition Language): create, alter, truncate, drop
DML(Data Manipulation Language): insert, update, delete

    - delete(DML)
    : 테이블의 모든 행의 데이터를 삭제. 비어있는 행이 남는다.

    - truncate(DDL)
    : 테이블의 모든 행의 데이터를 삭제하고 행 자체도 삭제한다. 

    - drop(DDL)
    : 테이블 자체를 DBMS에서 삭제한다. 
*/

-- DDL
    -- create table ... as select ...
    -- 테이블의 모양(컬럼 이름, 데이터 타입)과 데이터를 복사
    -- emp 테이블을 ex_emp6으로 복사:
        create table ex_emp6 as select * from emp; 
        select * from ex_emp6;
    
    -- emp 테이블의 모양과 같은 테이블을 생성하면서 테이터는 복사하지 않을 수 있다. 
        create table ex_emp7 as select * from emp where empno=-1;
        select * from ex_emp7;
    
    -- truncate table: 테이블의 모든 행을 삭제하는 DDL
        truncate table ex_emp6;
    
    -- drop table: 테이블을 삭제하는 DDL
        drop table ex_emp7;


-- DML
--  (1) insert
    -- (1-1) insert int 테이블 (컬럼, ...) values (값, ...);
            --> insert는 테이블에 1개의 행을 삽입한다. 
    -- (1-2) insert into 테이블 (컬럼, ...) select ...;
            --> select 결과만큼 여러개의 행들을 삽입한다.         

    -- (1-1) emp 테이블에서 부서번호가 10번인 행들을 ex_emp6에 삽입:
        insert into ex_emp6 select * from emp where deptno = 10; 

select * from ex_emp6;
commit;

    -- (1-2) emp 테이블에서 수당이 null이 아닌 행들을 bonus 테이블에 삽입:
        insert into bonus select * from emp where comm is not null; --> 오류
        insert into bonus select ename, job, sal, comm from emp where comm is not null; --> 주요 컬럼만 부르기. 

select * from bonus;

--  (2) update
    -- update : 테이블 데이터 업데이트(수정)
    -- update 테이블 set 변수 = 값, ... where 조건식;
        select * from emp;
        
        update emp set sal = 6000 where empno = 1004; 
        --> where 조건식이 없으면 update 문장은 테이블의 모든 행의 값을 수정한다. 
    
commit; -- 현재까지 모든 변경 내용을 영구 저장. 

update emp set sal = 6000;
select * from emp;

rollback; -- 직전의 commit 상태로 되돌림. 
select * from emp;


-- 사번이 1004인 직원의 업무를 'manager', 입사날짜를 '2024/04/25'으로 변경.
update emp set job = 'MANAGER', hiredate = '2024/04/25' where empno = 1004; 
COMMIT;

-- 'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상:
SELECT * FROM EMP
WHERE DEPTNO = (
    SELECT DEPTNO FROM DEPT WHERE DNAME = 'ACCOUNTING'
);


UPDATE EMP
SET SAL = 1.1 * SAL
WHERE DEPTNO = (
    SELECT DEPTNO FROM DEPT WHERE DNAME = 'ACCOUNTING'
);

-- SALGRADE가 1인 직원들의 급여를 25% 인상: 
SELECT LOSAL, HISAL FROM SALGRADE WHERE GRADE = 1;

SELECT * FROM EMP 
WHERE SAL BETWEEN 
    (SELECT LOSAL FROM SALGRADE WHERE GRADE = 1) 
    AND
    (SELECT HISAL FROM SALGRADE WHERE GRADE = 1);
    
UPDATE EMP
SET SAL = 1.25 * SAL
WHERE SAL BETWEEN 
    (SELECT LOSAL FROM SALGRADE WHERE GRADE = 1) 
    AND
    (SELECT HISAL FROM SALGRADE WHERE GRADE = 1);
    
commit;


--  (3) delete: 테이블에서 행 삭제(DML)
-- delete from 테이블 where 조건식;
    --> where 조건식을 쓰지 않으면 테이블의 모든 행이 삭제 됨. 

-- emp 테이블에서 사번이 1004인 직원의 정보를 삭제: 
delete from emp where empno = 1004;
SELECT * FROM EMP;
commit;

delete from emp;
rollback;

-- 입사연도가 1987년인 직원 삭제. 
select * from emp where to_char(hiredate, 'yyyy') = 1987; 

delete from emp where to_char(hiredate, 'yyyy') = 1987; 

select *from emp order by hiredate desc;

commit;


-- 다중행 서브쿼리 (all, any, in)
select ename, sal, deptno
from emp
where sal < all (  
select sal from emp where deptno = 10 
);

-- 다중컬럼 서브쿼리





-- <기본 Query 문장>: 

-- (1)테이블에서 원하는 컬럼 검색:
select 컬럼이름, ... from 테이블이름;

-- (2)테이블에서 모든 컬럼 검색:
select * from 테이블이름; 

    -- emp: 직원테이블, dept: 부서 테이블
    -- (1-1)직원테이블에서 사번(empno)과 직원이름(ename)을 검색:
    select empno, ename 
    from emp; 
    
    select ename, empno 
    from emp; -- -> 출력 순서가 변경된다.
    
    -- (2-1)직원 테이블에서 모든 컬럼을 검색:
    select * 
    from emp;

-- (3)컬럼이름에 별명(alias) 짓기: 
    -- 컬럼이름 as "별명" -> 작은따옴표('') 사용 불가.
    -- 별명에 공백이 없는 경우에는 큰따옴표("") 생략이 가능하다. (-> 별명 만들 때에만 씀.)
    -- 주의) SQL에서 문자열은 작은따옴표로 표시: 'SCOTT'
    
    -- (3-1)부서테이블에서 부서번호, 부서이름 검색하고 별명 짓기:
    select deptno, dname 
    from dept;
    
    select deptno as "부서 번호", dname as "부서 이름" 
    from dept;
    
    -- (3-2)부서테이블에서 부서번호에만 별명 짓기.
    select deptno as "부서 번호", dname 
    from dept;

-- (4) 연결 연산자(||):
    -- 2개 이상의 컬럼(또는 문자열)을 합쳐서 하나의 컬럼으로 출력.
    
    -- (4-1)부서번호와 부서이름이 한 컬럼으로 출력.
    select deptno || dname 
    from dept;
    
    -- (4-2)부서번호-부서이름 형식의 문자열을 "부서"라는 컬럼으로 출력.
    select deptno || '-' || dname as "부서" 
    from dept; 
    
    -- (4-3)부서테이블을 검색해서 'A부서는 B에 있습니다.'형식으로 출력. 
    select dname || '부서는 ' || loc || '에 있습니다.' as "부서 정보" 
    from dept;
    
    -- (4-4)직원테이블을 검색해서 'A의 급여는 B' 형식으로 출력. 
    SELECT EMPNO || '의 급여는 ' || SAL AS "직원 급여" 
    FROM EMP;
    

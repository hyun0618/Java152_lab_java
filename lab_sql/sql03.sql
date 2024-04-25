/*
조건 검색 WHERE 

테이블에서 데이터 검색: 
    1) PROJECTION: 테이블에서 원하는 컬럼 선택.
    2) SELECTION: 테이블에서 조건을 만족하는 행 검색.

WHERE를 사용하는 SELECTION:
    문법: SELECT 컬럼, ... FROM 테이블 WHERE 조건식 ORDER BY 컬럼;

조건식에서 사용되는 연산자들: 
    1) 비교 연산자: =, !=, >, >=, <, <=, IS NULL, IS NOT NULL
    2) 논리 연산자: AND, OR, NOT 
*/

-- 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름 출력
-- 사번 오름차순 정렬. 
    SELECT DEPTNO, EMPNO, ENAME  
    FROM EMP
    WHERE DEPTNO = 10
    ORDER BY EMPNO;

-- 직원 테이블에서 수당이 NULL이 아닌 직원들의 
-- 사번, 부서번호, 이름, 급여, 수당을 출력. 사번 오름차순 정렬.
    SELECT EMPNO, DEPTNO, ENAME, SAL, COMM
    FROM EMP
    WHERE COMM IS NOT NULL
    ORDER BY EMPNO;
    --> SQL의 NULL 여부를 비교할 때에는 '=, !='이 아니라 'IS NULL, IS NOT NULL'을 사용.

-- 직원 테이블에서 급여가 2000 이상인 직원들의 이름, 업무, 급여를 출력.
    SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL >= 2000 
    ORDER BY SAL DESC;
    
-- 직원 테이블에서 급여가 2000 이상 3000 이하인 직원들의 이름, 업무, 급여를 출력. 
    SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL <= 3000 AND SAL >= 2000
    -->  WHERE SAL BETWEEN 2000 AND 3000
    ORDER BY SAL DESC;
    --> 논리 연산자로 & 또는 &&를 사용할 수 없다.
    

-- 직원 테이블에서 10번 또는 20번 부서에서 근무하는 직원의 
-- 부서번호, 이름, 급여 검색. 부서번호 오름차순.
    SELECT DEPTNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = 10 OR DEPTNO = 20
    --> WHERE DEPTNO = 10 OR 20 (X)
    --> WHERE DEPTNO IN (10, 20) 
    ORDER BY DEPTNO;

-- <EXERCISE>
-- 직원 테이블에서 업무가 CLERK인 직원들의
-- 업무, 이름, 급여를 출력. 정렬순서: 이름.
    SELECT JOB, ENAME, SAL 
    FROM EMP 
    WHERE JOB = 'CLERK'
    ORDER BY ENAME;
    --> SQL에서는 문자열을 비교할 때 '=, !=' 연산자를 사용.
    --> SQL에서 문자열을 작은따옴표('')를 사용. 대/소문자 구분. 

-- 직원테이블에서 업무가 CLERK 또는 MANAGER인 직원들의
-- 업무, 이름, 급여를 검색. 정렬 순서: 업무, 급여.
    SELECT JOB, ENAME, SAL 
    FROM EMP
    WHERE JOB = 'CLERK' OR JOB = 'MANAGER' 
    --> WHERE JOB IN ('CLERK', 'MANAGER')
    ORDER BY JOB, SAL;

-- 직원 테이블에서 20번 부서에서 근무하는 CLERK의 
-- 모든 정보를 검색.
    SELECT *
    FROM EMP
    WHERE DEPTNO = 20 AND JOB = 'CLERK';
    
-- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌 직원들의 
-- 사번, 이름, 업무, 급여를 검색. 정렬 순서: 사번.
    SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE JOB != 'CLERK' AND JOB != 'ANALYST' AND JOB != 'MANAGER'
    --> WHERE JOB NOT IN ('CLERK', 'ANALYST', 'MANAGER')
    ORDER BY EMPNO;

-- 숫자 타입 뿐만 아니라, 문자열과 날짜 타입도 대소 비교 가능.
-- (예) 'A' < 'B', 2024/04/21 < 2024/04/22 

-- 1987/01/01 이후에 입사한 직원들의 모든 정보를 출력. 
-- 정렬 순서: 입사일 오름차순. 
    SELECT *
    FROM EMP
    WHERE HIREDATE > '1987/01/01'
    ORDER BY HIREDATE;
    --> 암묵적(자동) 타입 변환:
        -- 오라클은 HIREDATE 컬럼(DATE 타입)과 문자열 '1987/01/01'의 크기를 비교할 때,
        -- 날짜 타입을 문자열로 변환한 후 문자열의 크기 비교를 수행한다.
        
    SELECT * FROM EMP
    WHERE HIREDATE > TO_DATE('1987/01/01')
    ORDER BY HIREDATE;
    --> 명시적 타입 변환: 
        -- TO_DATE('문자열'): '문자열'을 날짜(DATE) 타입으로 변환.
        
-- LIKE 검색: 특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 찾는 검색.
-- 이름이 'A'로 시작하는 직원들의 모든 정보: 
    SELECT * FROM EMP
    WHERE ENAME LIKE 'A%'; -- 'A%' => A 뒤에 몇글자가 있어도 상관 없음.
    
-- LIKE 검색에서 사용하는 WILDCARD:
    -- 1) %: 글자 수에 제한 없음. 
    -- 2) _(UNDERSCORE): 밑줄의 개수만큼 문자가 있음. 
    SELECT * FROM EMP
    WHERE JOB LIKE '_LERK';
    -- 'A' 포함
    SELECT * FROM EMP
    WHERE ENAME LIKE '%A%';
    
-- 30번 부서에서 근무하고, 업무 이름에 'SALES'가 포함되어있는 직원들의 
-- 사번, 부서 번호, 이름, 업무, 급여, 수당 출력. 
    SELECT EMPNO, DEPTNO, ENAME, JOB, SAL, COMM
    FROM EMP
    WHERE DEPTNO = 30 AND JOB LIKE '%SALES%'
    ORDER BY EMPNO;
    
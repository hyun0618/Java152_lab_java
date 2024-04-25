/*
오라클 함수(FUNCTION)
1. 단일 행 함수:
    - 행(ROW)이 하나씩 함수에 아규먼트로 전달되고, 
    - 행 마다 하나씩 결과가 리턴되는 함수. 
    - 예) TO_DATE, TO_CHAR, LOWER, UPPER, ...

2. 다중 행 함수:
    - 여러 개의 행이 함수의 아규먼트로 전달되고,
    - 하나의 결과가 리턴되는 함수. 
    - 예) 통계 관련 함수: COUNT, SUM, AVG, MAX, MIN, VARIANCE(분산), STDDEV(표준편차)
*/

-- 단일 행 함수의 예: (테이블 행 개수 = 리턴값 행 개수) 
    -- (1-1)모든 행의 문자열을 소문자로 바꾸기. (행 하나씩 리턴)
    SELECT ENAME, LOWER(ENAME), JOB, LOWER(JOB) FROM EMP;
    
    -- (1-2)TO_CHAR(...): 다른 타입의 값을 문자열로 변환. (예. 날짜 -> 문자열)
    SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY/MM/DD'), TO_CHAR(HIREDATE, 'MM/DD/YYYY')
    FROM EMP;
    
    -- (1-3)NVL(변수, 값): 변수가 NULL이면 값을 리턴하고, NULL이 아니면 원래 값을 리턴. 
    SELECT COMM, NVL(COMM, -1)
    FROM EMP;
    -- (1-4)NVL2(변수, 값1, 값2): 변수가 NULL이 아니면 값1을 리턴하고 NULL이면 값2를 리턴. 
    SELECT COMM, NVL(COMM,O), NVL2(COMM,COMM, 0), NVL2(COMM, 'T', 'F')
    FROM EMP;
    
-- 이름이 (대/소문자 구분없이) 'A'로 시작하는 직원들의 이름 출력.
-- ALLEN, Allen, allen
select ename from emp
where lower(ename) like 'a%';

-- 사번, 이름, 급여, 수당, 연봉을 검색. 
-- 연봉 = 급여 * 12 + 수당
SELECT EMPNO, ENAME, SAL, COMM, SAL * 12 + NVL(COMM, 0) AS "연봉"
FROM EMP;
    
-- 다중 행 함수의 예: 
    -- (2-1)COUNT(컬럼): NULL이 아닌 행의 개수를 리턴. 
    SELECT COUNT(EMPNO), COUNT(MGR), COUNT(COMM)
    FROM EMP;
    
    -- (2-2)테이블의 행의 개수
    SELECT COUNT(*) FROM EMP;
    
    -- 통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
    SELECT SUM(SAL), AVG(SAL), MAX(SAL), MIN(SAL), VARIANCE(SAL), STDDEV(SAL)
    FROM EMP;
    
    SELECT SUM(COMM), AVG(COMM) FROM EMP; 
    --> 모든 통계 함수들은 NULL을 제외하고 계산.
    
    -- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없다. 
    -- SELECT SAL, SUM(SAL) FROM EMP;
    -- SELECT NVL(COMM, 0), SUM(COMM) FROM EMP;


/*
그룹별 쿼리(QUERY):
- 예: 부서별 직원의 수, 부서별 급여의 평균, ...
- 문법: 
    SELECT 컬럼, 함수호출, ... 
    FROM 테이블 
    WHERE 조건식(1) => 그룹으로 묶기 전에 행을 선택할 조건. 
    GROUP BY 컬럼(그룹을 묶을 수 있는 변수) 
    HAVING 조건식(2) => 그룹으로 묶은 후에 행을 선택할 조건. 
    ORDER BY 컬럼(정렬 기준)
*/

-- 부서별 급여의 평균.
    SELECT DEPTNO AS "부서 번호", ROUND(AVG(SAL), 2) AS "부서별 급여 평균"
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY DEPTNO;

-- 부서별 급여의 평균과 표준편차.
    SELECT DEPTNO, ROUND(AVG(SAL), 2) AS "부서별 급여 평균",
                ROUND(STDDEV(SAL), 2) AS "부서별 급여 표준편차"
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY DEPTNO;
    
-- EXERCISE >> 모든 문제에서 소수점은 반올림해서 소수점 이하 2자리까지 표시.
-- Ex1. 업무별 업무, 직원수, 급여 최댓값, 최솟값, 평균을 업무 오름차순으로 출력.
SELECT JOB AS "업무", COUNT(*) AS "직원 수", --> COUNT(EMPNO)
        MAX(SAL) AS "급여 최댓값", MIN(SAL) AS "급여 최솟값", 
        ROUND(AVG(SAL), 2) AS "급여 평균"
FROM EMP
GROUP BY JOB
ORDER BY JOB;

-- Ex2. 부서별/업무별로 부서번호, 업무, 직원수, 급여 평균을 검색.
--     정렬 순서: (1) 부서번호 (2) 업무
SELECT DEPTNO AS "부서 번호", JOB AS "업무",
        COUNT(EMPNO) AS "직원 수", --> COUNT(*) 
        ROUND(AVG(SAL), 2) AS "급여 평균"  
FROM EMP 
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

-- Ex3. 입사연도별 사원수를 검색. (힌트) to_char(날짜, 포맷) 이용.
SELECT TO_CHAR(HIREDATE,'RRRR') AS "입사 연도", 
        COUNT(TO_CHAR(HIREDATE,'RRRR')) AS "입사 연도별 사원 수" --> COUNT(*)
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'RRRR')
ORDER BY "입사 연도"; 
--> SELECT에서 설정한 별명은 TO_CHAR(HIREDATE,'RRRR')를 ORDER BY에서 사용할 수 있음. 

-- Ex4. 부서별 급여 평균 검색. 급여 평균이 2000 이상인 부서만 검색.
SELECT DEPTNO AS "부서 번호", ROUND(AVG(SAL), 2) AS "급여 평균"
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO;

-- Ex5. mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색.
--     정렬순서: 부서번호 오름차순.
SELECT DEPTNO AS "부서 번호", ROUND(AVG(SAL), 2) AS "부서별 급여 평균"
FROM EMP
WHERE MGR IS NOT NULL
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- Ex6. PRESIDENT는 제외하고 업무별 사원 수를 검색.
--      업무별 사원 수가 3명 이상인 업무들만 검색. 정렬 순서: 업무 오름차순.
SELECT JOB AS "업무", COUNT(*) AS "사원 수"
FROM EMP
-- WHERE JOB != 'PRESIDENT'
GROUP BY JOB
HAVING JOB != 'PRESIDENT' AND COUNT(*) >= 3 --> 조건을 추가로 줄 때 'AND, OR'
ORDER BY JOB;

-- Ex7. 입사연도가 1980년을 제외한 부서별 사원 수 검색.
--      연도별, 부서별 사원수가 2명 이상인 경우만 출력.
SELECT TO_CHAR(HIREDATE, 'RRRR') AS "입사 연도", DEPTNO AS "부서 번호", COUNT(*) AS "직원 수"
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'RRRR'), DEPTNO
HAVING TO_CHAR(HIREDATE, 'RRRR') != '1980' AND COUNT(*) >= 2
ORDER BY "입사 연도", DEPTNO;

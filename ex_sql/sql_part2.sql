-- (16-1) UPPER(), LOWER(), INITCAP() 
SELECT UPPER(ENAME), LOWER(ENAME), INITCAP(ENAME) 
FROM EMP;
--> UPPER(): 대문자로 출력.
--> LOWER(): 소문자로 출력. 
--> INITCAP(): 첫 번째 철자만 대문자로 출력. 

-- (16-2)
SELECT ENAME, SAL 
FROM EMP 
WHERE LOWER(ENAME) = 'scott';

-- (17-1) SUBSTR(): 특정 철자 추출.
SELECT SUBSTR('SMITH', 1, 3) 
FROM DUAL;
--> 첫 번째 철자부터 3글자 출력. 

-- (18-1) LENGTH(): 문자열의 길이.
SELECT ENAME, LENGTH(ENAME) 
FROM EMP;

-- (18-2) 
SELECT LENGTH('가나다라마')
FROM DUAL;

-- (18-3) LENGTHB(): 바이트의 길이.
SELECT LENGTHB('가나다라마') 
FROM DUAL;

-- (19-1) INSTR(): 문자에서 특정 철자의 위치.
SELECT INSTR('SMITH', 'M')
FROM DUAL; 
--> 2
    
-- (19-2) 
SELECT INSTR('ABCDEFG@NAVER.COM', '@')
FROM DUAL;
--> 8

-- (19-3)
SELECT SUBSTR('ABCDEFGH@NAVER.COM', INSTR('ABCDEFGH@NAVER.COM', '@') + 1)
FROM DUAL;
--> NAVER.COM 출력.

-- (19-4) RTRIM()
SELECT RTRIM ( SUBSTR('ABCDEFGH@NAVER.COM', INSTR('ABCDEFGH@NAVER.COM', '@') + 1), '.COM')
FROM DUAL;
--> NAVER 출력.

-- (20-1) REPLACE()
SELECT ENAME, REPLACE(SAL, 0, '*')
FROM EMP;
--> SAL에서 숫자 0을 *로 출력. 

-- (20-2) REGEXP_REPLACE()
SELECT ENAME, REGEXP_REPLACE(SAL, '[0-3]', '*') AS SALARY
FROM EMP; 
--> SAL에서 숫자 0~3을 *로 출력. 

-- (20-3)
SELECT REPLACE(ENAME, SUBSTR(ENAME, 2, 1), '*') AS "전광판_이름"
FROM EMP;
--> 이름의 두 번째 자리의 문자를 *로 출력.

-- (21-1) LPAD(), RPAD()
SELECT ENAME, LPAD(SAL, 10, '*') AS SALARY1, RPAD(SAL, 10, '*') AS SALARY2
FROM EMP;
--> LPAD(컬럼, 자리수, 문자): 컬럼을 출력하고 왼쪽에 부족한 자리수만큼 문자 출력. 
--> RPAD 

-- (33-1) NVL(): NULL이 아니면 COMM값을, NULL이면 0을 출력. 
SELECT ENAME, COMM, NVL(COMM, 0)
FROM EMP;

-- (33-4) NVL2(): NULL이 아니면 SAL+COMM을, NULL이면 SAL을 출력. 
SELECT ENAME, SAL, COMM, NVL2(COMM, SAL+COMM, SAL)
FROM EMP
WHERE JOB IN ('SALESMAN', 'ANALYST')
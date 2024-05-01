/*
alter table: 테이블의 정의를 변경 
- DDL(Data Definition Language): create, alter, truncate, drop

    1. 이름 변경: alter table ... rename ... to ...
    2. 추가: alter table ... add ... 
    3. 삭제: alter table ... drop ...
    4. 수정: alter table ... modify ... 
*/

-- 1. 이름 변경: (테이블, 컬럼, 제약조건 등의 이름을 변경할 수 있다.)
--  (1-1) 테이블
        select table_name from user_tables; -- 접속 계정의 테이블 이름 출력. 
        -- 'ex_students' 테이블을 'students'로 변경
        alter table ex_students rename to students;

--  (1-2) 컬럼
        describe students; --> 오라클의 테이블 설명 명령어. ('desc'도 같은 결과.)
        -- stuno 컬럼을 stuid로 변경:
        alter table students rename column stuno to stuid;

--  (1-3) 제약조건
        select constraint_name from user_constraints; --> 제약조건 출력.
        -- 제약조건 ex_emp4_fk_deptno을 emp4_fk로 이름 변경 
        alter table ex_emp4 rename constraint ex_emp4_fk_deptno to emp4_fk;
        
        
-- 2. 추가(add):
--  (2-2) 컬럼
        -- students 테이블에 department 컬럼 추가. 
        alter table students add department number(2);

--  (2-3) 제약조건 (alter table ... add constraint ...)
        -- students 테이블의 stuid 컬럼을 PK로 설정.
        alter table students add constraint students_pk primary key (stuid);
        
        --  students 테이블의 department 컬럼을 NN로 설정.
        alter table students add constraint dept_nn check (department is not null); 
        --> department 컬럼에 null 값이 들어있기 때문에 오류 남. 
         
describe students;  
commit;
        
-- 3. 삭제(drop): 
--  (3-2) 컬럼
        alter table students drop column department;

--  (3-3) 제약조건 (alter table ... drop constraint ...)
        alter table students drop constraint students_pk;


-- 4. 수정(modify): 컬럼 정의 (데이터 타입, 기본값, null 여부)를 설정.
    -- students 테이블의 stuname 컬럼의 데이터 타입을 
    -- varchar2(4 char)에서 varchar2(20 char)로 변경하고 NN 추가.
        alter table students modify stuname varchar2(40 char) not null; 
        --> modify는 제약조건의 내용을 변경하는 것이 아니라,
        --> 제약조건을 삭제하고 추가하는 것이다. 
            
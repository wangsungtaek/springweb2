SELECT * FROM DEPT2
WHERE DNAME LIKE UPPER('%%') 
AND LOC LIKE UPPER('%%');

INSERT INTO DEPT2 VALUES (50, '홍길동', '청주');
    
DELETE DEPT2 WHERE DEPTNO = 50;

UPDATE DEPT2
   SET DNAME = '홍길동',
   	   LOC = '홍대'
 WHERE DEPTNO = 50;

SELECT e.*, dname, loc, grade
FROM EMP e, DEPT d, SALGRADE s
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND job = 'MANAGER'
AND e.deptno = 20
AND grade = 4;

SELECT DISTINCT job FROM EMP;
/*
CLERK
SALESMAN
PRESIDENT
MANAGER
ANALYST
*/
SELECT * FROM DEPT;
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/
SELECT * FROM SALGRADE;

SELECT e.mgr, e.ename
 FROM EMP e, EMP m
WHERE e.mgr = m.empno;
/*
7902	SMITH
7698	ALLEN
7698	WARD
7839	JONES
7698	MARTIN
7839	BLAKE
7839	CLARK
7698	TURNER
7698	JAMES
7566	FORD
7782	MILLER
*/
SELECT * FROM emp01;

CREATE SEQUENCE EMP01_SEQ
	START WITH 8000
	INCREMENT BY 1;
SELECT * FROM EMP;
SELECT * FROM dept;
CREATE TABLE dept2 AS
SELECT * FROM dept;

CREATE TABLE member5 (
	id varchar2(50),
	pass varchar2(50),
	name varchar2(30),
	point NUMBER,
	address varchar2(50),
	regdte DATE,
	auth varchar2(30)
);
INSERT INTO member5 values('himan', '7777', '홍길동', 1000, '서울 강남', sysdate, 'admin');
INSERT INTO member5 values('higirl', '8888', '심영희', 1500, '충청 대전', sysdate, 'user');
INSERT INTO member5 values('goodman', '9999', '김철수', 200, '서울 방배', sysdate, 'user');
INSERT INTO member5 values('prettyman', '5555', '김현석', 1200, '인천 계양', sysdate, 'user');
INSERT INTO member5 values('whitewolf', '6666', '마동길', 5000, '경기 수원', sysdate, 'quest');

SELECT * FROM member5;

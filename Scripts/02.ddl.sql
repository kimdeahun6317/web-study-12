SELECT USER FROM DUAL;

DROP TABLE MEMBER;
-- MEMBER TABLE 생성
CREATE TABLE member(
	name varchar2(20),
	userid varchar2(10),
	pwd varchar2(10),
	email varchar2(20),
	phone char(13),
	admin number(1) DEFAULT 0,
	joinDate DATE DEFAULT sysdate,
	PRIMARY KEY (userid)
);


SELECT *
  FROM USER_TABLES
 WHERE TABLE_NAME = 'MEMBER';
 
-- 접속한 계정의 테이블별 컬럼 조회
SELECT *
  FROM USER_TAB_COLUMNS 
 WHERE table_name IN ('MEMBER');
 
-- 접속한 계정의 테이블별 제약조건 검색
SELECT *
  FROM USER_CONSTRAINTS 
 WHERE table_name IN ('MEMBER');


-------------------------title
CREATE TABLE title(
	TITLE_NO NUMBER PRIMARY KEY,
	TITLE_NAME VARCHAR2(40)
);



CREATE TABLE DEPARTMENT(
	DEPT_NO NUMBER PRIMARY KEY,
	DEPT_NAME VARCHAR2(40),
	FLOOR NUMBER
);



-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE (
    EMP_NO   NUMBER,
    EMP_NAME VARCHAR2(20) NOT NULL,
    TNO      NUMBER,
    MANAGER  NUMBER,
    SALARY   NUMBER,
    DNO      NUMBER,
    EMAIL    varchar2(60) NOT NULL,
    PASSWD   varchar2(60) NOT NULL,
    REGDATE  DATE DEFAULT SYSDATE,
    TEL      char(13),
    pic_url  varchar2(100),
    CONSTRAINT EMPLOYEE_EMPNO_PK   PRIMARY KEY (EMP_NO),
    CONSTRAINT EMPLOYEE_TNO_FK     FOREIGN KEY (TNO)     REFERENCES TITLE(TITLE_NO) ON DELETE SET NULL, 
    CONSTRAINT EMPLOYEE_MANAGER_FK FOREIGN KEY (MANAGER) REFERENCES EMPLOYEE(EMP_NO),
    CONSTRAINT EMPLOYEE_SALARY_CK  CHECK (SALARY < 6000000),
    CONSTRAINT EMPLOYEE_DNO_FK     FOREIGN KEY (DNO) REFERENCES DEPARTMENT(DEPT_NO) ON DELETE CASCADE
);

CREATE OR REPLACE VIEW VW_EMPLOYEE_JOIN AS 
SELECT e.EMP_NO, e.EMP_NAME, e.TNO, e.MANAGER , e.SALARY, e.DNO, e.REGDATE, e.EMAIL , e.TEL , e.PIC_URL, 
       t.TITLE_NAME, d.DEPT_NAME, m.EMP_NAME MANAGER_NAME
  FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO 
       LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO 
       JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO; 
      
-------------------------------------------------------------------------- 
SELECT USER FROM DUAL;
      
CREATE TABLE product(
	code number(5),
	name varchar2(100),
	price number(8),
	pictureurl varchar(50),
	description varchar(1000),
	PRIMARY KEY (code)
);

CREATE SEQUENCE product_SEQ
	START WITH 1
	INCREMENT BY 1;

DROP SEQUENCE product_SEQ;

--트리커를 이용하여 번호가 입력되도록
CREATE OR REPLACE TRIGGER TRI_product_AUTOSEQ
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
   IF Inserting AND :NEW.code IS NULL THEN
      SELECT product_SEQ.NEXTVAL INTO :NEW.code FROM DUAL;
   END IF;
END;

DROP TRIGGER TRI_product_AUTOSEQ;

INSERT INTO product VALUES (NULL,'TEST');

SELECT * FROM product;

DELETE product;
      

----------------------------------------------------------------------
CREATE TABLE board(
	num number(5) PRIMARY KEY,
	pass varchar2(30),
	name varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) DEFAULT 0,
	writedate DATE DEFAULT sysdate 
);
      
CREATE SEQUENCE board_SEQ
	START WITH 1
	INCREMENT BY 1;
      
--트리커를 이용하여 번호가 입력되도록
CREATE OR REPLACE TRIGGER TRI_board_AUTOSEQ
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
   IF Inserting AND :NEW.num IS NULL THEN
      SELECT board_SEQ.NEXTVAL INTO :NEW.num FROM DUAL;
   END IF;
END;

DROP TRIGGER TRI_board_AUTOSEQ;
      

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      



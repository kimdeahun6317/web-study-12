INSERT ALL
	INTO MEMBER VALUES ('이소미', 'somi', '1234', 'gmd@naver.com', '010-2362-5157', 0, sysdate)
	INTO MEMBER VALUES ('하상오', 'sang12', '1234', 'ha12@naver.com', '010-5629-8888', 1, sysdate)
	INTO MEMBER VALUES ('김윤승', 'light', '1234', 'youn104@naver.com', '010-9999-8282', 0, sysdate)
	SELECT 1 FROM DUAL;
	
SELECT * FROM MEMBER;

INSERT ALL
	INTO TITLE VALUES (1, '사장')
	INTO TITLE VALUES (2, '부장')
	INTO TITLE VALUES (3, '과장')
	INTO TITLE VALUES (4, '대리')
	INTO TITLE VALUES (5, '사원')
	SELECT 1 FROM DUAL;

SELECT * FROM TITLE;

INSERT ALL
	INTO DEPARTMENT VALUES (1, '영업', 10)
	INTO DEPARTMENT VALUES (2, '기획', 20)
	INTO DEPARTMENT VALUES (3, '마케팅',30)
	SELECT 1 FROM DUAL;

SELECT * FROM DEPARTMENT ;


INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(4377, '이성래', 1, NULL, 5000000, 2, 'test@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(3426, '박영권', 3, 4377, 3000000, 1, 'test1@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(3011, '이수민', 2, 4377, 4000000, 3, 'test2@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(3427, '최종철', 5, 3011, 1500000, 3, 'test3@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(1003, '조민희', 3, 4377, 3000000, 2, 'test4@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(2106, '김창섭', 4, 1003, 2500000, 2, 'test5@test.co.kr', '1234');
INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(1365, '김상원', 5, 3426, 1500000, 1, 'test6@test.co.kr', '1234');

UPDATE EMPLOYEE 
	SET TEL = '053-1111-1111';

SELECT * FROM EMPLOYEE ;



DELETE product;

SELECT CODE,NAME,PRICE,PICTUREURL,DESCRIPTION FROM product;

insert into product values(product_seq.nextval, '개념을 콕콕 잡아주는 데이터베이스', 27000, 'db.jpg', '데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재...');

insert into product(CODE,NAME,PRICE,PICTUREURL,DESCRIPTION) values(null, 'test', 25000, 'test.jpg', 'test 가이드북. 홈페이지 제작을 위한 필수 선택 HTML 기본 문법...');

insert into product values(product_seq.nextval, '웹표준을 위한 HTML5', 25000, 'html5.jpg', 'HTML5 가이드북. 홈페이지 제작을 위한 필수 선택 HTML 기본 문법...');
insert into product values(product_seq.nextval, 'Dynamic Programming book 시리즈-01 오라클 11g + PL/SQL', 25000, 'oracle.jpg','Dynamic 실무 코칭 프로그래밍 Book의 첫번째 책으로, 오라클 11g의 새로운 ...');
insert into product values(product_seq.nextval, 'Visual C++ MFC 윈도우 프로그래밍', 26000, 'mfc.jpg', 'Visual C++를 처음 시작하는 독자의 눈높이에 맞춘 Visual C++...');
insert into product values(product_seq.nextval, 'jQuery and jQuery Mobile : 이해하기 쉽게 풀어쓴', 25000, 'jquery.jpg', '소스 하나로 데스크탑과 모바일까지 HTML5와 함께 사용한다. 초보자들도 ...');

-----------------------------------------------------------------
INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values('1234','아이유','test@test.naver','첫방문','반갑습니다',0,'2020-01-14');
INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values('1235','아이유2','test2@test.naver','첫방문2','반갑습니다2',0,'2020-01-12');
INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values('1236','아이유3','test3@test.naver','첫방문3','반갑습니다3',0,'2020-01-13');
INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values('1237','아이유4','test4@test.naver','첫방문4','반갑습니다4',0,'2020-01-14');
INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values('1238','아이유5','test5@test.naver','첫방문5','반갑습니다5',0,'2020-01-15');


SELECT * FROM board;


INSERT INTO board(pass,name,email,title,content,readcount,writedate)
	values(?,?,?,?,?,?,?);

UPDATE board SET PASS =?,NAME =?,EMAIL =?,TITLE =?,CONTENT =?,READCOUNT =?,WRITEDATE =? WHERE num=?;

DELETE FROM board WHERE num=20;

SELECT NUM,PASS,NAME,EMAIL,TITLE,CONTENT,READCOUNT,WRITEDATE FROM BOARD WHERE NUM = ? AND PASS = ?;

UPDATE BOARD
	SET READCOUNT = READCOUNT+1
	WHERE NUM =5 ;

SELECT * FROM board;
















	
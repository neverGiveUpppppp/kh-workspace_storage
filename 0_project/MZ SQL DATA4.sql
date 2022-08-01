
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;
DROP TABLE RESTAURANT CASCADE CONSTRAINTS;
DROP TABLE FOOD CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE IMAGE CASCADE CONSTRAINTS;


DROP SEQUENCE SEQ_NID;
DROP SEQUENCE SEQ_RID;
DROP SEQUENCE SEQ_FID;
DROP SEQUENCE SEQ_BID;
DROP SEQUENCE SEQ_RPID;
DROP SEQUENCE SEQ_IID;


--------------------------------------------------
--------------     MEMBER 관련	------------------	
--------------------------------------------------


CREATE TABLE MEMBER (
	USER_ID	VARCHAR2(20) PRIMARY KEY,
	USER_PWD	VARCHAR2(100)	NOT NULL,
    USER_NAME VARCHAR2(20) NOT NULL,
    PHONE	VARCHAR2(13)	NOT NULL,
	USER_EMAIL	VARCHAR2(50)	NOT NULL,
	GENDER	CHAR(1)		DEFAULT 'M',
    ADDRESS VARCHAR2(100)    NOT NULL,	
	BORN_DATE	DATE    NOT NULL,	
  	ENROLL_DATE DATE    DEFAULT SYSDATE,
    MODIFY_DATE DATE    DEFAULT SYSDATE,
  	STATUS VARCHAR2(1) DEFAULT 'Y'
					             
);

INSERT INTO MZ.MEMBER VALUES ('admin', '1234', '관리자',  '010-1111-2222', 'admin@naver.com', 'M', '서울시 분당구 정자동', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user01', 'pass01', '최기현', '010-1111-1111', 'itkw87@naver.com', 'M', '성남시 분당구 판교동', '95/09/25', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user02', 'pass02', '이재환', '010-2222-5555', 'user02@naver.com', 'M', '인천시 부평구 부개동', '90/02/06' , SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user03', 'pass03', '정다솜', '010-3333-4444', 'user03@naver.com', 'W', '광주시 서구 치평동', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user04', 'pass04', '최신영', '010-5555-4444', 'user04@naver.com', 'M', '서울시 양천구 목동', '90/02/06', SYSDATE, SYSDATE, DEFAULT);



--------------------------------------------------
--------------     NOTICE 관련	------------------	
--------------------------------------------------

CREATE TABLE NOTICE (
  NOTICE_NO NUMBER PRIMARY KEY,
  NOTICE_TITLE VARCHAR2(100) NOT NULL,
  NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
  NOTICE_WRITER VARCHAR2(30) NOT NULL,
  NOTICE_COUNT NUMBER DEFAULT 0,
  NOTICE_DATE DATE DEFAULT SYSDATE,
  STATUS VARCHAR2(1) DEFAULT 'Y'
);

CREATE SEQUENCE SEQ_NID

MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO NOTICE
VALUES (SEQ_NID.NEXTVAL, '첫번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, SYSDATE, DEFAULT);




--------------------------------------------------
--------------     RESTAURANT 관련	------------------	
--------------------------------------------------

CREATE TABLE RESTAURANT (
	RESTAURANT_NO	NUMBER PRIMARY KEY,
	RESTAURANT_NAME	VARCHAR2(30)	NOT NULL,
	RESTAURANT_ADDRESS	VARCHAR2(200)	NOT NULL,
	RESTAURANT_PHONE	VARCHAR2(13) NULL, -- NULL 가능 -- NVL(RESTAURANT_PHONE, '-')
    RESTAURANT_INTRO VARCHAR(300) NULL, -- 식당 간단소개
    RESTAURANT_CONTENT VARCHAR(4000) NULL, -- 상세보기 메인 내용
	STATUS VARCHAR2(1) DEFAULT 'Y'       
);

CREATE SEQUENCE SEQ_RID
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'팔공','서울 관악구 신림동 10-621 지하 1층','02-877-9815','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'짜장면집','서울 관악구 신림동 10-621 지하 1층','02-877-9815','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'루비정','서울 관악구 신림동 10-621 지하 1층','02-877-9815','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'아라차이','서울 관악구 신림동 10-621 지하 1층','02-877-9815','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'홍콩반점','서울 관악구 신림동 10-621 지하 1층','02-877-9815','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'채린','서울 관악구 봉천로 232','-','간단내용','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'도림','서울 중구 을지로 30 롯데호텔서울 본관 37층','02-317-7101','간단내용 : 중국 요리아시아 요리스촨','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'쟈니덤플링','서울 용산구 보광로59길 5','02-790-8830','간단내용 : 중국 요리아시아 요리스촨','상세보기 내용','Y');



--------------------------------------------------
--------------     FOOD 관련	------------------	
--------------------------------------------------


CREATE TABLE FOOD (
	FOOD_NO	NUMBER PRIMARY KEY,
	FOOD_NAME	VARCHAR2(20)	NOT NULL,
    FOOD_TYPE VARCHAR2(20) NOT NULL,
	RESTAURANT_NO	NUMBER ,
	STATUS	VARCHAR2(1)	DEFAULT 'Y', --새로 추가
	CONSTRAINT FD_RESN_FK FOREIGN KEY (RESTAURANT_NO) REFERENCES RESTAURANT(RESTAURANT_NO) 
);

CREATE SEQUENCE SEQ_FID
MAXVALUE 10000
NOCACHE;

INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '팔보채', '중식', 1, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '짜장', '중식', 1, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '짬뽕', '중식', 1, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '탕수육', '중식', 1, 'Y');


select * from user_sequences;

--------------------------------------------------
--------------     BOARD 관련	------------------	
--------------------------------------------------


CREATE TABLE BOARD (
	BOARD_NO	NUMBER	CONSTRAINT BO_BON_PK PRIMARY KEY,
	BOARD_TYPE NUMBER, -- 일반 게시판(1)이냐 사진 게시판(2)이냐 확인필요
	BOARD_TITLE	VARCHAR2(30)	NOT NULL,
	REF_RESTAURANT_NO	NUMBER,
	FOOD_NO	NUMBER ,
	USER_ID VARCHAR2(30),         	
	BOARD_COUNT	NUMBER	DEFAULT 0, -- 조회수
	BOARD_CONTENT	VARCHAR2(4000)	NOT NULL,
	BOARD_DATE	DATE	NULL,    
  	MODIFY_DATE DATE DEFAULT SYSDATE,             
	STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),   --기존꺼 변경
	CONSTRAINT BO_USI_FK FOREIGN KEY (USER_ID) REFERENCES MEMBER(USER_ID),
    CONSTRAINT BO_RRN_FK FOREIGN KEY (REF_RESTAURANT_NO) REFERENCES RESTAURANT(RESTAURANT_NO),
    CONSTRAINT BO_FDN_FK FOREIGN KEY (FOOD_NO) REFERENCES FOOD(FOOD_NO)
);

CREATE SEQUENCE SEQ_BID
MAXVALUE 10000;


--	4 RESTAURANT_NO	NUMBER,
--	5 FOOD_NO	NUMBER ,
--	6 USER_ID VARCHAR2(30), 
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '팔공', 1, 1, 'user01', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '짜장면집', 2, 1, 'user02', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '루비정', 3, 2, 'user03', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '아라차이', 4, 2, 'user04', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '팔공', 1, 3, 'user01', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '짜장면집', 2, 3, 'user02', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '루비정', 3, 2, 'user03', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '아라차이', 4, 4, 'user04', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');

--
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '팔공', SEQ_RID.CURVAL, SEQ_FID.NEXTVAL, 'user01', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '짜장면집', SEQ_RID, 2, 'user02', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '루비정', SEQ_RID.CURVAL, 2, 'user03', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '아라차이', SEQ_RID.CURVAL, 3, 'user04', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--



--------------------------------------------------
--------------     REPLY 관련	------------------	
--------------------------------------------------


CREATE TABLE REPLY (
	REPLY_NO NUMBER	CONSTRAINT RE_REN_PK PRIMARY KEY,
    REPLY_CONTENT	VARCHAR2(300)	NOT NULL,
	REPLY_DATE DATE, -- 댓글 작성일
	STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN ('Y', 'N')),
	BOARD_NO	NUMBER	NOT NULL,     -- 참조할 보드게시판 번호
	USER_ID	VARCHAR2(30)	NOT NULL, -- 댓글 작성자
	NOTICE_NO	NUMBER	NOT NULL, -- 공지사항 게시판 번호
    CONSTRAINT RE_BON_FK FOREIGN KEY (BOARD_NO) REFERENCES BOARD,            --외래키 추가
	CONSTRAINT RE_USI_FK FOREIGN KEY (USER_ID) REFERENCES MEMBER,          --외래키로 추가
	CONSTRAINT RE_NON_FK FOREIGN KEY (NOTICE_NO) REFERENCES NOTICE 
);


CREATE SEQUENCE SEQ_RPID
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000
NOCYCLE
NOCACHE;


--------------------------------------------------
--------------     IMAGE 관련	------------------	
--------------------------------------------------


CREATE TABLE IMAGE (
	IMAGE_NO	NUMBER CONSTRAINT IM_IMN_PK	NOT NULL,
    BOARD_NO	NUMBER	NOT NULL,
	IMAGE_ORIGIN_NAME	VARCHAR2(255) NOT NULL,
	IMAGE_CHANGE_NAME	VARCHAR2(255) NOT NULL,
	IMAGE_PATH	VARCHAR2(1000)	NULL,
	IMAGE_UPLOAD_DATE	DATE DEFAULT SYSDATE,
	IMAGE_LEVEL	NUMBER	NULL,
	STATUS	VARCHAR2(1)	DEFAULT 'Y',
	FOREIGN KEY (BOARD_NO) REFERENCES BOARD(BOARD_NO)      --외래키 추가 
);

CREATE SEQUENCE SEQ_IID
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000    
NOCYCLE
NOCACHE;


--------------------------------------------------
--------------------- commit ---------------------
--------------------------------------------------

COMMIT;



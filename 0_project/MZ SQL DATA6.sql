
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
-- admin 1234
-- user01 pass01,02,03...
INSERT INTO MZ.MEMBER VALUES ('admin', '1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==', '관리자',  '010-1111-2222', 'admin@naver.com', 'M', '서울시 분당구 정자동', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user01', '02DeqFdlQnpEbQRZqnvpfK7a9sO9iISEV7Hzxntivto23dJ/i16UMur0ACYxwsfAxFwzfn5yarbQnsbAtkCJAg==', '최기현', '010-1111-1111', 'itkw87@naver.com', 'M', '성남시 분당구 판교동', '95/09/25', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user02', 'ybuT5RE3Qb/bE69MynKRp21UqUH7gwxtO8uOGrOsKqgPt95nPzymK/si9YTYCIxP0CfaqS2StvpiQ0W5UwyCVg==', '이재환', '010-2222-5555', 'user02@naver.com', 'M', '인천시 부평구 부개동', '90/02/06' , SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user03', 'iplxewLli7qPQF+vVHtB4loDo/E9Zw9efFh7eEh1NI+MrrMXTVqtmYEe/HBLnduhQ2VTnkV+2AkVdHiNnxR8mg==', '정다솜', '010-3333-4444', 'user03@naver.com', 'W', '광주시 서구 치평동', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user04', 'Z0U+iqhgJz33L+h4J/Jk7/gJY7g6fOsxJArSl02c5fjgD/58eBUJQcSpWzNxpOtMVwLF7m0OKnOr1GHnE6vIrg==', '최신영', '010-5555-4444', 'user04@naver.com', 'M', '서울시 양천구 목동', '88/06/25', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user05', '1Kq7ah9oGObMip407Jocgb3og45it48imRhxh6iM3Z0cOUQaRzie2GOdwtqy8hDr+0D1f1iCbS6n/qoMj6/m6Q==', '김철수', '010-5555-4444', 'user05@naver.com', 'M', '서울시 양천구 목동', '90/08/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user06', 'rVlGlBOrURd1D9CuJb0/fCPZopDofiPqovLD5GkJQ10BjlGpAbtIy8w3an/S2kgzT7AiZx2V4T1i/1qxtHkQ2w==', '최철수', '010-5555-4444', 'user06@naver.com', 'M', '서울시 양천구 목동', '98/05/08', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user07', 'oLIyZ7vFfMfiu/0G60rd+itn8/eFuZeJfAjCJWtyNIY/9n/GNAAUxWtEGGIsTwdNa6UsNY4PmDZeS+pFlh5tYA==', '박철수', '010-5555-4444', 'user07@naver.com', 'M', '서울시 양천구 목동', '96/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user08', 'PNWgU7GoZpRuInfdPSUXs9+SQuwpWc7ufVRlGmJ5P2/LG6QlsB33JpH+xWuJcOzidgFMwaz511Sb8yioAp6rjA==', '이철수', '010-5555-4444', 'user08@naver.com', 'M', '서울시 양천구 목동', '93/04/21', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user09', 'mQoDu0fflx/wFACAbYtXqyG4ZWTpc8gZyelWj/dDw9gHMKv7Jd6Yiy1d1SyV0pM80Y2QTXC2DewnrBq8DCtgfA==', '김영희', '010-5555-4444', 'user09@naver.com', 'W', '서울시 양천구 목동', '97/02/13', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user10', 'Ca7ahwrNjNwfyslTA0VlNjt6rfe2f5Fv/wSs3TLI5d2jpgyTi1SUv/v4te0ZJEA6hIaLEyuveNZxBlFqqc22MQ==', '최영희', '010-5555-4444', 'user10@naver.com', 'W', '서울시 양천구 목동', '99/03/27', SYSDATE, SYSDATE, DEFAULT);


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

INSERT INTO NOTICE VALUES (SEQ_NID.NEXTVAL, '첫번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, SYSDATE, DEFAULT);





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
MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'중화요리 팔공','서울 관악구 신림동 10-621 지하 1층','02-877-9815',' 줄서서 먹는 오랜 맛집. 짬뽕의 해물 양이 많고 푸짐하다',
'<동네에 있어 감사한 중식당>
지난번에 볶음밥을 맛있게 먹었던 팔공에 다시 방문했다. 지난 방문 때는 대기 없이 먹을 수 있었는데 이번에는 30분 정도 대기해야 했다. 
대기 후에 테이블에 앉아 해물짬뽕과 군만두를 주문했다. 군만두가 먼저 나온 뒤 뒤이어 바로 짬뽕이 나왔다. 
군만두 : 갈색 빛깔로 잘 튀겨진 군만두는 피와 소 모두 특별하진 않았지만 바로 튀겨줬기 때문에 맛있게 먹었다. 
해물짬뽕 : 진한 국물과 함께 조개, 오징어, 새우, 표고, 피망, 브로콜리 등 다양한 재료들이 볶아져 나왔다. 닭육수와 해산물의 감칠맛과 야채들의 달콤함에 불맛까지 더해져 깊으면서도 너무 기름지지 않고 깔끔한 국물이 좋았다. 해산물들도 잘 익혀 부드럽고 쫄깃하게 먹을 수 있었다. 
손님들이 몰리는 식사시간에도 한 그릇, 한 그릇 바로 바로 조리하는 정성이 고맙다. 동네에 이렇게 정성스럽고 맛있는 중식당이 있어 기쁘고 감사하다. ','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'짜장면집','서울 관악구 신림동 1636-35','02-623-9525','말이 필요없는 최강 가성비 짜장면 3000원!', 
'안녕하세요 여러분, GeniusJW 입니다.
오늘 소개해드릴 가게는 관악구 신림동 1636-35 에 위치한 3,000원 짜장면을 판매하는 가게 <짜장면집>입니다.
신림동 짜장면집은 가성비 좋은 저렴한 가격의 짜장면과 짬뽕, 탕수육 등을 판매하고 있는 중식집이었습니다. 
예전부터 한 번 이용해 보고 싶었는데 이번에 기회가 되어 방문했습니다.','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'루비정','서울 관악구 신림동 10-621','02-877-9815','가지볶음 먹어보면 가지 무시 못할 껄?',
'배달맛집 오프라인 방문기. 향라닭날개랑 마파두부추천. 봉천역 인근에서 중식 동북요리 좋아하는 분이면 한번 가보시길 추천. 
차*나당처럼 저렴하진 않지만 양도 많고 맛도 좋다. 예전에 한식집이었던 곳에 차린건지 한옥스타일의 식당 인테리어가 특이하다. 
넓고 깔끔하고 조용한 편. 가정냉채, 향라닭날개, 마파두부덮밥 주문하고 건두부냉 채가 서비스로 나왔는데 냉채 너무 많이 나와서 남겼다.
지금 생각하니 아쉽네...ㅠㅠ 향라닭날개 세상 바삭하고, 고추 튀긴거도 빠작하니 맵지않아 열심히 곁들여 먹었다.
술안주로 딱인듯. 가정냉채는 상큼하니 좋긴한데 오이지분율이 너무 높아서 오이 좋아하는 분에게 더 맞을 듯. 
내입맛에는 서비스로 나온 건두부냉채가 더 맛나다. 재방문 의사 있음. 배달도 또 시킬 예정 ㅎ','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'아라차이','서울 관악구 봉천동 22','02-877-9815','고급 중식 코스요리로 유명한 곳. 상견례, 중요 미팅 등 추천','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'홍콩반점','서울 관악구 신림동 35','02-826-8855','백선생의 가장 유명한 브랜드 맛집','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'채린','서울 관악구 봉천로 232','02-499-3400','주변 주민들의 핫플레이스. 안 가본 사람은 있어도 한번 간 사람은 없다 ','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'도림','서울 중구 을지로 30 롯데호텔서울 본관 37층','02-317-7101','중국 요리아시아 요리스촨','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'쟈니덤플링','서울 용산구 보광로59길 5','02-790-8830','만두(덤플링) 전문점','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'교동짬뽕','서울 구로구 보광로59길 5','02-790-8830','짬뽕으로 유명한 그 곳. 매운맛 좀 볼래?','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'황궁쟁반 거목','서울특별시 관악구 신림동 난우길 35','02-859-0035','매콤한 쟁반 짜장이 유명한 곳','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'24시 서울 밥집','서울특별시 관악구 서원동 관천로 36-1','02-355-0135','너무 저렴한 가격으로 항상 북적이는 곳','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'지화자','서울특별시 종로구 자하문로 125','02-485-8265','높은 퀄리티와 깔끔하고 정갈한 음식. 미팅에 추천','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'산들애밥상','서울특별시 금천구 독산동 독산로 178-1','02-743-3865','웰빙 밦방을 추구하는 곳. 코다리 정식 드셔보시라','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'정원쌈밥보리밥','서울특별시 관악구 신림동','02-887-6454','보쌈 양도 많고 우렁쌈장은 일품, 밥, 반찬 추가는 무료!','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'감나무집','서울특별시 관악구 서원동 관천로 36-1','02-882-0077','보리굴비 정식이 일품. 정이 있어요','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'푸짐한식당','서울특별시 관악구 서원동 관천로 36-1','02-355-0135','아침,점심,저녁 언제나 부담없이 속이 편한 곳','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'정가네식당','서울특별시 관악구 서원동 관천로 36-1','02-875-3018','너무 저렴한 가격으로 항상 북적이는 곳','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'한송정','경기도 안양 부림로 156 6층','031-424-8599','너무 저렴한 가격으로 항상 북적이는 곳','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'이가네','서울특별시 관악구 서원동 관천로 36-1','02-355-0135','한정식의 정수','상세보기 내용','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'한정식','서울특별시 관악구 행복동 행복로 36-1','02-355-0135','너무 저렴한 가격으로 항상 북적이는 곳','상세보기 내용','Y');



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

INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '짬뽕', '중식', 1, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '짜장', '중식', 2, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '가지볶음', '중식', 3, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '탕수육', '중식', 4, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '탕수육', '중식', 5, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '덤플링', '중식', 6, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '탕수육', '중식', 7, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '만두', '중식', 8, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '짬뽕', '중식', 9, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '쟁반짜장', '중식', 10, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '한정식 코스', '한식', 11, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '코다리 정식', '한식', 12, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '보쌈 우렁쌈장', '한식', 13, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '보리굴비', '한식', 14, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '정식', '한식', 15, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '제육볶음', '한식', 16, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '쌈밥', '한식', 17, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '보리밥', '한식', 18, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '김치찌개', '한식', 19, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '된장찌개', '한식', 20, 'Y');


--------------------------------------------------
--------------     BOARD 관련	------------------	
--------------------------------------------------


CREATE TABLE BOARD (
	BOARD_NO	NUMBER	CONSTRAINT BO_BON_PK PRIMARY KEY,
	BOARD_TYPE NUMBER, -- 일반 게시판(1)이냐 사진 게시판(2)이냐 확인필요
	BOARD_TITLE	VARCHAR2(30)	NOT NULL,
	REF_RESTAURANT_NO	NUMBER,
	REF_FOOD_NO	NUMBER ,
	REF_USER_ID VARCHAR2(30),         	
	BOARD_COUNT	NUMBER	DEFAULT 0, -- 조회수
	BOARD_CONTENT	VARCHAR2(4000)	NOT NULL,
	BOARD_DATE	DATE DEFAULT SYSDATE,    
  	MODIFY_DATE DATE DEFAULT SYSDATE,             
	STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),   --기존꺼 변경
	CONSTRAINT BO_USI_FK FOREIGN KEY (REF_USER_ID) REFERENCES MEMBER(USER_ID),
    CONSTRAINT BO_RRN_FK FOREIGN KEY (REF_RESTAURANT_NO) REFERENCES RESTAURANT(RESTAURANT_NO),
    CONSTRAINT BO_FDN_FK FOREIGN KEY (REF_FOOD_NO) REFERENCES FOOD(FOOD_NO)
);

CREATE SEQUENCE SEQ_BID
MAXVALUE 10000;


--	4 RESTAURANT_NO	NUMBER,
--	5 FOOD_NO	NUMBER ,
--	6 USER_ID VARCHAR2(30), 
-- 시퀸스.currval 문제점은 보드테이블에서 참조될 때 시퀸스의 가장 마지막값으로만 참조가 됨
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '팔공', 1, 1, 'user01', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '짜장면집', 2, 2, 'user02', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '루비정', 3, 3, 'user03', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '아라차이', 4, 4, 'user04', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '홍콩반점', 5, 5, 'user05', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '채린', 6, 6, 'user06', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '도린', 7, 7, 'user07', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '쟈니덤플링', 8, 8, 'user08', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '교동짬뽕', 9, 9, 'user08', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '맛집8', 10, 10, 'user08', DEFAULT, 'board_contetnt 중국 본토 요리', SYSDATE, NULL, 'Y');


--
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '팔공', 1, 1, 'user01', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '짜장면집', 2, 2, 'user02', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '루비정', 3, 2, 'user03', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '아라차이', 4, 3, 'user04', DEFAULT, '중국 본토 요리', SYSDATE, NULL, 'Y');
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



INSERT INTO customer " +
			"VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)


CREATE TABLE customer2(
    id varchar2(20) primary key, --고객아이디
    NAME VARCHAR2(20), --고객이름
    age NUMBER(3), --고객나이
    tel VARCHAR2(30), --고객연락처
    addr VARCHAR2(50)--고객주소
)

drop table customer

insert into customer2 values('jang','장희정',20,'02-222-8282','서울시 강남구');
insert into customer2 values('kim','김희선',23,'02-222-4444','서울시 강북구');
insert into customer2 values('king','정수현',21,'02-222-5555','경기도 성남시');

commit

select * from customer2;




select * from customer2
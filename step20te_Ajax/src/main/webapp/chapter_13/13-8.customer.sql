INSERT INTO customer " +
			"VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)


CREATE TABLE customer2(
    id varchar2(20) primary key, --�������̵�
    NAME VARCHAR2(20), --�����̸�
    age NUMBER(3), --��������
    tel VARCHAR2(30), --��������ó
    addr VARCHAR2(50)--�����ּ�
)

drop table customer

insert into customer2 values('jang','������',20,'02-222-8282','����� ������');
insert into customer2 values('kim','����',23,'02-222-4444','����� ���ϱ�');
insert into customer2 values('king','������',21,'02-222-5555','��⵵ ������');

commit

select * from customer2;




select * from customer2
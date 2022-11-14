drop table Electronics;

create table Electronics(
	model_num varchar2(15) primary key, --��ǰ��ȣ
	model_name varchar2(20) not null,--��ǰ�̸�
	price int,--����
	description varchar2(100), --����
	password varchar2(20) not null,--��й�ȣ
	writeday date  not null, --�ۼ���
	readnum int, --��ȸ��
	 fname varchar2(50), --�����̸�
     fsize int --���Ͽ뷮
);


insert into Electronics values('NT900X4D-A68','�Ｚ����',1300000,'Windows 8','1111',sysdate,0,null,0); --sysdate�� ��¥
insert into Electronics values('SHV-E250S','Galaxy Note II',1000000,'Wi-Fi bluetooth 4.0','1111',sysdate,0,null,0);
insert into Electronics values('NT900X4D-A99S','�Ｚ����',1700000,'Windows 8','1111',sysdate,0,null,0);

select * from Electronics

 commit
 --------------------------------------------------
 --������̺� �ۼ��ϱ� ( �θ�� �Ѱ��� �������� ����� �ۼ��Ҽ� �ִ�)
create table replies(
  reply_num number primary key,
  reply_content varchar2(100) not null,
  reply_regdate date,
  parent_model_num varchar2(15) references electronics(model_num)
);

--��۹�ȣ���� ����� ������ ����
create sequence replies_num_seq;

--���÷��ڵ� �߰�
select * from electronics order by writeday desc;
--ex)  A45 �ۿ� ��� 3��
insert into replies values(replies_num_seq.nextval , 'A45 ù��° ���', sysdate , 'A45');
insert into replies values(replies_num_seq.nextval , 'A45 �ι�° ���', sysdate , 'A45');
insert into replies values(replies_num_seq.nextval , 'A45 ����° ���', sysdate , 'A45');

--ex) A13 �ۿ� ��� 2�� 
insert into replies values(replies_num_seq.nextval , 'A13 ù��° ���', sysdate , 'A13');
insert into replies values(replies_num_seq.nextval , 'A13 �ι�° ���', sysdate , 'A13');

commit

select * from replies;

--ex) �θ���� ��� ���� ��ȸ
select * from replies where parent_model_num='A13'
 


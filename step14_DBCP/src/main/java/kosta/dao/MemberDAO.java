package kosta.dao;

import java.util.List;

import kosta.dto.Member;

public interface MemberDAO {
	/**
	 * ��ü�˻�
	 * select * from member order by join_date desc
	 */
	List<Member> selectAll();
	
	/**
	 * ����ϱ�
	 * insert into member(id, pwd, name, age, addr, phone, join_date) values(?,?,?,?,?,?,sysdate)
	 */
	int insert(Member member);
	
	/**
	 * id �ߺ�üũ�ϱ�
	 * @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ� (������ �κ���) - select ��� 
	 * select id from member where id=?
	 */
	boolean duplicateCheckById(String id);
	
	/**
	 * �����ϱ�
	 * delete from member where id=?
	 */
	int delete(String id);
	
	/**
	 * �󼼺���
	 * select * from member where id=?
	 */
	Member selectById(String id);
	
	/**
	 * ���ǰ˻�
	 * (�˻��ʵ�� �˻��ܾ ���޹޾� �˻��ʵ忡 �˻��ܾ ������ ���ڵ带 �˻�)
	 * 
	 * ���ÿ� �ִ°� �ȵż� ���ε��� ���� �ֱ�(�������� ���� �̽�����)
	 * select * from member where ID like ?
	 * select * from member where name like ?
	 * select * from member where addr like ?
	 */
	List<Member> searchByKeyWord(String keyField, String keyWord);
}

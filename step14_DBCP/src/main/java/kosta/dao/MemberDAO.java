package kosta.dao;

import java.util.List;

import kosta.dto.Member;

public interface MemberDAO {
	/**
	 * 전체검색
	 * select * from member order by join_date desc
	 */
	List<Member> selectAll();
	
	/**
	 * 등록하기
	 * insert into member(id, pwd, name, age, addr, phone, join_date) values(?,?,?,?,?,?,sysdate)
	 */
	int insert(Member member);
	
	/**
	 * id 중복체크하기
	 * @return : true이면 중복, false이면 중복아님 (결정할 부분임) - select 사용 
	 * select id from member where id=?
	 */
	boolean duplicateCheckById(String id);
	
	/**
	 * 삭제하기
	 * delete from member where id=?
	 */
	int delete(String id);
	
	/**
	 * 상세보기
	 * select * from member where id=?
	 */
	Member selectById(String id);
	
	/**
	 * 조건검색
	 * (검색필드와 검색단어를 전달받아 검색필드에 검색단어를 포함한 레코드를 검색)
	 * 
	 * 동시에 넣는게 안돼서 따로따로 각각 넣기(넣으려면 보안 이슈생김)
	 * select * from member where ID like ?
	 * select * from member where name like ?
	 * select * from member where addr like ?
	 */
	List<Member> searchByKeyWord(String keyField, String keyWord);
}

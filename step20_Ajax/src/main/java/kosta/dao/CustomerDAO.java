package kosta.dao;

import java.util.List;

import kosta.dto.CustomerDTO;

public interface CustomerDAO {
	/**
	 * 아이디 중복체크
	 * */
	boolean idCheck(String id);
	
	/**
	 * Customer 등록하기
	 * */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * 전체 Customer 검색하기
	 * */
	List<CustomerDTO> selectAll();
	
	/**
	 * id에 해당하는 레코드 삭제하기
	 * */
	int delete(String id);
	
	/**
	 * id에 해당하는 레코드 수정하기
	 * */
	int update(CustomerDTO customerDTO);

}

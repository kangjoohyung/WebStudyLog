package kosta.mvc.dao;

import java.sql.SQLException;

import kosta.mvc.dto.UserDTO;

public interface UserDAO {
  /**
   * 로그인 기능
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * session사용해서 로그아웃 기능 따로 없음
   * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}

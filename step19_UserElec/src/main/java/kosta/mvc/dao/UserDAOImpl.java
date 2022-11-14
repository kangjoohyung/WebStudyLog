package kosta.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties proFile=new Properties(); //쿼리properties 불러오기위해 선언
	
	public UserDAOImpl() {
		try {
			//dbQuery를준비한 ~.properties파일을 로딩해서 Properties자료구조에 저장한다.
	
			//현재 프로젝트가 런타임(실행)될 때, 즉 서버가 실행될 대 classes폴더의 위치를 
			//동적으로 가져와서 경로를 설정해야한다.->리플렉션 개념 필요
			InputStream is=getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is); //new InputStream~~과거식으로 하면 오류남
			
			System.out.println("query.userlogin="+proFile.getProperty("query.userlogin"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		//외우기
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserDTO dbDTO=null;
		
		String sql=proFile.getProperty("query.userlogin");//select * from users where user_id=? and pwd=?
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			
			rs=ps.executeQuery();
			if(rs.next()) {
				dbDTO=new UserDTO(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO; //
	}

}

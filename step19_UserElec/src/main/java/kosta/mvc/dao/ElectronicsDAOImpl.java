package kosta.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.Electronics;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {
	private Properties proFile=new Properties(); //쿼리properties 불러오기위해 선언
	
	public ElectronicsDAOImpl() {
		try {
			//dbQuery를준비한 ~.properties파일을 로딩해서 Properties자료구조에 저장한다.
	
			//현재 프로젝트가 런타임(실행)될 때, 즉 서버가 실행될 대 classes폴더의 위치를 
			//동적으로 가져와서 경로를 설정해야한다.->리플렉션 개념 필요
			InputStream is=getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is); //new InputStream~~과거식으로 하면 오류남
			System.out.println("query.select="+proFile.getProperty("query.select"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Electronics> selectAll() throws SQLException {
		//외우기
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Electronics> list=new ArrayList<Electronics>();
		
		String sql=proFile.getProperty("query.select");//select * from Electronics order by 
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Electronics electronics=new Electronics(rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getInt(7), rs.getString(8), rs.getInt(9));
				
				list.add(electronics);
			}
				
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Electronics> getBoardList(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

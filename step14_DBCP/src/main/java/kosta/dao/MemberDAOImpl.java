package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.dto.Member;

public class MemberDAOImpl implements MemberDAO {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Member member=null;
	List<Member> list=new ArrayList<Member>();
	
	@Override
	public List<Member> selectAll() {
		
		String sql="select * from member order by join_date desc";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				member=new Member(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;		
		
	}

	@Override
	public int insert(Member member) {
		int result=0;
		String sql="insert into member(id, pwd, name, age, addr, phone, join_date) "
				+ "values(?,?,?,?,?,?,sysdate)";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, member.getId()); 
			ps.setString(2, member.getPwd()); 
			ps.setString(3, member.getName()); 
			ps.setInt(4, member.getAge()); 
			ps.setString(5, member.getAddr());
			ps.setString(6, member.getPhone());
			
			result=ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public boolean duplicateCheckById(String id) {
		boolean result=false;
		String sql="select id from member where id=?";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				result=true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public Member selectById(String id) { //Read.jsp에서 사용
		String sql="select * from member where id=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				member=new Member(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return member;
	}

	@Override
	public int delete(String id) {
		int result=0;
		String sql="delete from member where id=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public List<Member> searchByKeyWord(String keyField, String keyWord) {

		String sql="select * from member where ";
		
		try {
			switch(keyField) {//version1.7추가 (????)
			case "id": sql+="id like ?"; break;
			case "name": sql+="name like ?"; break;
			case "addr": sql+="addr like ?"; break;
			}
			System.out.println("sql="+sql); //테스트용-콘솔출력
			
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "%"+keyWord+"%");
			
			rs=ps.executeQuery();
			while(rs.next()) {
				member=new Member(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;		
	}

}

package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ElectronicsDAO;
import kosta.mvc.dao.ElectronicsDAOImpl;
import kosta.mvc.dto.Electronics;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public class ElectronicsServiceImpl implements ElectronicsService {
	private ElectronicsDAO elecDAO=new ElectronicsDAOImpl();
	@Override
	public List<Electronics> selectAll() throws SQLException {
		List<Electronics> list=elecDAO.selectAll();
		return list;
	}

	@Override
	public List<Electronics> selectAll(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Electronics electronics) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String modelNum, String password) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Electronics electronics) throws SQLException {
		// TODO Auto-generated method stub

	}

}

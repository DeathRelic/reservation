package cn.rsvsystem.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.rsvsystem.dao.IMemberDAO;
import cn.rsvsystem.service.IMemberService;
import cn.rsvsystem.vo.Action;
import cn.rsvsystem.vo.Member;
import cn.rsvsystem.vo.Role;
@Service
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDAO memberDAO;
	@Override
	public boolean insert(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Set<String> Ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(String mid) throws SQLException {
		// TODO Auto-generated method stub
		return memberDAO.doQuery(mid);
	}

	@Override
	public List<Member> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findBySplit(String keyWord, String columnName, int currentPage, int lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRoles(String mid) throws SQLException {
		return memberDAO.doQueryRoles(mid);
	}

	@Override
	public List<String> getActions(String mid) throws SQLException {
		// TODO Auto-generated method stub
		return memberDAO.doQueryActions(mid);
	}

}

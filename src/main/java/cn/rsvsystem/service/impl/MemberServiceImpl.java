package cn.rsvsystem.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.rsvsystem.dao.IMemberDAO;
import cn.rsvsystem.service.IActionService;
import cn.rsvsystem.service.IMemberService;
import cn.rsvsystem.service.IRoleService;
import cn.rsvsystem.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService {
	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMemberDAO memberDAO;
	@Resource
	private IActionService actionService;
	@Resource
	private IRoleService roleService;
	@Override
	public boolean insert(Member vo) throws SQLException {
		return false;
	}

	@Override
	public boolean delete(Set<String> Ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(String mid) throws SQLException {
		log.info("************************************query data****************************************");
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
	public Map<String, Object> listAuthByMember(String mid) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		map.put("allRoles",this.roleService.findRoleFlags(mid));
		map.put("allActions", this.actionService.findActionFlags(mid));
		return map;
	}

	@Override
	public int update(Member vo) throws SQLException {
		return memberDAO.doUpdate(vo);
	}


}

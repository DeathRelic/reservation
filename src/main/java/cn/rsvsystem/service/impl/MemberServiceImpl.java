package cn.rsvsystem.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.rsvsystem.dao.IActionDAO;
import cn.rsvsystem.dao.IMemberDAO;
import cn.rsvsystem.dao.IRoleDAO;
import cn.rsvsystem.service.IMemberService;
import cn.rsvsystem.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService {
	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMemberDAO memberDAO;
	@Resource
	private IActionDAO actionDAO;
	@Resource
	private IRoleDAO roleDAO;
	@Override
	public boolean insert(Member vo) throws SQLException {
		return false;
	}
	@Override
	public boolean updatePassword(String mid, String oldPwd, String newPwd) {
		try {
			Member vo = memberDAO.doQuery(mid);
			if (vo == null )
				return false;
			if (vo.getPassword().equals(oldPwd)) {
				vo.setPassword(newPwd);
				if (memberDAO.doUpdate(vo) >0)
					return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addMember(Member vo,Set<Integer> rid) {
		 boolean flag = false;
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			if (memberDAO.doCreate(vo)) {
				map.put("mid",vo.getMid());
				Iterator<Integer> iter = rid.iterator();
				while (iter.hasNext()){
					map.put("rid", iter.next());
					if (!memberDAO.doCreateMemberAndRole(map))
						return false;
				}
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
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
		map.put("allRoles",this.roleDAO.QueryRoleFlag(mid));
		map.put("allActions", this.actionDAO.QueryActionFlag(mid));
		return map;
	}

	@Override
	public int update(Member vo) throws SQLException {
		return memberDAO.doUpdate(vo);
	}
	

}

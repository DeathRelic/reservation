package cn.rsvsystem.service.impl;

import java.sql.SQLException;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.rsvsystem.dao.IRoleDAO;
import cn.rsvsystem.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IRoleDAO roleDAO;
	@Override
	public Set<String> findRoleFlags(String mid) throws SQLException {
		log.info("************************************query data****************************************");
		return roleDAO.QueryRoleFlag(mid);
	}

}

package cn.rsvsystem.service.impl;

import java.sql.SQLException;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.rsvsystem.dao.IActionDAO;
import cn.rsvsystem.service.IActionService;
@Service
public class ActionServiceImpl implements IActionService {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IActionDAO myActionDAO;
	@Override
	public Set<String> findActionFlags(String mid) throws SQLException {
		log.info("************************************query data****************************************");
		return myActionDAO.QueryActionFlag(mid);
	}

}

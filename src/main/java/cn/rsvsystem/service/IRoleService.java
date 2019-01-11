package cn.rsvsystem.service;

import java.sql.SQLException;
import java.util.Set;

public interface IRoleService {
	public Set<String> findRoleFlags(String mid) throws SQLException;
}

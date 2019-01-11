package cn.rsvsystem.dao;

import java.sql.SQLException;
import java.util.Set;


public interface IRoleDAO {
	public Set<String> QueryRoleFlag(String mid) throws SQLException;
}

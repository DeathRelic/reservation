package cn.rsvsystem.dao;

import java.sql.SQLException;
import java.util.Set;

public interface IActionDAO {
	public Set<String> QueryActionFlag(String mid) throws SQLException;
}

package cn.rsvsystem.service;

import java.sql.SQLException;
import java.util.Set;

public interface IActionService {
	public Set<String> findActionFlags(String mid) throws SQLException;
}

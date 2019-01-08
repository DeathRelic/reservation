package cn.rsvsystem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.rsvsystem.vo.Action;
import cn.rsvsystem.vo.Member;
import cn.rsvsystem.vo.Role;

public interface IMemberService {
	public boolean insert(Member vo) throws SQLException;
	public boolean delete(Set<String> Ids) throws SQLException;
	public Member find(String mid) throws SQLException;
	public List<Member> findAll() throws Exception;
	public List<Member> findBySplit(String keyWord,String columnName,int currentPage,int lineSize) throws SQLException;
	public List<String> getRoles(String mid) throws SQLException;
	public List<String> getActions(String mid) throws SQLException;
}

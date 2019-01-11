package cn.rsvsystem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.rsvsystem.vo.Action;
import cn.rsvsystem.vo.Member;
import cn.rsvsystem.vo.Role;

public interface IMemberDAO {
	public boolean doCreate(Member vo) throws SQLException;
	public boolean doDelete(Set<String> Ids) throws SQLException;
	public List<Member> doQueryAll() throws SQLException;
	public int doUpdate(Member vo) throws SQLException;
	public Member doQuery(String mid) throws SQLException;
	public boolean doQueryByPage(String keyWord,String columnName,int lineSize,int currentPage) throws Exception;
	public Map<String, Object> QueryAuths(String mid) throws SQLException;
	public boolean doCreateMemberAndRole(Map<String, Object> map) throws SQLException;
}

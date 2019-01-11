package cn.rsvsystem.shiro.realm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import cn.rsvsystem.service.IMemberService;
import cn.rsvsystem.util.PasswordEncrypt;
import cn.rsvsystem.vo.Member;
@Component
public class LoginRealm extends AuthorizingRealm {
	@Resource
	private IMemberService memberService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username =(String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		try {
			Map<String, Object> map = this.memberService.listAuthByMember(username);
			Set<String> roles = (Set<String>) map.get("allRoles");
			Set<String> actions = (Set<String>) map.get("allActions");
			info.setRoles(roles); 
			info.setStringPermissions(actions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username =(String) token.getPrincipal();
		String password = PasswordEncrypt.encryptPassword(new String((char[])token.getCredentials()));
		Member vo = new Member();
		try {
			vo = memberService.find(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (vo == null)
			throw new UnknownAccountException("Account Do Not Exist!");
		else {
			if (!vo.getPassword().equals(password))
				throw new IncorrectCredentialsException();
		}	
		return new SimpleAuthenticationInfo(username,password,this.getName());
	}

}

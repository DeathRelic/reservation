package cn.rsvsystem.shiro.filter;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;

import cn.rsvsystem.service.IMemberService;

public class CustomUserFilter extends UserFilter {
	@Resource
	private IMemberService memberService;
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated() && subject.isRemembered()) {
			Session session = subject.getSession(true);
			if (session.getAttribute("name") == null) {
				String mid = subject.getPrincipal().toString();
				try {
					String name = memberService.find(mid).getName();
					Map<String, Object> map = memberService.listAuthByMember(mid);
					Set<String> roles =(Set<String>) map.get("allRoles");
					Set<String> perms =(Set<String>) map.get("allActions");
					session.setAttribute("name", name);
					session.setAttribute("roles", roles);
					session.setAttribute("perms", perms);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}
}

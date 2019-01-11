package cn.rsvsystem.shiro.filter;



import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import cn.rsvsystem.service.IMemberService;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Resource
	private IMemberService myService;
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String code = req.getParameter("code");
		String rand = (String) req.getSession().getAttribute("rand");
		if (code == null || "".equals(code)) {
			req.setAttribute("code", "验证码为空");
			return true;
		} else if (!code.equalsIgnoreCase(rand)) {
			req.setAttribute("code", "验证码错误");
			return true;
		}
		return super.onAccessDenied(request, response);
	}
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String mid =(String) token.getPrincipal();
		String name = myService.find(mid).getName();
		req.getSession().setAttribute("name", name);
		return super.onLoginSuccess(token, subject, request, response);
	}
}

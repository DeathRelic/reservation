package cn.rsvsystem.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String code = req.getParameter("code");
		String rand = (String) req.getSession().getAttribute("rand");
		if (code == null || "".equals(code)) {
			req.setAttribute("code", "输入的验证码为空");
			return true;
		} else if (!code.equalsIgnoreCase(rand)) {
			req.setAttribute("code", "输入的验证码有误");
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}

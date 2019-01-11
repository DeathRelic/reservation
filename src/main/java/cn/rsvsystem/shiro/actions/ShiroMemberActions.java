package cn.rsvsystem.shiro.actions;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.rsvsystem.util.actions.AbstractAction;
@Controller
public class ShiroMemberActions extends AbstractAction{
	
	@RequestMapping("/loginUrl")
	public ModelAndView loginUrl() {
		String pageName = super.getValue("shiro.loginUrl.page");
		return new ModelAndView(pageName);
	}
	@RequestMapping("/logoutUrl")
	@RequiresUser
	public ModelAndView logoutUrl() {
		ModelAndView mav = new ModelAndView(super.getValue("shiro.logoutUrl.page"));
		super.setMsgAndUrl(mav, "shiro.logout.message", "forward.index.redirect.page");
		SecurityUtils.getSubject().logout();
		return mav;
	}
	@RequestMapping("/successUrl")
	public ModelAndView successUrl() {
		String pageName = super.getValue("shiro.successUrl.page");
		return new ModelAndView(pageName);
	}
	@RequestMapping("/unauthUrl")
	public ModelAndView unauthUrl() {
		String pageName = super.getValue("shiro.unauthUrl.page");
		return new ModelAndView(pageName);
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileUploadDir() {
		// TODO Auto-generated method stub
		return null;
	}

}

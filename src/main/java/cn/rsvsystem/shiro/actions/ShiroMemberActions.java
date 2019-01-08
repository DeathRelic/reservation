package cn.rsvsystem.shiro.actions;

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
	@RequestMapping("/index")
	public ModelAndView index() {
		String pageName = super.getValue("index.page");
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

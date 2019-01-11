package cn.rsvsystem.actions.front;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.rsvsystem.util.actions.AbstractAction;
@Controller
public class IndexAction extends AbstractAction {
	@RequestMapping("/news_list")
	public ModelAndView newslist() {
		return new ModelAndView(super.getValue("front.new_list.page"));
	}
	@RequestMapping("/index")
	public ModelAndView index() {
		String pageName = super.getValue("index.page");
		return new ModelAndView(pageName);
	}
	@RequestMapping("/reserve")
	public ModelAndView reserve() {
		return new ModelAndView(super.getValue("front.bespeak_add.page"));
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

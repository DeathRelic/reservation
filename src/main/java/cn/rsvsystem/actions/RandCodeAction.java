package cn.rsvsystem.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.rsvsystem.util.actions.AbstractAction;
@Controller
public class RandCodeAction extends AbstractAction {
	@RequestMapping("/CheckCode")
	public ModelAndView CheckRandCode(String code,HttpServletRequest request,HttpServletResponse response) {
		String rand = (String) request.getSession().getAttribute("rand");
		if (rand == null || "".equals(rand)) {
			super.print(response, false);
			return null;
		} 
		if (code == null || "".equals(code)) {
			super.print(response, false);
			return null;
		}
		super.print(response, code.equalsIgnoreCase(rand));
		return null;

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

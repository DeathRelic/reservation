package cn.rsvsystem.actions.back;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.rsvsystem.service.IMemberService;
import cn.rsvsystem.util.PasswordEncrypt;
import cn.rsvsystem.util.actions.AbstractAction;
import cn.rsvsystem.vo.Member;

@Controller
@RequestMapping("/back/*")
public class BackgroundActions extends AbstractAction{
	@Resource
	private IMemberService memberService;
	@RequiresUser
	@RequestMapping("index")
	public ModelAndView back_index() {
		String pageName = super.getValue("back.index.page");
		return new ModelAndView(pageName);
	}
	@RequestMapping("password")
	@RequiresAuthentication
	public ModelAndView changePassword() {
		ModelAndView mav = new ModelAndView(super.getValue("back.password.page"));
		return mav;
	}
	@RequestMapping("pwdChange")
	@RequiresAuthentication
	public ModelAndView pwdChange(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.redirect.page"));
		String mid =(String) SecurityUtils.getSubject().getPrincipal();
		String enc_oldPwd = PasswordEncrypt.encryptPassword(request.getParameter("oldpassword"));
		String enc_newPwd = PasswordEncrypt.encryptPassword(request.getParameter("newpassword"));
		try {
			Member vo = memberService.find(mid);
			if (enc_oldPwd.equals(vo.getPassword())) {
				vo.setPassword(enc_newPwd);
				if (memberService.update(vo)>0) {
					super.setMsgAndUrl(mav, "back.pwdChange.success", "back.index.redirect.page");
				}else {
					super.setMsgAndUrl(mav, "back.pwdChange.failure", "back.index.redirect.page");
				}
			} else {
				super.setMsgAndUrl(mav, "back.pwdChange.wrong", "back.index.redirect.page");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
	@Override
	public String getType() {
		return null;
	}

	@Override
	public String getFileUploadDir() {
		return null;
	}
}

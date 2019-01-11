package cn.rsvsystem.actions.back;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
	@RequestMapping("account")
	@RequiresRoles("member")
	@RequiresPermissions("member:add")
	public ModelAndView addAccount() {
		ModelAndView mav = new ModelAndView(super.getValue("back.account.page"));
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
			if (memberService.updatePassword(mid, enc_oldPwd, enc_newPwd)) {
				super.setMsgAndUrl(mav, "back.pwdChange.success", "back.index.redirect.page");
			}else {
				super.setMsgAndUrl(mav, "back.pwdChange.failure", "back.index.redirect.page");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("addMember")
	@RequiresPermissions("member:add")
	public ModelAndView addMember(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.redirect.page")) ;
		Member vo = super.getMember(request);
		Set<Integer> rid = super.getValues(request, "rid");
		try {
			if (memberService.addMember(vo, rid)) {
				super.setMsgAndUrl(mav, "back.addMember.success", "back.index.redirect.page");
			} else {
				super.setMsgAndUrl(mav, "back.addMember.failure", "back.index.redirect.page");
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

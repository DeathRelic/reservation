package cn.rsvsystem.util.actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.rsvsystem.util.PasswordEncrypt;
import cn.rsvsystem.util.file.UploadFileUtil;
import cn.rsvsystem.util.split.SplitPageUtil;
import cn.rsvsystem.vo.Member;

public abstract class AbstractAction {

	public Set<Integer> getBatchIds(HttpServletRequest request) {
		Set<Integer> set = new HashSet<Integer>() ;
		String ids = request.getParameter("ids") ;
		String result [] = ids.split("\\|") ;
		for (int x = 0 ; x < result.length ; x ++) {
			set.add(Integer.parseInt(result[x])) ;
		}
		return set ;
	}
	public Set<Integer> getValues(HttpServletRequest request,String param){
		Set<Integer> set = new HashSet<Integer>();
		String val[] = request.getParameterValues(param);
		if (val.length<0)
			return null;
		for (int x=0;x<val.length;x++) {
			if (val[x].matches("\\d+"))
				set.add(Integer.parseInt(val[x]));
		}
		return set;
	}
	public Member getMember(HttpServletRequest request) {
		Member vo = new Member();
		String sflag = request.getParameter("sflag");
		vo.setMid(request.getParameter("mid"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(PasswordEncrypt.encryptPassword(request.getParameter("password")));
		vo.setRegdate(new Date());
		if (sflag.matches("\\d")) {
			vo.setSflag(Integer.parseInt(sflag));
		} else {
			vo.setSflag(0);
		}
		vo.setLocked(0);
		return vo;
	}

	public void handleSplit(ModelAndView mav, Object allRecorders, String columnData, String urlKey,
			SplitPageUtil spu) {
		mav.addObject("allRecorders", allRecorders);
		mav.addObject("columnData", columnData);
		mav.addObject("column", spu.getColumn());
		mav.addObject("url", this.getValue(urlKey));
		mav.addObject("keyWord", spu.getKeyWord());
		mav.addObject("currentPage", spu.getCurrentPage());
		mav.addObject("lineSize", spu.getLineSize());
	}

	public Set<Integer> getSetByInteger(HttpServletRequest request, String param) {
		Set<Integer> all = new HashSet<Integer>();
		String values[] = request.getParameterValues(param);
		for (int x = 0; x < values.length; x++) {
			if (values[x].matches("\\d+")) {
				all.add(Integer.parseInt(values[x]));
			}
		}
		return all;
	}


	public String getMid() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}

	public void logout() {
		SecurityUtils.getSubject().logout();
	}


	public void setMsgAndUrl(ModelAndView mav, String msgKey, String urlKey) {
		if (this.getType() == null) {
			mav.addObject("msg", this.getValue(msgKey));
		} else {
			mav.addObject("msg", this.getValue(msgKey, this.getType()));
		}
		mav.addObject("url", this.getValue(urlKey));
	}


	public void print(HttpServletResponse response, Object value) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String createFileName(MultipartFile photo) {
		if (photo.isEmpty()) {
			return "nophoto.gif"; 
		} else { 
			return UploadFileUtil.createFileName(photo.getContentType());
		}
	}


	public abstract String getType();


	public boolean saveFile(MultipartFile photo, String fileName, HttpServletRequest request) {
		if (!photo.isEmpty()) {
			String filePath = request.getServletContext().getRealPath(this.getFileUploadDir()) + fileName;
			try {
				return UploadFileUtil.save(photo.getInputStream(), new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public abstract String getFileUploadDir();

	@Resource
	private MessageSource msgSource; 


	public String getValue(String msgKey, Object... args) {
		return this.msgSource.getMessage(msgKey, args, Locale.getDefault());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}

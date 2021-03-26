package kr.co.softsoldesk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softsoldesk.beans.UserBean;

@Controller
public class HomeController {
	
	//이름+오토와이어드
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home() {
		//return "/WEB-INF/views/index.jsp";
		
		//return "index"였는데 바꾸겠다. 
		return "redirect:/main";
	}
}
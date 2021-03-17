package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home() {
		//return "/WEB-INF/views/index.jsp";
		
		//return "index"였는데 바꾸겠다. 
		return "redirect:/main";
	}
}
package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		
		return "user/login";
	}
	
	

	@GetMapping("/logout")
	public String logout() {
		
		return "user/logout";
	}
	
	

	@GetMapping("/modify_user")
	public String modify_user() {
		
		return "user/modify_user";
	}
	
	

	@GetMapping("/join")
	public String join() {
		
		return "user/join";
	}
	
	
	
	
}

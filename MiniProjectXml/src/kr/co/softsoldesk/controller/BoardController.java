package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")//이 컨트롤러에서는 /board를 고정해서 받음
public class BoardController {

	@GetMapping("/main")
	public String main() {
		
		return "board/main";
	}
	
	
	@GetMapping("/read")
	public String read() {
		
		return "board/read";
	}
	
	
	@GetMapping("/write")
	public String write() {
		
		return "board/write";
	}
	
	@GetMapping("/modify")
	public String modify() {
		
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		return "board/delete";
	}
}

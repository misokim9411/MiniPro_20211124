package kr.co.softsoldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softsoldesk.beans.ContentBean;

@Controller
@RequestMapping("/board")//이 컨트롤러에서는 /board를 고정해서 받음
public class BoardController {

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,Model model) {
		
		model.addAttribute("board_info_idx",board_info_idx);
		return "board/main";
	}
	
	
	@GetMapping("/read")
	public String read() {
		
		return "board/read";
	}
	
	
	//===========================================
	/*보드컨트롤러에서 이제는, 글쓴것을 가지고 board의 write.jsp로 가야하므로 모델끌고가서 뷰단에서 폼폼써야한다
	 * ----글쓰기에서 사용하는 빈은 ContentBean*/
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean) {
		
		return "board/write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean,BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "board/write";
		}
		
		
		return "board/write_success";
	}
	
	
	
	//===============================
	@GetMapping("/modify")
	public String modify() {
		
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		return "board/delete";
	}
}

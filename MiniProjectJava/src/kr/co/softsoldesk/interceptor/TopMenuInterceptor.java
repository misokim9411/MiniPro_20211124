package kr.co.softsoldesk.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softsoldesk.beans.BoardInfoBean;
import kr.co.softsoldesk.beans.UserBean;
import kr.co.softsoldesk.service.TopMenuService;

//인터셉터 사용시 : 핸들러인터셉터 인터페이스 구현
//서블릿 조작후, return true 해줘야 돌아간다!
public class TopMenuInterceptor implements HandlerInterceptor {

	//서블릿에서 Autowired해놨으므로 바로 쓸 수 있다. 
	private TopMenuService topMenuService;
	
	private UserBean loginUserBean;
	
	/*Iterceptor에 loginUseBean 올려놓고, 유저빈의 userLogin 변수의 변화상태를 계속 체크하는 방향으로 이용가능.
	//로그인 상태인지 아닌지 확인하기 위한 변수
	//로그인하지 않은 상태이므로 초기값은 false로 커스텀 생성자에 세팅
	private boolean userLogin; */
	
	
	
	//@Autowired를 쓴게아니므로 생성자에서 세팅해야한다. 
	public TopMenuInterceptor(TopMenuService topMenuService,UserBean loginUserBean) {
		this.topMenuService=topMenuService;
		this.loginUserBean=loginUserBean;
	}
	
	//처음들어와서 컨트롤러로 주소찾기 전까지 작동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//서비스에서 넘어온 board_info 테이블의 빈들이 담긴 리스트를 받아서, request에 붙여야 인터셉트해서 들어간다. 
		List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		
		
		
		return true;
	}

	
	
}

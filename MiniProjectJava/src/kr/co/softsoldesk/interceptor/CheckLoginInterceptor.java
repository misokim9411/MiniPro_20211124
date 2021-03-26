package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softsoldesk.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	//새로운 인터셉터의 등장! ---> 서블릿에 인터셉터 등록필요함!
	
	//예를들어, http://localhost:9021/MiniProjectJava/user/modify_user를 하면 로그인하지 않은 상태에서도 접근되기때문에, 
	//로그인상태에서만 개인정보페이지 등에 접근가능하도록 잠가놔야한다.---->return을 false로 해서 흐름제어하면됨!!!!
	
	//1) 로그인 여부를 판단해야함 : loginUserBean 객체 주입 필요. 여기서 생성자만들고 서블릿에서 주입.
	
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
	   this.loginUserBean=loginUserBean;
	}
	
	
	//2) preHandler로 로그인상태 판단.
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인이 되어있지 않으면 흐름끊기.
		if(loginUserBean.isUserLogin()==false) {
			//로그인전, 로그인되지않은 현상태의 경로를 잡아와서 저장
			//ex) 로그인 실패시 ?fail=true 같은식으로 찍힘
           String contextPath=request.getContextPath();
           
           //로그인 처리가 안되어 있으므로, 로그인을 안했다고 알려주는 not_login.jsp로 페이지전환하려고 주소바꿔서요청(sendRedirect)
           response.sendRedirect(contextPath+"/user/not_login");
           //일단, 요청주소에 user가 들어가기때문에, UserController로 또 들어간다. 컨트롤러에서 본격적으로 not_login으로 보내줄것.
           
           return false;//흐름을 끊어서 다음단계로 이동하지 않음 
		}
		
		//else로 로그인이 되어있는 상태이면 흐름계속됨.
		return true;
		
		
		
		
	}
	
	

}

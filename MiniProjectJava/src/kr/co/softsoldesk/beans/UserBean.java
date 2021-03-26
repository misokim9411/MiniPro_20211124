package kr.co.softsoldesk.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	//유효성 검사가 가능한 빈이되었음. 컨트롤러에도 모델앞에 @Valid표현해주면된다
	
	private int user_idx;
	
	@Size(min=2, max=4)
	@Pattern(regexp="[가-힣]*")//한글만 가능하도록 정규식
	private String user_name;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")//영어대소문자,숫자만 가능하도록 정규식. 섞으라고한건아님
	private String user_id;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String user_pw2; //pw2는 ajax로 얻어올것이므로 테이블에는 없다
	
	
	//=============================
	
	//hidden으로 뷰로 넘길 userIdExist. false를 생성자로 초기값으로 주고, 뷰단에서 통신해보고 결과를 판단하겠다.
	//여기에는 유효성검사가 적용안되었으므로, 사용자정의로 Validator에서 정의해줘야한다. 물론, 프로퍼티에도 설정해야함.
	private boolean userIdExist;
	


	//Iterceptor에 올려놓고, 이 변수의 변화상태를 계속 체크하는 방향으로 이용가능.
	//로그인 상태인지 아닌지 확인하기 위한 변수
	//로그인하지 않은 상태이므로 초기값은 false로 커스텀 생성자에 세팅
	private boolean userLogin; 
	
	
	
	
	//=========== 초기값 설정하는 커스텀 생성자 =============
	
	public UserBean() {
		this.userIdExist=false;
		this.userLogin=false;
	}
	
	
	
	//===============================
	
	

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}

	
	
	
	

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	
}

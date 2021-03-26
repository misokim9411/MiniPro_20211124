package kr.co.softsoldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softsoldesk.beans.UserBean;

public interface UserMapper {

	@Select("select user_name "
			+ "from user_table "
			+ "where user_id=#{user_id}")
	String checkUserIdExist(String user_id);
	
	//메서드 위에 어노테이션을 올린형태이고, 메서드를 호출할 때 매개변수로 들어온 user_id가 #형태로 쿼리문에 삽입
     
	//이 맵퍼를 DAO로 넘겨 사용하기위해, 서블릿에 설정 필요하다.

	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) "
			+ "values (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	
	
	//user_id와 user_pw는 세션으로 떠다니고있는것을 집어넣어 활용한다. 
	//jdbcType오류시, int일때는 NUMERIC으로 설정하면됨. 
	@Select("select user_idx, user_name "
			+ "from user_table "
			+ "where user_id=#{user_id,jdbcType=VARCHAR} and user_pw=#{user_pw,jdbcType=VARCHAR}")
	UserBean getLoginUserInfo(UserBean temploginUserBean);
	
	
	//로그인된 상태에서, 수정하는 것이므로 세팅된것이 있어서 세팅된 idx 정보를 where절에 사용가능하다
	//loginUserBean에 세팅한 이름과 idx를 기준으로 불러오자. 
	@Select("select user_name, user_id "
			+ "from user_table "
			+ "where user_idx=#{user_idx} ")
	UserBean getModifyUserInfo(int user_idx);
	
	
	
	//물고들어온 modifyUserBean에서, user_idx 찾아다가 sql문 돌려서 업데이트만 하면 되므로, 반환값없음.
	@Update("update user_table "
			+ "set user_pw=#{user_pw,jdbcType=VARCHAR} "
			+ "where user_idx=#{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
	
	

	
}

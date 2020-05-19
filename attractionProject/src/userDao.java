import java.util.List;

public interface userDao {
	// 관리자 제외하고 유저 관리 목록 불러오기 - manager_myInfo.jsp
	public List<user> all(String s);
	
	// 관리자 페이지에서 유저 삭제기능 - manager_myInfo.jsp
	public int del(int userID);

	// 회원가입 - signup.jsp
	public int add(user u);
	
	// 로그인 - login.jsp
	public int lo(user u);
}

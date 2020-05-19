import java.util.List;

public interface attractionDao {
	// 예약 추가 - reserve.jsp
	public int add(attraction u);

	// 예약 삭제 - myInfo.jsp
	public int del(attraction u);

	// 아이디로 놀이기구 예약정보 가져오기 - myInfo.jsp
	public List<attraction> byuserIDName(String userIDName);
}
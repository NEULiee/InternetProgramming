import java.util.List;

public interface boardDao {
	// 게시글 작성 - board_write.jsp
	public int add(board b);

	// 게시글 삭제 - manager_board.jsp
	public int del(Integer boardID);

	// 게시글 모두 가져오기 - board.jsp, manager_board.jsp
	public List<board> selectAll();

	// 클릭한 게시글 가져오기 - board_text.jsp
	public board byboardID(Integer boardID);

	// 검색한 게시글 가져오기 - board.jsp
	public List<board> selectSearch(String search);
	
	public int upd(board b);
}

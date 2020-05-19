import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class boardServlet extends HttpServlet {
	userDao ud = new userDaoImpl();
	attractionDao ad = new attractionDaoImpl();
	boardDao bd = new boardDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		// 게시글 삭제
		if (type.equals("del")) {
			doDel(request, response);
		}
		// 게시글 작성버튼 눌렀을 때
		else if (type.equals("add")) {
			doAdd(request, response);
		}
		// 게시글 전체 가져오기
		else if (type.equals("all")) {
			doAll(request, response);
		}
		// 관리자 게시글 전체 가져오기
		else if (type.equals("mall")) {
			domAll(request, response);
		}
		// 게시글 불러오기
		else if (type.equals("byboardID")) {
			dobyboardID(request, response);
		}
		// 게시글 검색
		else if (type.equals("search")) {
			dosearch(request, response);
		}
		// 게시글 수정
		else if (type.equals("upd")) {
			doupd(request, response);
		}
		else if (type.equals("modi")) {
			domodi(request, response);
		}
	}

	private void doupd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer boardID = Integer.parseInt(request.getParameter("bID"));
		String userIDName = (String) request.getSession().getAttribute("userIDName");
		String title = request.getParameter("title");
		String memo = request.getParameter("memo");
		board updB = new board();
		updB.setboardID(boardID);
		updB.setuserIDName(userIDName);
		updB.settitle(title);
		updB.setmemo(memo);
		
		int n = bd.upd(updB);
		try {
			if (n > 0) {
				request.getRequestDispatcher("manager_main_Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = (String) request.getParameter("search");

		List<board> bli = bd.selectSearch(search);
		request.setAttribute("bli", bli);

		request.getRequestDispatcher("board.jsp").forward(request, response);

	}

	private void dobyboardID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer boardID = Integer.parseInt(request.getParameter("boardID"));
		board b = bd.byboardID(boardID);
		request.setAttribute("title", b.gettitle());
		request.setAttribute("m", b.getmemo());
		request.getRequestDispatcher("board_text.jsp").forward(request, response);
	}
	
	private void domodi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer boardID = Integer.parseInt(request.getParameter("boardID"));
		board b = bd.byboardID(boardID);
		request.setAttribute("boardID", b.getboardID());
		request.setAttribute("title", b.gettitle());
		request.setAttribute("m", b.getmemo());
		request.getRequestDispatcher("board_upd.jsp").forward(request, response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<board> bli = bd.selectAll();
		request.setAttribute("bli", bli);

		request.getRequestDispatcher("board.jsp").forward(request, response);
	}

	private void domAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<board> bli = bd.selectAll();
		request.setAttribute("bli", bli);

		request.getRequestDispatcher("manager_board.jsp").forward(request, response);
	}

	public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session으로 userIDName 가져오기
		String userIDName = (String) request.getSession().getAttribute("userIDName");
		String title = request.getParameter("title");
		String memo = request.getParameter("memo");

		board newBoard = new board();
		newBoard.setuserIDName(userIDName);
		newBoard.settitle(title);
		newBoard.setmemo(memo);

		int n = bd.add(newBoard);
		try {
			if (n > 0) {
				request.getRequestDispatcher("main_Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer boardID = Integer.parseInt(request.getParameter("boardID"));

		int n = ud.del(boardID);
		try {
			if (n > 0) {
				request.getRequestDispatcher("manager_main_Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
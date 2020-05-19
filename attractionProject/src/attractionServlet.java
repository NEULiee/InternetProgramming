import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class attractionServlet extends HttpServlet {
	userDao ud = new userDaoImpl();
	attractionDao ad = new attractionDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		// 삭제 - myInfo.jsp
		if (type.equals("del")) {
			doDel(request, response);
		}
		// 예약 - reserve.jsp
		else if (type.equals("add")) {
			doAdd(request, response);
		}
		// 예약목록 - reserve.jsp
		else if (type.equals("byuserIDName")) {
			dobyuserIDName(request, response);
		}
	}

	public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session으로 userIDName 가져오기
		String userIDName = (String) request.getSession().getAttribute("userIDName");
		String attractionName = request.getParameter("attractionName");
		Integer people = Integer.parseInt(request.getParameter("people"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));

		attraction newReserve = new attraction();
		newReserve.setuserIDName(userIDName);
		newReserve.setattractionName(attractionName);
		newReserve.setpeople(people);
		newReserve.setmonth(month);
		newReserve.setday(day);

		int n = ad.add(newReserve);
		try {
			if (n > 0) {
				request.getRequestDispatcher("main_Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session으로 userIDName 가져오기
		String userIDName = (String) request.getSession().getAttribute("userIDName");
		String attractionName = request.getParameter("attractionName");
		Integer people = Integer.parseInt(request.getParameter("people"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));

		attraction delReserve = new attraction();
		delReserve.setuserIDName(userIDName);
		delReserve.setattractionName(attractionName);
		delReserve.setpeople(people);
		delReserve.setmonth(month);
		delReserve.setday(day);

		int n = ad.del(delReserve);
		if (n > 0) {
			request.getRequestDispatcher("main_Login.jsp").forward(request, response);
		}
	}

	// myInfo.jsp 에서 예약정보 보여주기
	public void dobyuserIDName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userIDName = (String) request.getSession().getAttribute("userIDName");
		List<attraction> li = ad.byuserIDName(userIDName);
		request.setAttribute("li", li);

		request.getRequestDispatcher("myInfo.jsp").forward(request, response);
	}
}
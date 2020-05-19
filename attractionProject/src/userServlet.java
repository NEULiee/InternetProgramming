import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class userServlet extends HttpServlet {
	userDao ud = new userDaoImpl();
	attractionDao cd = new attractionDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		if (type.equals("all")) {
			doAll(request, response);
		} else if (type.equals("del")) {
			doDel(request, response);
		} else if (type.equals("add")) {
			doAdd(request, response);
		} else if (type.equals("lo")) {
			dlLo(request, response);
		}
	}

	private void dlLo(HttpServletRequest request, HttpServletResponse response) {
		String userIDName = request.getParameter("userIDName");
		String password = request.getParameter("password");

		user loUser = new user();
		loUser.setuserIDName(userIDName);
		loUser.setpassword(password);

		int n = ud.lo(loUser);
		try {
			if (n == 1) {
				// session 전달
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("userIDName", userIDName);

				if (loUser.getuserIDName().equals("a") && loUser.getpassword().equals("1234")) {
					request.getRequestDispatcher("manager_main_Login.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("main_Login.jsp").forward(request, response);
				}
			} else if (n == 0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIDName = request.getParameter("userIDName");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");

		user newUser = new user();
		newUser.setuserIDName(userIDName);
		newUser.setpassword(password);
		newUser.setuserName(userName);

		int n = ud.add(newUser);
		try {
			if (n > 0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userID = Integer.parseInt(request.getParameter("userID"));

		int n = ud.del(userID);
		try {
			if (n > 0) {
				request.getRequestDispatcher("manager_main_Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIDName = (String) request.getSession().getAttribute("userIDName");
		List<user> uli = ud.all(userIDName);
		request.setAttribute("uli", uli);

		request.getRequestDispatcher("manager_myInfo.jsp").forward(request, response);
	}
}
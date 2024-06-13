package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.*;
import model.User;
import util.MaHoa;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		password=MaHoa.toSHA1(password);

		HttpSession session = request.getSession(true);
		UserDAO userDao = new UserDAO();
		
		User checkUser = userDao.login(user, password);
		if ( checkUser == null)
		{
		System.out.println();
		userDao.addUser(new User (userDao.IndexOfUser() + 1,user, password,"",userDao.generateRandomPhoneNumber(), 0,"",""));
		response.sendRedirect("login.jsp");
		}
		else
		{
			session.setAttribute("DKMessage", "Tài khoản đã tồn tại!.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}

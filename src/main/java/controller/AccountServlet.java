package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/Account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		HttpSession session = request.getSession();
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone   = request.getParameter("phone");
		
		UserDAO usD  = new UserDAO();	
		int ID  = usD.getUserIdByUsernameAndPassword(username, password);
		System.out.println("username" + username + "password " + password + "address " + address + " phone" + phone + "userId" + ID);
		usD.getUserIdByUsernameAndPassword(username, password);
		usD.updateUser(new  User(ID, username,password,address,phone,0));
		System.out.println("Update thanh cong");
		session.setAttribute("message", "Cập nhật thành công!");
		
		response.sendRedirect("Account.jsp");
	}

}

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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		System.out.println("hello");
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(username + password);
		
		
		UserDAO userD = new UserDAO();
		User user = userD.login(username, password);
		String a = "Chưa có tài khoản";
		int ID  = userD.getUserIdByUsernameAndPassword(username, password);
		
		 if (user == null) {
			 	String errorMessage = "Tên người dùng hoặc mật khẩu không chính xác.";
	            session.setAttribute("errorMessage", errorMessage);
	            session.setAttribute("username", "Tài khoản"); 
	            request.getRequestDispatcher("login.jsp").forward(request, response);;
            } else {
            	
            	System.out.println("Trong loginServlet");
            	
            	session.setAttribute("userID", ID);
            	session.setAttribute("username", username); 
                session.setAttribute("password", password);
                // session.removeAttribute("errorMessage");
                
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
		 session.removeAttribute("errorMessage");
	}
	
	
}

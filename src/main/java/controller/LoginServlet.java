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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LO gin ser v let");
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
		//System.out.println(username + password);
		password=MaHoa.toSHA1(password);
		
		UserDAO userD = new UserDAO();
		User user = userD.login(username, password);
		String a = "Chưa có tài khoản";
		System.out.println(user);

		int ID  = userD.getUserIdByUsernameAndPassword(username, password);
		User user1= userD.getUserById(ID);
		System.out.println(user1 );

	
		 if (user == null) {
			 System.out.println("ưhqeqw");
			 	String errorMessage = "Tên người dùng hoặc mật khẩu không chính xác.";
	            session.setAttribute("errorMessage", errorMessage);
	            session.setAttribute("username", "Tài khoản"); 
	            request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
            	
            	System.out.println("Trong loginServlet");
            	UserEmailDAO uss = new UserEmailDAO();
            	UserDetailDao udđ = new UserDetailDao();
            	String address=user.getAddress();
        		System.out.println(address);
            	session.setAttribute("userID", ID);
            	session.setAttribute("username", username); 
                session.setAttribute("password", password);
                session.setAttribute("UserAddress", user1.getAddress());
                session.setAttribute("UserPhone", user1.getuPhone());
                session.setAttribute("UserEmail", uss.getEmail(ID));
                session.setAttribute("roleUser", user1.getRole());
                session.setAttribute("FullName", udđ.getFullName(ID));
				System.out.println(user1.getuPhone());
                // session.removeAttribute("errorMessage");
                
                response.sendRedirect("home");
            }
		 session.removeAttribute("errorMessage");
	}
	
	
}

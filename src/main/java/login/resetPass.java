package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserEmailDAO;
import util.MaHoa;

/**
 * Servlet implementation class resetPass
 */
@WebServlet("/resetPass")
public class resetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPass() {
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
		String pass = request.getParameter("password");
		System.out.println("Mật khẩu vừa nhập là " + pass);
		pass=MaHoa.toSHA1(pass);
		UserEmailDAO uED = new UserEmailDAO();
		UserDAO uD = new UserDAO();
		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("Tồn tại email");
		    String email = "trannhattan410@gmail.com";
		    int a = uED.EmailCheck(email);
		    System.out.println("a +++ " + a);
		    uD.changePass(a, pass);
		    request.setAttribute("error", "Thay đổi mật khẩu thành công");
            request.getRequestDispatcher("login.jsp").forward(request, response);
		    
		} else {
		    System.out.println("Sesion không tồn tại ");
		}
	}

}

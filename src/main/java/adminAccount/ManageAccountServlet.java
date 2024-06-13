package adminAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDetail;
import repository.*;

/**
 * Servlet implementation class ManageAccount
 */
@WebServlet("/manageaccount")
public class ManageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		UserDAO userDao= new UserDAO();
		List<model.User> allAccount = userDao.getAllAccount();
		UserDetailDao userDetailDao = new UserDetailDao();
		List<Integer> list = userDetailDao.getIdByUserDetail();
		
		List<UserDetail> listUserDetail = userDetailDao.getUserDetailList();
		
		List<UserDetail> listKhoa = new ArrayList<>();
		
		for (UserDetail userDetail : listUserDetail) {
			if (list.contains(userDetail.getUserId())) listKhoa.add(userDetail);
		}
		session.setAttribute("listUserDetail", listKhoa);
		session.setAttribute("ListUser", allAccount);
		
        request.getRequestDispatcher("CustomerManage.jsp").forward(request, response);
        
	}

	@Override
	/*
	 * protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
	 * throws ServletException, IOException { // TODO Auto-generated method stub
	 * UserDAO userDao= new UserDAO(); String tam=req.getParameter("useId");
	 * //req.get System.out.println("xoa goi nha"+tam);
	 * 
	 * userDao.deleteUser(tam); System.out.println("xoa goi nha"+tam);
	 * //resp.sendRedirect("manageaccount"); }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

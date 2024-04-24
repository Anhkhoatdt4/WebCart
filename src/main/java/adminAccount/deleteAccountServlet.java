package adminAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.CartDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.UserDAO;
import dao.UserDetailDao;

/**
 * Servlet implementation class deleteAccountServlet
 */
@WebServlet("/deleteAccount")
public class deleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAccountServlet() {
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonData = "";
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData += line;
        }
         reader.close();

         
         JSONObject jsonObject = new JSONObject(jsonData);
         int cartID = jsonObject.getInt("ID");
		 
		 UserDetailDao a = new UserDetailDao();
		 a.updateDeleted(cartID);
		 

		 JSONObject jsonResponse = new JSONObject();
		 jsonResponse.put("message", "Xóa tài khoản thành công");

		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(jsonResponse.toString());
	}

}

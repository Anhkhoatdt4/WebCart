package adminAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.*;
import model.User;
import model.UserDetail;

/**
 * Servlet implementation class addAccountServlet
 */
@WebServlet("/addAccount")
public class addAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAccountServlet() {
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
	    StringBuilder requestBody = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        requestBody.append(line);
	    }

	    System.out.println("Dữ liệu nhận được từ client: " + requestBody.toString());
	    
	    JSONObject jsonObject = new JSONObject(requestBody.toString());
	    String id = jsonObject.getString("id");
	    String username = jsonObject.getString("username");
	    String phone = jsonObject.getString("phone");
	    String name = jsonObject.getString("name");
	    String password = jsonObject.getString("password");
	    
	    PrintWriter out = response.getWriter();
	    
	    UserDAO userD = new UserDAO(); UserDetailDao userdetailDao = new UserDetailDao();
	    List<Integer> list = userD.getIdByUser();
	    
	    boolean isDuplicate = false;
	    for (Integer integer : list) {
	        if (Integer.parseInt(id) == integer) {
	            isDuplicate = true;
	            System.out.println("nhu cai lon roi ");
	            break;
	        }
	    }

	    if (!isDuplicate) {
	        User a = new User();
	        a.setUserid(Integer.parseInt(id));
	        a.setUsername(username);
	        a.setPassword(password);
	        a.setAddress("phu loc");
	        a.setuPhone(phone);
	        a.setRole(0);
	       
	        userD.addUser(a);

	        UserDetail b = new UserDetail(userdetailDao.IndexOfUser() + 1, name, Integer.parseInt(id));
	        System.out.println(b);
	        userdetailDao.addUserDetail(b);
	    }

	    JSONObject jsonResponse = new JSONObject();
	    response.setCharacterEncoding("UTF-8");
	    if (isDuplicate) {
	        jsonResponse.put("error", "Du lieu bi trung lap. Vui lòng kiểm tra lại.");
	    } else {
	        jsonResponse.put("message", "success");
	    }
	    
	    response.setContentType("application/json; charset=UTF-8");
	 
	    out.print(jsonResponse.toString());
	    out.flush();
	}
}




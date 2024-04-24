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

import dao.UserDAO;
import dao.UserDetailDao;
import model.User;

/**
 * Servlet implementation class editAccountServlet
 */
@WebServlet("/editAccount")
public class editAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAccountServlet() {
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
		    System.out.println("Dữ liệu nhận được từ client sau khi chỉnh sửa : " + requestBody.toString());
		    
		    JSONObject jsonObject = new JSONObject(requestBody.toString());
		    String id = jsonObject.getString("id");
		    String username = jsonObject.getString("username");
		    String phone = jsonObject.getString("phone");
		    String fullname = jsonObject.getString("name");
		    String password = jsonObject.getString("password");
		    
		    System.out.println(id + fullname + username + password + phone);
		    
		    PrintWriter out = response.getWriter();
		    User user = new User();
		    UserDAO userD = new UserDAO();
		    
		    List<Integer> list = userD.getIdByUser();
		    
		    for (Integer integer : list) {
				if(Integer.parseInt(id) == integer) list.remove(integer);
			}
		    System.out.println("list" + list);
		    
		    boolean isDuplicate = false;
		    for (Integer integer : list) {
		        if (Integer.parseInt(id) == integer) {
		            isDuplicate = true;
		            break;
		        }
		    }
		    List<model.User> allAccount = userD.getAllAccount();
		    User a = userD.login(username, password);
		    
		    System.out.println("user bb " + a );
		    
		    user.setUserid(Integer.parseInt(id));
		    user.setUsername(username) ;
		    user.setPassword(password);
    		user.setAddress(a.getAddress()); 
    		user.setuPhone(phone);
    		user.setRole(0);
		    boolean b = userD.updateUser(user);
		    
		    UserDetailDao usD = new UserDetailDao();
		    usD.updateFullName(Integer.parseInt(id), fullname);

		    	 JSONObject jsonResponse = new JSONObject();
		 	    response.setCharacterEncoding("UTF-8");
		 	    if (isDuplicate) {
		 	        jsonResponse.put("error", "Du lieu bi trung lap. Vui lòng kiểm tra lại.");
		 	    } 
		 	    else 
		 	    {
		 	        jsonResponse.put("message", "success");
		 	    }
		 	    response.setContentType("application/json; charset=UTF-8");
		 		 
			    out.print(jsonResponse.toString());
			    out.flush();
			    
	}
}



package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.UserEmailDAO;


/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotPass")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * 
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
		BufferedReader reader = request.getReader();
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    String json = sb.toString();
	    JSONObject jsonObject = new JSONObject(json);
	    String email = jsonObject.getString("email");
	    
	    System.out.println("Email nhận được từ form: " + email);
	    UserEmailDAO a = new UserEmailDAO();   
	    
	    JSONObject jsonResponse = new JSONObject();
	    if (!a.EmailCheckExits(email)) {
	        System.out.println("CC1");
	        jsonResponse.put("errorCode", 101);
	    } else {
	    	EmailSender b = new EmailSender();
	        System.out.println("CC");
	        b.sendOTP(email);
	        jsonResponse.put("errorCode", 202);
	    }
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    out.print(jsonResponse.toString());
	    out.flush();

	}

}

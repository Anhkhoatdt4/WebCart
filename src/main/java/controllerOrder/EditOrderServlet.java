package controllerOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.OrderDAO;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/editOrder")
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
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
		 System.out.println("Edit");
		    while ((line = reader.readLine()) != null) {
		        requestBody.append(line);
		    }

		    JSONObject jsonObject = new JSONObject(requestBody.toString());
		    int  orderId =Integer.parseInt(jsonObject.getString("orderId"));
		    String status = jsonObject.getString("status");
		    System.out.println("giá trị orderId là " + orderId + "trang thái " + status);
		    
		    OrderDAO orderDao = new OrderDAO();
		    orderDao.updateOrderStatus(orderId, status);
		    
		    PrintWriter out = response.getWriter();
		    JSONObject jResponse = new JSONObject();
		    jResponse.put("message", "success");
		    out.print(jsonObject.toString());
		    out.flush();
		   
	}

}

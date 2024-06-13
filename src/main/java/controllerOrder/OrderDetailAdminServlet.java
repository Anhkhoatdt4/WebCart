package controllerOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import repository.*;
import model.Order;
import model.Product;

/**
 * Servlet implementation class OrderDetailAdminServlet
 */
@WebServlet("/OrderDetailAdminServlet")
public class OrderDetailAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * HttpSession session = request.getSession(); BufferedReader reader = new
		 * BufferedReader(new InputStreamReader(request.getInputStream())); String
		 * jsonData = ""; String line; while ((line = reader.readLine()) != null) {
		 * jsonData += line; } reader.close();
		 * 
		 * JSONObject jsonObject = new JSONObject(jsonData); int orderId =
		 * jsonObject.getInt("ID"); System.out.println("Order qewq " + orderId);
		 * 
		 * OrderDAO orDAO=new OrderDAO(); OrderDetailDAO oderDetailDAO=new
		 * OrderDetailDAO(); Order order= orDAO.getInforOrderById(orderId);
		 * Map<Product,Integer> listPro= oderDetailDAO.getProductByOrderId(orderId);
		 * System.out.println(listPro); session.setAttribute("listProduct", listPro);
		 * session.setAttribute("order",order);
		 * 
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8");
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String jsonData = "";
	    String line;
	    while ((line = reader.readLine()) != null) {
	        jsonData += line;
	    }
	    reader.close();
	    
	    JSONObject jsonObject = new JSONObject(jsonData);
	    int orderId = jsonObject.getInt("ID");
	    System.out.println("Order qewq " + orderId);
	    
	    JSONObject jsonResponse = new JSONObject();
	    jsonResponse.put("message1", "OK");
        OrderDAO orDAO=new OrderDAO();
			OrderDetailDAO oderDetailDAO=new OrderDetailDAO();
			Order order= orDAO.getInforOrderById(orderId);
			Map<Product,Integer> listPro= oderDetailDAO.getProductByOrderId(orderId);
			System.out.println(listPro);
			session.setAttribute("listProduct", listPro);
			session.setAttribute("order",order);
			
			System.out.println("hello");
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(jsonResponse.toString());
	}

}

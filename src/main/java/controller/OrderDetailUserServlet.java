package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * Servlet implementation class OrderDetailUserServlet
 */
@WebServlet("/OrderDetailUserServlet")
public class OrderDetailUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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
	    
	    System.out.println(jsonData);
	    JSONObject jsonObject = new JSONObject(jsonData.toString());
	    
	    int orderId = jsonObject.getInt("ID");

	    System.out.println("Mã don hang la " + orderId);
	    
		OrderDAO orDAO=new OrderDAO();
		OrderDetailDAO oderDetailDAO=new OrderDetailDAO();
		
		Order order= orDAO.getInforOrderById(orderId);
		Map<Product,Integer> listPro= oderDetailDAO.getProductByOrderId(orderId);
		
		System.out.println(listPro);
		session.setAttribute("listProduct", listPro);
		session.setAttribute("order",order);
		
		
		
		JSONObject jsonResponse = new JSONObject();
		
		jsonResponse.put("message1", "OK");
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse.toString());
       
	}

}

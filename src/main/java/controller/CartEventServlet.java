package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.CartDetailDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Servlet implementation class CartEvent
 */
@WebServlet("/cartEvent")
public class CartEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartEventServlet() {
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
	         int cartID = jsonObject.getInt("cartID");
	         int productID = jsonObject.getInt("productID");
	         int newQuantity = jsonObject.getInt("newQuantity");
	         double price = jsonObject.getDouble("price");
	        
	         
		    System.out.println("cartId " + cartID);
		    System.out.println("productID " + productID);
		    System.out.println("so luong " + newQuantity );
		    System.out.println("gia ca " + price );
		    System.out.println();
		    
		    CartDetailDAO cdd = new CartDetailDAO();
		    cdd.updateCartDetailQuantity(cartID, productID, newQuantity, price * newQuantity);
		    
		   
		    
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write("{ \"statuscc\": \"successcc1\" }");
		    request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}

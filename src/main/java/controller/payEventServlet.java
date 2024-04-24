package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.CartDAO;
import dao.CartDetailDAO;
import dao.ProductDAO;
import model.Cart;
import model.CartDetail;
import model.Product;

/**
 * Servlet implementation class payEventServlet
 */
@WebServlet("/payshop")
public class payEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payEventServlet() {
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
	    
	    System.out.println(jsonData);
	    List<Product> list = new ArrayList<>();
	    CartDetail cartDetail = new CartDetail();
	    CartDetailDAO cdb = new CartDetailDAO();
	    try {
	    	ProductDAO pdb = new ProductDAO();
	    
	        JSONArray jsonArray = new JSONArray(jsonData);

	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            int cartID1 = jsonObject.getInt("cartID");
	            int productID1 = jsonObject.getInt("productID");
	            int newQuantity1 = jsonObject.getInt("quantity");
	            double price1 = jsonObject.getDouble("price");

	            HttpSession session = request.getSession();
	            Product a  = pdb.getProductById(productID1);
	            a.setPquantity(newQuantity1);
		        cartDetail = cdb.getCartDetailByCartIdAndProductId(cartID1, productID1);
	            list.add(a);
	            
	            
	            session.setAttribute("cartIDpay", cartID1);
	            session.setAttribute("productIDpay", productID1);
	            session.setAttribute("listInPayEvent", list);
	            session.setAttribute("newcartDetail", cartDetail);
	        }
	        
	        System.out.println("Request");
	        request.getRequestDispatcher("payshop.jsp").forward(request, response);
	    } catch (JSONException e) {
	        e.printStackTrace();
	        
	    }
	    ;
	}


}

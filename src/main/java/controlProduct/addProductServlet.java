package controlProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add pro duct ser v let");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		/* String id = request.getParameter("ID"); */
		String name = new String(request.getParameter("Name").getBytes("ISO-8859-1"), "UTF-8");
	    String photo = request.getParameter("Photo");
		/* System.out.println("ID: " + id); */
	    System.out.println("Name: " + name);
	    System.out.println("Photo: " + photo);
	    String quantityString = request.getParameter("Quantity");
	    int quantity = 0 ;
	    if (quantityString != null && !quantityString.isEmpty()) {
	        try {
	            quantity = Integer.parseInt(quantityString);
	        } catch (NumberFormatException e) {
	            
	        }
	    } else {
	        System.out.println("hup nha cai");
	    }
	    int size = Integer.parseInt(request.getParameter("Size"));
	    String state = request.getParameter("State");
	    double price = Double.parseDouble(request.getParameter("Price"));
	    String type = request.getParameter("Type");
	    if (type != null && !type.isEmpty()) {
	        type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
	    }
	    String description = request.getParameter("Description");
	    int c_id = 0;
	    if (type.equals("Nike")) c_id = 1 ;
	    else if (type.equals("Adidas")) c_id = 2 ;
	    	else if (type.equals("Puma")) c_id = 3;
	    		else if (type.equals("Lacoste")) c_id = 4;
	    	
	   
	    ProductDAO pdb = new ProductDAO();
	    Product a = new Product(pdb.getMaxProductId() + 1, name, description, photo, 2, quantity, price, c_id);
	    pdb.addProduct(a);
	  
	    
	    request.getRequestDispatcher("productManage").forward(request, response);
	}

}

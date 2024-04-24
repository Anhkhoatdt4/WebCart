package controlProduct;

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
import dao.ProductDAO;

/**
 * Servlet implementation class editProductServlet
 */
@WebServlet("/editProduct")
public class editProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProductServlet() {
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
		 System.out.println("Edit Product");
		    while ((line = reader.readLine()) != null) {
		        requestBody.append(line);
		    }

		    JSONObject jsonObject = new JSONObject(requestBody.toString());
		    String name = jsonObject.getString("name");
		    int quantity = Integer.parseInt( jsonObject.getString("quantity"));
		    String status = jsonObject.getString("status");
		    double price = Double.parseDouble(jsonObject.getString("price"));
		    
		    int id = Integer.parseInt( jsonObject.getString("id"));
		    
		    
		    System.out.println(id + " " + name + " " + quantity + " " + status + " " + price);
		    
		    ProductDAO pdb = new ProductDAO();
		    
		    pdb.updateProduct(id, name, quantity, price);
		    
		    PrintWriter out = response.getWriter();
		    JSONObject jResponse = new JSONObject();
		    jResponse.put("message", "success");
		    out.print(jsonObject.toString());
		    out.flush();
	}

}

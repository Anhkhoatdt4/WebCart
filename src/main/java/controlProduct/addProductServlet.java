package controlProduct;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import repository.*;
import model.Product;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProductServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("add pro duct ser v let");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 // String id = request.getParameter("ID"); 
		String name = new String(req.getParameter("Name").getBytes("ISO-8859-1"), "UTF-8");
		  System.out.println("Name: " + name); 
		  String quantityString= req.getParameter("Quantity"); System.out.println("Quantity: " +quantityString);
		  
		 
		  //String photo = request.getParameter("Photo"); System.out.println("Photo: " + photo);
		 
	
		  
		  int quantity = 0 ; if (quantityString != null && !quantityString.isEmpty()) {
		try { quantity = Integer.parseInt(quantityString); } catch (NumberFormatException e) {
		  
		  } } else { System.out.println("hup nha cai"); } 
		  int size =Integer.parseInt(req.getParameter("Size")); 
		  String state =req.getParameter("State"); double price =
		  Double.parseDouble(req.getParameter("Price")); 
		  String type = req.getParameter("Type");
		  if (type != null && !type.isEmpty()) 
		  { type =type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase(); }
		  String description = req.getParameter("Description"); 
		  int c_id = 0; 
		  if(type.equals("Nike")) c_id = 1 ; 
		  else if (type.equals("Adidas")) c_id = 2 ;
		  else if (type.equals("Puma")) c_id = 3; 
		  else if (type.equals("Lacoste")) c_id = 4;
		  
		  File dir = new File("C:\\Users\\nguye\\Desktop\\hk3\\Java\\WebCart\\src\\main\\webapp\\image");
			if(!dir.exists()) { // tạo nếu chưa tồn tại
				System.out.println("Tao file");
			dir.mkdirs();
			}
			System.out.println("Đường dẫn thư mục files: " + dir.getAbsolutePath());

			// lưu các file upload vào thư mục files
			Part photo1 = req.getPart("Photo"); // file hình
			File photoFile = new File(dir, photo1.getSubmittedFileName());
			photo1.write(photoFile.getAbsolutePath());
			// chia sẻ cho result.jsp để hiển thị
			System.out.println(photoFile.getName());
			//req.setAttribute("img", photoFile);
		 String photo="image//"+photoFile.getName();
			System.out.println(photo);

		ProductDAO pdb = new ProductDAO();
		Product a = new Product(pdb.getMaxProductId(c_id) + 1, name, description, photo, 2, quantity,
				price, c_id);
		
		pdb.addProduct(a);

		req.getRequestDispatcher("productManage").forward(req, resp);

	}

}

package controlProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.*;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ProductManageServlet
 */
@WebServlet("/productManage")
public class productManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				HttpSession session  = request.getSession(true);
				ProductDAO proDao= new ProductDAO();
				List<Product> listPro= proDao.getAll();
				List<Product> listPro1 = new ArrayList<>();
				Collections.sort(listPro, Comparator.comparing(Product::getCategory_id));
				
				Map<Integer, List<Product>> productMap = new HashMap<>();
				for (Product product : listPro) {
				    productMap.computeIfAbsent(product.getCategory_id(), k -> new ArrayList<>()).add(product);
				}

				for (List<Product> productList : productMap.values()) {
				    productList.sort((o1, o2) -> o2.getpId() - o1.getpId());
				    for (Product product : productList)
				    {
				    	listPro1.add(product);
				    }
				}
				session.setAttribute("ListProduct", listPro1);
				CategoryDAO cateDao=new CategoryDAO();
				List<Category> listCate= cateDao.getAll();
				
				session.setAttribute("ListCate", listCate);
		        request.getRequestDispatcher("ProdManage.jsp").forward(request, response);
				
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

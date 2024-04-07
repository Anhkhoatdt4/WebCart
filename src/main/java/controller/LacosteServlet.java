package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class LacosteServlet
 */
@WebServlet("/Lacoste")
public class LacosteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LacosteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
        List<Product> allProducts = productDAO.getListByCategoryID(4);

        System.out.println("dang trong nike servlet ");
        System.out.println(allProducts);
        
        int numPage = 8;

        int totalPages = (int) Math.ceil((double) allProducts.size() / numPage);

        int Pagenow = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            Pagenow = Integer.parseInt(pageParam);
        }

        int startIndex = (Pagenow - 1) * numPage;
        int endIndex = Math.min(startIndex + numPage, allProducts.size());

        List<Product> currentPageProducts = productDAO.getListByPage(allProducts, startIndex, endIndex);

        HttpSession session = request.getSession();
        
        
//        System.out.println("page " + Pagenow + "start" + startIndex + "End" + endIndex);
		/* System.out.println("data " + currentPageProducts ); */
//        System.out.println("num" + totalPages);
        session.setAttribute("data", currentPageProducts);
        session.setAttribute("num", totalPages);
        session.setAttribute("page", Pagenow);

        
        request.getRequestDispatcher("Lacoste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

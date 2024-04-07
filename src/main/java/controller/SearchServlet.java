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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pdb = new ProductDAO();
		String query = request.getParameter("query");
		String query1 =  "%" + query + "%";
		
		
		List<Product> searchResults = pdb.searchProducts(query1);
		System.out.println(searchResults);
		
		int numPage = 8;

        int totalPages = (int) Math.ceil((double) searchResults.size() / numPage);

        int Pagenow = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            Pagenow = Integer.parseInt(pageParam);
        }

        int startIndex = (Pagenow - 1) * numPage;
        int endIndex = Math.min(startIndex + numPage, searchResults.size());

        List<Product> currentPageProducts = pdb.getListByPage(searchResults, startIndex, endIndex);

        HttpSession session = request.getSession();
        
        
        System.out.println("page " + Pagenow + "start" + startIndex + "End" + endIndex);
        System.out.println( "gia tri query " + query);
		
        session.setAttribute("data", currentPageProducts);
        session.setAttribute("num", totalPages);
        session.setAttribute("page", Pagenow);
        request.setAttribute("txtS", query);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

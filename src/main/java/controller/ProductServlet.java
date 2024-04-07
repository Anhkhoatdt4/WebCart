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

@WebServlet("/home")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ProductDAO productDAO = new ProductDAO();
        List<Product> allProducts = productDAO.getAll();

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

        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String productId = request.getParameter("productId");
            System.out.println("Đã đăng nhập");
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
        	System.out.println("Chưa đăng nhập");
            response.sendRedirect("login.jsp");
        }
    }
}

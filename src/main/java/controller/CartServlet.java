package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.CartDetailDAO;
import dao.ProductDAO;
import model.Cart;
import model.CartDetail;
import model.Product;



/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	response.setContentType("text/html");
	        HttpSession session = request.getSession(false);
	        

	        if (session != null && session.getAttribute("username") != null)
	        {
	            String productId = request.getParameter("productId");
	            int userId = (int) session.getAttribute("userID");
	            
	            ProductDAO productDAO = new ProductDAO();
	            Product product = productDAO.getProductById(Integer.parseInt(productId));
	            
	            CartDAO cartDAO = new CartDAO();
	            CartDetailDAO cartDetailDAO = new CartDetailDAO();
	            
	           
	            Cart cart = cartDAO.getCartByUserId(userId);
	                
	                if (cart == null) {
	                
	                    cart = new Cart();
	                    cart.setCartId(cartDAO.getMaxCartId() + 1);
	                    cart.setUser_Id(userId);
	                    cartDAO.addCart(cart);
	                }
	            
	            int CartIdKey = cart.getCartId(); 
	            List<CartDetail> cartDetails = cartDAO.getCartDetailsByCartId(CartIdKey, productDAO);
	            
	            List<Product> listProduct = productDAO.getAll();
	              
	            if (cartDetails != null && !cartDetails.isEmpty()) 
	            {
	            
	                boolean productExists = false;
	                for (CartDetail cartDetail : cartDetails) 
	                {
	                    if (product.getpId() == cartDetail.getProduct().getpId()) {
	                    	
	                    	// System.out.println("========= " + cartDetail);
//	                    	cartDetailDAO.updateCartDetailQuantity(CartIdKey, product.getpId(), cartDetail.getQuantity() + 1);
	                        productExists = true;
	                        break;
	                    }
	                }
	                if (!productExists) {
	                    CartDetail newCartDetail = new CartDetail();
	                    newCartDetail.setCartDetailId(cartDetailDAO.getMaxCart_DetailId() + 1);
	                    newCartDetail.setProduct(product);
	                    newCartDetail.setCartId(cart.getCartId());
	                    newCartDetail.setQuantity(1);
	                    newCartDetail.setTotalMoney(product.getPprice());
	                    cartDetailDAO.addCartDetail(newCartDetail);
	                    cartDetails.add(newCartDetail);
	                }
	            } 
	            else
	            {
	            	System.out.println("san pham chua ton tai ");
	                CartDetail newCartDetail = new CartDetail();
	                newCartDetail.setCartDetailId(cartDetailDAO.getMaxCart_DetailId() + 1);
	                newCartDetail.setProduct(product);
	                newCartDetail.setCartId(cart.getCartId());
	                newCartDetail.setQuantity(1);
	                newCartDetail.setTotalMoney(product.getPprice());
	                cartDetailDAO.addCartDetail(newCartDetail);
	                cartDetails.add(newCartDetail);
	                
	            }

	            if ("POST".equalsIgnoreCase(request.getMethod()))
	            {
	            //System.out.println("load trang");
	    
	            session.setAttribute("dataPushed", true);
	            session.setAttribute("cart", cart);
	            session.setAttribute("cartDetail", cartDetails);
	            session.setAttribute("listProd", listProduct);
	            session.setAttribute("cartSize", cartDetails.size());   
//	             System.out.println(  "so luong san pham "   + cartDetails.size());
	            request.getRequestDispatcher("cart.jsp").forward(request, response);
	            }
	        } 
	        else 
	        {
	            response.sendRedirect("login.jsp");
	        }
	    }

}

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.CartDAO;
import dao.CartDetailDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import model.CartDetail;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;



/**
 * Servlet implementation class orderDatabaseEvent
 */
@WebServlet("/orderDatabaseEvent")
public class orderDatabaseEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderDatabaseEvent() {
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
        
         Date currentTime = new Date();
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	     String formattedDate = dateFormat.format(currentTime);
	
	     String currentDate = formattedDate;
        
	     
        
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray productsArray = jsonObject.getJSONArray("products");
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        String address = jsonObject.getString("address");
        double totalPrice = jsonObject.getDouble("totalPrice");
        HttpSession session = request.getSession(false);
        
        Integer cartID = (Integer) session.getAttribute("IDCart");
        Integer userID = (Integer) session.getAttribute("userID"); 
        int id = userID.intValue();

        OrderDAO orderDao = new OrderDAO();
        ProductDAO pdb = new ProductDAO();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        CartDetailDAO cdb = new CartDetailDAO();
        
        User user = new User();
        user.setAddress(address); user.setUsername(name); user.setuPhone(phone);user.setUserid(id);

        
		orderDao.addOrderIntoDb(orderDao.IndexOfUser() + 1, currentTime, totalPrice, "Chờ xác nhận" , id);
        
        List<Product> listProduct = new ArrayList<>();
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        Order order = orderDao.searchOrder(id); // tim kiem order co id : userId
        System.out.println(order);
        
        List<CartDetail> ListCD = new ArrayList<>();
        ListCD = cdb.getCartDetailsByCartId(cartID);
        
        for (int i = 0; i < productsArray.length(); i++) 
        {
            JSONObject product = productsArray.getJSONObject(i);
            String productName = product.getString("name");
            Product productInOrderDatabase = pdb.getProductByName(productName);
            
            System.out.println(productInOrderDatabase);
            
            OrderDetail o = new OrderDetail();
			/*
			 * CartDetail cd = cdb.getCartDetailByCartIdAndProductId(cartID,
			 * productInOrderDatabase.getpId()); System.out.println(cd );
			 * System.out.println(cartID);
			 */
            listProduct.add(productInOrderDatabase);
            o.setOrderDetailId(orderDetailDao.IndexOfOrderDetail() + 1);
            o.setProductID(productInOrderDatabase.getpId());
            for (CartDetail cd : ListCD) {
	            if(cd.getProduct().getpId() == productInOrderDatabase.getpId())
	            {
		    		o.setQuantity(cd.getQuantity());
		    		o.setPrice(cd.getTotalMoney());
	            }
            }
    		o.setOrderId(order.getOrderId());
    		boolean success = orderDetailDao.addOrderDetail(o); 
			
			cdb.deteleCartDetail(cartID, productInOrderDatabase.getpId()); 
			 
    		listOrderDetail.add(o);
    	
    		
        }
        CartDAO cartDAO = new CartDAO();
        List<CartDetail> cartDetails1 = cartDAO.getCartDetailsByCartId( cartID, pdb);
        session.removeAttribute("cartDetail");
        
        session.setAttribute("cartDetail", cartDetails1);
       
        session.setAttribute("Status",order.getStatus());
        session.setAttribute("listProductInOrder", listProduct);
		/* session.setAttribute("listOrderDetailsInOrder", listOrderDetail); */
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write("{ \"statuscc\": \"successcc1\" }");
//	    request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}

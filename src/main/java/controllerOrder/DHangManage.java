package controllerOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.UserDAO;
import dao.UserDetailDao;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;
import model.UserDetail;

/**
 * Servlet implementation class DHangManage
 */
@WebServlet("/DHangManage")
public class DHangManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DHangManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pdb = new ProductDAO();
		List<Product> listProduct = pdb.getAll();

		HttpSession session = request.getSession(true);

		UserDAO uD = new UserDAO();
		List<User> listUser = uD.getAllAccount();
		
		OrderDAO oD = new OrderDAO();
		List<Order> listOrder = oD.getAllOrders();
		
		
		UserDetailDao userDetailD = new UserDetailDao();
		List<UserDetail> listUserDetail =  userDetailD.getUserDetailList();
	

		OrderDetailDAO odd = new OrderDetailDAO();
		List<OrderDetail> listOrderDetail =  odd.getAllOrderDetails();
		
		
		List<Object[]> dataList = new ArrayList<>();
		
		for (Order order : listOrder) {
            for (OrderDetail orderDetail : listOrderDetail) {
                if (order.getOrderId() == orderDetail.getOrderId()) {
                    Object[] data = new Object[6];
                    data[0] = order.getOrderId();
                    data[1] = order.getTotalMoney();
                    data[2] = order.getUserId();
                    data[3] = order.getStatus();
                    data[4] = orderDetail.getProductID();
                    data[5] = orderDetail.getQuantity();
                    dataList.add(data);
                }
            }
        }
		

		
		session.setAttribute("dssanpham1", listProduct);
		session.setAttribute("khachhangchitiet1", listUserDetail);
		session.setAttribute("dataList", dataList);

		
		request.getRequestDispatcher("DHangManage.jsp").forward(request, response);
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
	    
	    JSONObject jsonObject = new JSONObject(jsonData);
	    int orderId = jsonObject.getInt("ID");


	    OrderDetailDAO odd = new OrderDetailDAO();
	    odd.deleteOrderDetail(orderId);
	    
	    OrderDAO oderDao = new OrderDAO();
	    oderDao.deleteOrder(orderId);
	    
	    
	    List<Object[]> dataList = (List<Object[]>) request.getSession().getAttribute("dataList");
	    Iterator<Object[]> iterator = dataList.iterator();
	    while (iterator.hasNext()) {
	        Object[] objects = iterator.next();
	        if (objects[0].equals(orderId)) {
	            iterator.remove();
	        }
	    }
	    

	    JSONObject jsonResponse = new JSONObject();
	    jsonResponse.put("message", "Xóa tài khoản thành công");

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse.toString());
	}


}

package controllerOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.*;
import model.OrderDetail;
import model.Product;

/**
 * Servlet implementation class orderDelivered
 */
@WebServlet("/orderDelivered")
public class orderDelivered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderDelivered() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Trong orderDelivered");
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		Integer id1 = (Integer) session.getAttribute("userID");
		int user_id = id1.intValue();
		List<Integer> listIdInOrder = orderDao.getOrderIds("Đã giao hàng", user_id);
	
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		for (Integer orderId : listIdInOrder) {
		    listOrderDetail.add(orderDetailDao.listGetOrderDetail(orderId));
		}

		session.setAttribute("listOrderDetailsInOrderByDelivered", listOrderDetail);
		request.getRequestDispatcher("orderDelivered.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

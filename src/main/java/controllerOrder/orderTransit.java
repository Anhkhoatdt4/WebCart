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

/**
 * Servlet implementation class orderTransit
 */
@WebServlet("/orderTransit")
public class orderTransit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderTransit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("orderTransit");
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		Integer id1 = (Integer) session.getAttribute("userID");
		int id = id1.intValue();
		List<Integer> listIdInTransit = orderDao.getOrderIds("Đang vận chuyển", id);
		
		List<OrderDetail> listOrderDetailByTransit = new ArrayList<>();
		for (Integer orderId : listIdInTransit) {
		    listOrderDetailByTransit.add(orderDetailDao.listGetOrderDetail(orderId));
		}
		
		session.setAttribute("listOrderDetailsInOrderByTransit", listOrderDetailByTransit);
		request.getRequestDispatcher("orderTransit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

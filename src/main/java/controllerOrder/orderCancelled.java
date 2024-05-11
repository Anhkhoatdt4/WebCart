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

import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.OrderDetail;

/**
 * Servlet implementation class orderCancelled
 */
@WebServlet("/orderCancelled")
public class orderCancelled extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderCancelled() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Trong orderCancelled");
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		Integer id1 = (Integer) session.getAttribute("userID");
		int user_id = id1.intValue();
		List<Integer> listIdInOrder = orderDao.getOrderIds("Đã hủy", user_id);
	
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		for (Integer orderId : listIdInOrder) {
		    listOrderDetail.add(orderDetailDao.listGetOrderDetail(orderId));
		}

		session.setAttribute("listOrderDetailsInOrderByCancelled", listOrderDetail);
		request.getRequestDispatcher("orderCancelled.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

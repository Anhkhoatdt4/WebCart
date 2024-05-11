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
import dao.ProductDAO;
import model.OrderDetail;
import model.Product;

/**
 * Servlet implementation class orderManage
 */
@WebServlet("/orderManage")
public class orderManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Trong orderManage");
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		Integer id1 = (Integer) session.getAttribute("userID");
		int user_id = id1.intValue();
		List<Integer> listIdInOrder = orderDao.getOrderIds("Chờ xác nhận", user_id);
	
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		for (Integer orderId : listIdInOrder) {
		    listOrderDetail.add(orderDetailDao.listGetOrderDetail(orderId));
		}
		ProductDAO pdb = new ProductDAO();
		List<Product> listProductInOrderByManage = new ArrayList<>();
		listProductInOrderByManage = pdb.getAll();

		session.setAttribute("listOrderDetailsInOrder", listOrderDetail);
		session.setAttribute("listProductInOrder", listProductInOrderByManage);
		request.getRequestDispatcher("orderManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(false);
		 * System.out.println("Trong orderManage"); List<OrderDetail> list = new
		 * ArrayList<>(); OrderDAO orderDao = new OrderDAO(); OrderDetailDAO
		 * orderDetailDao = new OrderDetailDAO(); Integer id1 = (Integer)
		 * session.getAttribute("userID"); int id = id1.intValue(); list =
		 * orderDetailDao.listGetOrderDetail(orderDao.getOrderId("Chờ xác nhận", id));
		 * 
		 * System.out.println(list); System.out.println("ket thuc orderManage");
		 * session.setAttribute("listOrderDetailsInOrder", list);
		 * request.getRequestDispatcher("orderManage.jsp").forward(request, response);
		 */
	}

}

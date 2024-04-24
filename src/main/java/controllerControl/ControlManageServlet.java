/*
 * package controllerControl;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import dao.OrderDAO; import dao.OrderDetailDAO; import dao.ProductDAO; import
 * dao.UserDAO; import dao.UserDetailDao; import model.Order; import
 * model.OrderDetail; import model.Product; import model.User; import
 * model.UserDetail;
 * 
 *//**
	 * Servlet implementation class ControlManageServlet
	 */
/*
 * @WebServlet("/ControlManage") public class ControlManageServlet extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public ControlManageServlet() { super(); // TODO Auto-generated constructor
 * stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * ProductDAO pdb = new ProductDAO(); List<Product> listProduct = pdb.getAll();
 * 
 * HttpSession session = request.getSession(true);
 * 
 * UserDAO uD = new UserDAO(); List<User> listUser = uD.getAllAccount();
 * 
 * OrderDAO oD = new OrderDAO(); List<Order> listOrder = oD.getAllOrders();
 * 
 * UserDetailDao userDetailD = new UserDetailDao(); List<UserDetail>
 * listUserDetail = userDetailD.getUserDetailList();
 * 
 * OrderDetailDAO odd = new OrderDetailDAO(); List<OrderDetail> listOrderDetail
 * = odd.getAllOrderDetails();
 * 
 * System.out.println("BAng dieu khien");
 * 
 * session.setAttribute("tongsanpham", listProduct.size());
 * session.setAttribute("tongdonhang", listOrder.size());
 * session.setAttribute("tongkhachhang", listUser.size());
 * session.setAttribute("dssanpham", listProduct);
 * session.setAttribute("dsdonhang", listOrder);
 * session.setAttribute("dskhachhang", listUser);
 * session.setAttribute("dskhachhangchitiet", listUserDetail);
 * session.setAttribute("dsdonhangchitiet", listOrderDetail);
 * 
 * request.getRequestDispatcher("ControlManage.jsp").forward(request, response);
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */
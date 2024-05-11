package controllerControl;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
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
import dao.UserDAO;
import dao.UserDetailDao;
//import dao.UserDetailDao;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;
//import model.UserDetail;
import model.UserDetail;

/**
 * Servlet implementation class ControlManageServlet
 */
@WebServlet("/ControlManage")
public class controlManageSe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlManageSe() {
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
		
		/*
		 * OrderDAO oD = new OrderDAO(); List<Order> listOrder = oD.getAllOrders();
		 * 
		 * UserDetailDao userDetailD = new UserDetailDao(); List<UserDetail>
		 * listUserDetail = userDetailD.getUserDetailList();
		 * 
		 * OrderDetailDAO odd = new OrderDetailDAO(); List<OrderDetail> listOrderDetail
		 * = odd.getAllOrderDetails();
		 */
		 LocalDate currentDate = LocalDate.now();

	        // Tìm ngày đầu tiên của tuần hiện tại (thứ Hai)
	        LocalDate firstDayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

	        // Tìm ngày cuối cùng của tuần hiện tại (Chủ nhật)
	        LocalDate lastDayOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
	        LocalDate firstDayOfLastWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).minusWeeks(1);

	        // Tìm ngày cuối cùng của tuần trước (Chủ nhật)
	        LocalDate lastDayOfLastWeek1 = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).minusWeeks(1);
		OrderDAO od=new OrderDAO();
		double[] order= od.getTotalMoneyByWeek(firstDayOfWeek.toString(),lastDayOfWeek.toString());
		double[] order1= od.getTotalMoneyByWeek(firstDayOfLastWeek.toString(),lastDayOfLastWeek1.toString());
		
        int currentMonth = currentDate.getMonthValue();
        int curentYear=currentDate.getYear();
        System.out.println(currentMonth);
        System.out.println(12-(6-currentMonth)+1);
        System.out.println(curentYear-1);

        
        double[] doanhthumonth;
        if (currentMonth<6)
        	 doanhthumonth=od.getTotalMoneyByMonth(12-(6-currentMonth)+1,curentYear-1, currentMonth, curentYear );
        else
       	 doanhthumonth=od.getTotalMoneyByMonth(curentYear,currentMonth, curentYear, currentMonth+5 );

		/*
		 * for (int i = 0; i < doanhthumonth.length; i++) {
		 * System.out.println("Giá trị thứ " + (i) + ": " + doanhthumonth[i]); }
		 */
		OrderDAO oD = new OrderDAO();
		List<Order> listOrder = oD.getAllOrders();
		
		UserDetailDao userDetailD = new UserDetailDao();
		List<UserDetail> listUserDetail =  userDetailD.getUserDetailList();

		OrderDetailDAO odd = new OrderDetailDAO();
		List<OrderDetail> listOrderDetail =  odd.getAllOrderDetails();
		
		System.out.println("BAng dieu khien");
		

		session.setAttribute("dskhachhang", listUser);
		session.setAttribute("dskhachhangchitiet", listUserDetail);
		session.setAttribute("dsdonhangchitiet", listOrderDetail);

		session.setAttribute("tongsanpham", listProduct.size());
		//session.setAttribute("tongdonhang", listOrder.size());
		session.setAttribute("tongkhachhang", listUser.size());
		session.setAttribute("dssanpham", listProduct);
		session.setAttribute("dsdonhang", listOrder);
		//session.setAttribute("dsdonhang", listOrder);
		session.setAttribute("dskhachhang", listUser);
		//session.setAttribute("dskhachhangchitiet", listUserDetail);
		//session.setAttribute("dsdonhangchitiet", listOrderDetail);
		session.setAttribute("doanhthu", order);
		session.setAttribute("doanhthu1", order1);
		session.setAttribute("tongdonhang", listOrder.size());
		session.setAttribute("doanhthumonth", doanhthumonth);
		
		System.out.println(1234);
		 for (int i = 0; i < order.length; i++) {
		 
		System.out.println(order[i]);
		 }
		 for (int i = 0; i < order1.length; i++) {
			 
				System.out.println(order1[i]);
				 }
		request.getRequestDispatcher("ControlManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

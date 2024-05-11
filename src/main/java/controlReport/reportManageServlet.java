package controlReport;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.UserDAO;
import dao.UserDetailDao;
//import dao.UserDetailDao;
import model.Category;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;
//import model.UserDetail;
import model.UserDetail;

/**
 * Servlet implementation class reportManageServlet
 */
@WebServlet("/reportManage")
public class reportManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ProductDAO pdb = new ProductDAO();
		
		LocalDate currentDate = LocalDate.now();

        // Tìm ngày đầu tiên của tuần hiện tại (thứ Hai)
        LocalDate firstDayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // Tìm ngày cuối cùng của tuần hiện tại (Chủ nhật)
        LocalDate lastDayOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate firstDayOfLastWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).minusWeeks(1);

        // Tìm ngày cuối cùng của tuần trước (Chủ nhật)
        LocalDate lastDayOfLastWeek1 = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).minusWeeks(1);
        
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        CategoryDAO cD=new  CategoryDAO();
        int[] loaigiay;
        if (currentMonth<10)
        		loaigiay=cD.getTotalCategoryByMonth(Integer.toString(currentYear)+"-0"+Integer.toString(currentMonth));
        else
    		loaigiay=cD.getTotalCategoryByMonth(Integer.toString(currentYear)+"-"+Integer.toString(currentMonth));

        System.out.println(Integer.toString(currentYear)+"-0"+Integer.toString(currentMonth));
		List<Product> listProduct = pdb.getAll();

		List<Category> l = Category.getAllCategories();
		
		UserDAO uD = new UserDAO();
		List<User> listUser = uD.getAllAccount();
		
		OrderDAO oD = new OrderDAO();
		
		double[] loinhuantuannay=oD.getProfitInWeek(firstDayOfWeek.toString(), lastDayOfWeek.toString());
		double[] loinhuantuantruoc=oD.getProfitInWeek(firstDayOfLastWeek.toString(), lastDayOfLastWeek1.toString());
		List<Order> listOrder = oD.getAllOrders();
		
		
		  double totalMoney = 0 ;
		  
		  for (Order order : listOrder) { totalMoney += order.getTotalMoney(); }
		 
		
		UserDetailDao userDetailD = new UserDetailDao();
		List<UserDetail> listUserDetail =  userDetailD.getUserDetailList();

		OrderDetailDAO odd = new OrderDetailDAO();
		List<OrderDetail> listOrderDetail =  odd.getAllOrderDetails();
		

		List<Product> top5Products = pdb.getTop5Product("2024-04-14");
		 
		Map<Product, Integer> productAndQuantity = pdb.getProductAndQuantity("04");

		List<Object[]> dataList = new ArrayList<>();
		
		
		  for (Order order : listOrder) 
		  { 
			  for (OrderDetail orderDetail : listOrderDetail) 
			  { 
				  if (order.getOrderId() == orderDetail.getOrderId()) 
				  { 	
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
		 
		for ( int i=0;i<loaigiay.length;i++)
		{
			System.out.println(loaigiay[i]);
		}
		
		System.out.println("Bao cao doanh thu");
		
		session.setAttribute("dataList", dataList);
		session.setAttribute("danhmuc", l);
		session.setAttribute("sanphamtrongthang", productAndQuantity);
		session.setAttribute("sanphambanchaytrongngay", top5Products);
		session.setAttribute("tongtien", totalMoney);
		session.setAttribute("tongkhachhang2", listUser.size());
		session.setAttribute("dssanpham2", listProduct);
		session.setAttribute("dsdonhang2", listOrder);
	    session.setAttribute("dskhachhang2", listUser);
		session.setAttribute("dskhachhangchitiet2", listUserDetail);
		session.setAttribute("dsdonhangchitiet2", listOrderDetail);
		session.setAttribute("loinhuantuannay", loinhuantuannay);
		session.setAttribute("loinhuantuantruoc", loinhuantuantruoc);
		session.setAttribute("loaigiay", loaigiay);

		request.getRequestDispatcher("RevenueReport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

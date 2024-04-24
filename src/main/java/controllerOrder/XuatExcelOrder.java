package controllerOrder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;

/**
 * Servlet implementation class XuatExelOrderServlet
 */
@WebServlet("/XuatExcelOrder")
public class XuatExcelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatExcelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			OrderDAO dao = new OrderDAO();
		
			String month = request.getParameter("month");
			if (month != null) {
			    if (month.length() == 1) {
			        month = "0" + month;
			    }
			}
			
			List<Order> list = dao.getAllOrder(month);
			//System.out.println(list);
			int maximum = 2147483547;
			int minimum = 1;

			Random rn = new Random();
			int range = maximum - minimum + 1;
			int randomNum = rn.nextInt(range) + minimum;

			FileOutputStream file = new FileOutputStream(
					"C:\\Users\\nguye\\Desktop\\hk3\\Java\\WebCart\\"+"order-"+"month" + Integer.toString(randomNum) + ".xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook();

			XSSFSheet workSheet = workbook.createSheet("1");

			XSSFRow row;
			XSSFCell cell0;
			XSSFCell cell1;
			XSSFCell cell2;
			XSSFCell cell3;
			XSSFCell cell4;
			XSSFCell cell5;
			XSSFCell cell6;


			row = workSheet.createRow(0);
			cell0 = row.createCell(0);
			cell0.setCellValue("OrderID");
			cell1 = row.createCell(1);
			cell1.setCellValue("Date");
			cell2 = row.createCell(2);
			cell2.setCellValue("TotalMoney");
			cell3 = row.createCell(3);
		
			cell3.setCellValue("Status");
			cell4 = row.createCell(4);
			cell4.setCellValue("UserID");
			

			int i = 0;
			for (Order order : list) {
				i = i + 1;
				row = workSheet.createRow(i);
				cell0 = row.createCell(0);
				cell0.setCellValue(order.getOrderId());
				cell1 = row.createCell(1);
				cell1.setCellValue(order.getDate());
				cell2 = row.createCell(2);
				cell2.setCellValue(order.getTotalMoney());
				cell3 = row.createCell(3);
				cell3.setCellValue(order.getStatus());
				
				cell4 = row.createCell(4);
				cell4.setCellValue(order.getUserId());
			}
			
			
			
			workbook.write(file);
			workbook.close();
			file.close();

			request.setAttribute("mess", "Da xuat file excel thanh cong");
			request.getRequestDispatcher("DHangManage").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi tạo file Excel.");
		} catch (Exception e) {
			// Xử lý các ngoại lệ khác
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

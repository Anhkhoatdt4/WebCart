package controlProduct;

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

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class XuatExcelProduct
 */
@WebServlet("/XuatExcelProduct")
public class XuatExcelProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuatExcelProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.getAll();
			System.out.println(list);
			int maximum = 2147483547;
			int minimum = 1;

			Random rn = new Random();
			int range = maximum - minimum + 1;
			int randomNum = rn.nextInt(range) + minimum;

			FileOutputStream file = new FileOutputStream(
					"C:\\Users\\nguye\\Desktop\\hk3\\Java\\WebCart\\"+"san pham" + Integer.toString(randomNum) + ".xlsx");

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
			XSSFCell cell7;
			XSSFCell cell8;

			row = workSheet.createRow(0);
			cell0 = row.createCell(0);
			cell0.setCellValue("ID");
			cell1 = row.createCell(1);
			cell1.setCellValue("Name");
			cell2 = row.createCell(2);
			cell2.setCellValue("Description");
			cell3 = row.createCell(3);
			cell3.setCellValue("Image");
			cell4 = row.createCell(4);
			cell4.setCellValue("Size");
			cell5 = row.createCell(5);
			cell5.setCellValue("Quantity");
			cell6 = row.createCell(6);
			cell6.setCellValue("Price");
			cell7 = row.createCell(7);
			cell7.setCellValue("Category Id");

			int i = 0;
			for (Product pro : list) {
				i = i + 1;
				row = workSheet.createRow(i);
				cell0 = row.createCell(0);
				cell0.setCellValue(pro.getpId());
				cell1 = row.createCell(1);
				cell1.setCellValue(pro.getPname());
				cell2 = row.createCell(2);
				cell2.setCellValue(pro.getPdesc());
				cell3 = row.createCell(3);
				cell3.setCellValue(pro.getPimage());
				cell4 = row.createCell(4);
				cell4.setCellValue(pro.getPsize());
				cell5 = row.createCell(5);
				cell5.setCellValue(pro.getPquantity());
				cell6 = row.createCell(6);
				cell6.setCellValue(pro.getPprice());
				cell7 = row.createCell(7);
				cell7.setCellValue(pro.getCategory_id());

			}
			workbook.write(file);
			workbook.close();
			file.close();

			request.setAttribute("mess", "Da xuat file excel thanh cong");
			request.getRequestDispatcher("productManage").forward(request, response);
		} catch (IOException e) {
			// Xử lý ngoại lệ khi có lỗi với các thao tác IO
			e.printStackTrace();
			// Có thể trả về một trang lỗi thông báo cho người dùng
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi tạo file Excel.");
		} catch (Exception e) {
			// Xử lý các ngoại lệ khác
			e.printStackTrace();
			// Có thể trả về một trang lỗi thông báo cho người dùng
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

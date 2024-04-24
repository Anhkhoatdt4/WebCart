package adminAccount;

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


import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class XuatExcelAccountServlet
 */
@WebServlet("/XuatExcelAccountServlet")
public class XuatExcelAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatExcelAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        
		try
		{UserDAO dao = new UserDAO();
        List<model.User> list = dao.getAllAccount();
        System.out.println(list);
        
        int maximum=2147483647;
        int minimum=1;
        
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;


        FileOutputStream file=new FileOutputStream(
        		"C:\\Users\\nguye\\Desktop\\hk3\\Java\\WebCart\\"+"tai-khoan-"+Integer.toString(randomNum)+".xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook();

        XSSFSheet workSheet=workbook.createSheet("1"); 

        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
        
        row=workSheet.createRow(0);
        cell0=row.createCell(0);	
        cell0.setCellValue("ID");
        cell1=row.createCell(1);
        
        cell1.setCellValue("Username");
        cell2=row.createCell(2);
        cell2.setCellValue("password");
        cell3=row.createCell(3);
        cell3.setCellValue("SDT");
        cell4=row.createCell(4);
        cell4.setCellValue("Address");
        
        int i=0;
        
        for (User acc : list) {
        	i=i+1;
        			 row=workSheet.createRow(i);
        			 cell0=row.createCell(0);
        		     cell0.setCellValue(acc.getUserid());
        		     cell1=row.createCell(1);
        		     cell1.setCellValue(acc.getUsername());
        		     cell2=row.createCell(2);
        		     cell2.setCellValue(acc.getPassword());
        		     cell3=row.createCell(3);
        		     cell3.setCellValue(acc.getuPhone());	
        		     cell4=row.createCell(4);
        		     cell4.setCellValue(acc.getAddress());	
        }
               
        
        workbook.write(file);
        workbook.close();
        file.close();
        
        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("manageaccount").forward(request, response); 
		} catch (IOException e) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

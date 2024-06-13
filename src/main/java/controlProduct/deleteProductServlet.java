package controlProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.*;
import model.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteproduct")
public class deleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteProductServlet() {
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
			int orderId = Integer.parseInt(request.getParameter("ProID"));
			System.out.println(orderId);
			ProductDAO proDao = new ProductDAO();
			if (orderId!=-1)
			{
			proDao.updateOrder(orderId);
			request.getRequestDispatcher("productManage").forward(request, response);
			System.out.println("OKKKK");}
			else
			{
				List<Product> listPro = proDao.getAll();
				for (Product pro : listPro) {
					proDao.updateOrder(pro.getpId());
				}
				System.out.println("cl");
				request.getRequestDispatcher("productManage").forward(request, response);
			}
		

		} catch (Exception e) {
			e.printStackTrace();
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

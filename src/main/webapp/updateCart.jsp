 <%@page import="model.Cart"%>
<%@page import="dao.ProductDAO"%>
<%@page import="model.CartDetail"%>
<%@page import="java.util.List"%>
<%@page import="dao.CartDetailDAO"%>
<%@page import="dao.CartDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BKN - SHOES</title>
    <link rel="stylesheet" href="css/style1.css">
    <link rel="shortcut icon" href="image/logo.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/pay.css">
</head>
<body>
		<%
		CartDAO cartDAO = new CartDAO();	
        CartDetailDAO cartDetailDAO = new CartDetailDAO();
        int userId = (int) session.getAttribute("userID");
        Cart cart = cartDAO.getCartByUserId(userId);
        int CartIdKey = cart.getCartId();
        ProductDAO productDAO = new ProductDAO();
        
        List<CartDetail> newcartDetails = cartDAO.getCartDetailsByCartId(CartIdKey, productDAO);
        HttpSession session2 = request.getSession();
		session2.removeAttribute("cartDetail");
	    
	    session2.setAttribute("cartDetail2", newcartDetails);
		%>
		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	%>
		
</body>

</html>
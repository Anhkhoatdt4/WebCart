<%@page import="repository.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@page import="model.CartDetail"%>
<%@page import="java.util.List"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BKN - SHOES Thanh toán thành công</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 455px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
            position: relative;
            height: 280px;
            animation: slideInFromLeft 0.5s ease-in-out forwards;
        }

        @keyframes slideInFromLeft{
            0%{
                opacity: 0;
                transform: translateX(-100%);
            }
            100% {
                opacity: 1; 
                transform: translateX(0); 
            }
        }

        .container img {
            width: 100px;
            height: auto;
            position: absolute;
            top: 15px;
            left: 48%;
            transform: translateX(-50%);
        }

        .order-id {
            font-size: 18px;
            margin-top: 10px;
        }
        .button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #ffa500;
            color: #ffffff;
            text-decoration: none;
        }
        .button + .button {
            margin-left: 10px;
        }

        .ads{
            margin-top: 105px;
        }

    </style>
</head>
<body>
	<div class="container">
        <div>
            <img src="https://img.pikbest.com/origin/09/23/74/05gpIkbEsT4UV.png!sw800" alt="">
        </div>
        <div class="ads">
            <h2>Thanh toán thành công</h2>
            
            
            
            <p class="order-id" >Mã đơn hàng: ${sessionScope.madonhangg} trị giá:<strong>$ ${trigiadonhang}</strong></p>
            <a href="home" class="button" style="background: linear-gradient(to right, #c72092, #6c14d0);">Tiếp tục mua sắm</a>
            <a href="orderManage" class="button" style="background: linear-gradient(to right, #c72092, #6c14d0);">Chi tiết đơn hàng</a>
            
            <%
           		int orderId = Integer.parseInt( session.getAttribute("madonhangg").toString());
            	OrderDAO orderDAO = new OrderDAO();
            	orderDAO.updateOrderStatus(orderId, "Đang vận chuyển");
            %>
        </div>
    </div>

</body>
</html>
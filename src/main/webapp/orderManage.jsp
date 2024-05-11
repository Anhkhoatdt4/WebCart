<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BKN - SHOES</title>
    <link rel="stylesheet" href="css/orderManage.css">
    <link rel="shortcut icon" href="image/logo.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
<header>
        <nav>
            <ul style="
            display: flex;
            justify-content: space-between;
            width: 600px;
            margin-left: 150px;
            font-size: 18px;">
                <li><a href="home">Trang chủ</a></li>
                <li><a href="home">Nike</a></li>
                <li><a href="home#About">Giới thiệu</a></li>
                <li><a href="https://www.facebook.com/itmediadut">Liên hệ</a></li>
            </ul>
            <ul style="   
                margin-right: 100px;
                display: flex;
                justify-content: flex-end;
                width: 264px;
                margin-left: auto;
                margin-top: -20px;
                font-size: 18px;">
				<li><a href="cart.jsp"><i class="fa-solid fa-cart-shopping" style="font-size: 21px; margin-top: -6px;"></i></a></li>
				<li><a href="Account.jsp"><i class="fa-solid fa-circle-user" style="font-size: 21px; margin-top: -6px;"></i></a></li>
				<li>
				    <a href="#" style="font-size: 18px; margin-top: -3px;">
				        <c:choose>
				            <c:when test="${empty sessionScope.username}">
				                <a href="login.jsp" style="text-decoration: none; color: black;">
				                    <i class="fa-solid fa-user"></i> Đăng nhập
				                </a>
				            </c:when>
				            <c:otherwise>
				                <a class="user-link" style="text-decoration: none; color: black; position: relative;">
				                    <i class="fa-solid fa-user"></i> ${sessionScope.username}
				                </a>
				            </c:otherwise>
				        </c:choose>
				    </a>
				</li>

            </ul>
        </nav>
    </header>
    <div class ="container">
        <div class="menu" style="min-height: 600px; position: relative;">
            <div class="menu-form">
                <ul class="information">
                    <li><i class="fa-solid fa-play" style="font-size: 13px;"></i> <a href="Account.jsp">Cập nhật tài khoản</a></li>
                    <li onclick="toggleMyOrder()"> <i class="fa-solid fa-play" style="font-size: 13px;" ></i> <a href="#">Đơn hàng của tôi</a>
                        <ul class="myorder">
                            <li><a href="orderManage">Chờ xác nhận</a></li>
                            <li><a href="orderTransit">Đang vận chuyển</a></li>
                            <li><a href="orderDelivered">Đã giao hàng</a></li>
                            <li><a href="orderCancelled">Đã hủy</a></li>
                        </ul>
                    </li> 
                </ul>
                <div  class="logout" style="position: absolute; bottom: 0; right: -10px;">
                 	 <li><a href="logout" style="padding: 0 5px;"><i class="fa-solid fa-right-from-bracket"></i></a></li>
			        <a href="logout" style="text-decoration: none ; color: red ; font-size: 18px;">Đăng xuất </a>
			    </div>
            </div>
            <div class = "text"></div>
        </div>
     <div class="content">
		 <div class="product-form">
    <div class="customer-info">
        <ul>
            <li>Danh sách đơn hàng</li>
            <div class="products">
                <c:set var="prevOrderId" value="" />
                <c:forEach var="order" items="${listOrderDetailsInOrder}">
                    <c:if test="${order.orderId != prevOrderId}">
                        <c:set var="prevOrderId" value="${order.orderId}" />
	                        <div class = "a" style="    position: relative;
								    top: 40px;
								    z-index: 2;
								    color: #eb6363;">
                        	<h2>Mã đơn hàng: ${order.orderId}</h1> 
                        </div>
                    </c:if>
                    <div class="detail-product">
                        <div class="product-info">
                            <div class="status" style="position: absolute; top: 51px; right: 16px; color: #14d414; font-size: 17px;">
                                <span>${Status}</span>
                            </div>
                            <c:forEach var="product" items="${listProductInOrder}">
                                <c:if test="${product.pId eq order.productID}">
                                    <img src="${product.pimage}" alt="" style="width: 110px ; height: 110px;">
                                    <div class="title-quantity">
                                        <h1>${product.pname}</h1>
                                        <h3>${product.pprice}</h3>
                                        <h4>Tổng số sản phẩm : ${order.quantity}</h4>
                                    </div>
                                    <div class="price">
                                        <h2 class="price">Thành tiền</h2>
                                        <h5 class="price">${order.price}</h5>
                                    </div>
                                    <div class="evaluate" style="position: absolute; right: 10px; top: 250px;">
                                        <button>Đánh giá</button>
                                        <button>Mua lại</button>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </ul>
    </div>
</div>



</div>
    </div>
</body>
</html>

<style>
    .myorder {
        display: none;
    }
    .myorder.active {
        display: block;
    }
</style>
<script>
    function toggleMyOrder() {
        var myorder = document.querySelector('.myorder');
        myorder.classList.toggle('active');
    }
</script>
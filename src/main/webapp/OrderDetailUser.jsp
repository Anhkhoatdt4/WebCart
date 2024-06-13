<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<link rel="stylesheet" href="css/OrderDetailUser.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<header>
		<nav>
			<ul
				style="display: flex; justify-content: space-between; width: 600px; margin-left: 150px; font-size: 18px;">
				 <li><a href="home">Trang chủ</a></li>
                <li><a href="home">Nike</a></li>
                <li><a href="home#About">Giới thiệu</a></li>
                <li><a href="https://www.facebook.com/itmediadut">Liên hệ</a></li>
			</ul>
			<ul
				style="margin-right: 100px; display: flex; justify-content: flex-end; width: 288px; margin-left: auto; margin-top: -20px; font-size: 18px;">
				<li><a href="#"><i class="fa-solid fa-cart-shopping"
						style="font-size: 21px; margin-top: -6px;"></i></a></li>
				<li><a href="#"><i class="fa-solid fa-circle-user"
						style="font-size: 21px; margin-top: -6px;"></i></a></li>
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
	<div class="container">
		<div class="menu" style="min-height: 600px;">
			<div class="menu-form">
				<ul class="information">
					<li><i class="fa-solid fa-play" style="font-size: 13px;"></i>
						<a href="Account.jsp">Thông tin tài khoản</a></li>
					<li onclick="toggleMyOrder()"><i class="fa-solid fa-play"
						style="font-size: 13px;"></i> <a href="#">Đơn hàng của tôi</a>
						<ul class="myorder">
							<li><a href="orderManage">Chờ xác nhận</a></li>
                            <li><a href="orderTransit">Đang vận chuyển</a></li>
                            <li><a href="orderDelivered">Đã giao hàng</a></li>
                            <li><a href="orderCancelled">Đã hủy</a></li>
						</ul></li>
				</ul>
				<ul class="logout" style="float: right; margin-right: 10px;">
					<li><a href="#"><i class="fa-solid fa-right-from-bracket"></i></a></li>
					<li><a href="logout">Đăng xuất </a></li>
					
				</ul>
			</div>
			<div class="text"></div>
		</div>
		<div class="merge">
			<div class="order">
				<ul>
					<c:set var="order" value="${order}" />
					<li>Sản phẩm</li>
					<id style="margin-left: 20px; margin-top: 20px;">Mã đơn hàng:
					${order.orderId}</id>
				</ul>

				
					<div class="product">
						<div class="detail-product">
				<c:forEach var="entry" items="${listProduct}">
					<c:set var="product" value="${entry.key}" />
							<div class="product-info">
								<img src="${product.pimage}" alt="${product.pname}" style="width: 150px;">
									<div class="title-quantity">
										<h1>${product.pname}</h1>
										<h1>Số lượng : ${entry.value}</h1>
									</div>
									<div class="price">
										<h2 class="price">$ ${product.pprice}</h2>
									</div>
							</div>
				</c:forEach>
				
													<c:set var="order" value="${order}" />
				
							<div class="total-price">
								<h1 style="margin-left: 250px; margin-top: 22px;">Tổng tiền</h1>
								<h2 class="tongtien"
									style="width: 192px; height: 50px; margin-top: -35px; margin-left: 546px;">
									$ ${order.totalMoney}</h2>
							</div>
						</div>
					</div>
			

			</div>
			<div class="detail">
			      <h1>${order.status}</h1>
				    <p class="detail-label">Tên khách hàng:</p>
				    <p class="detail-info">${order.user.username}</p>
				    <p class="detail-label">Số điện thoại:</p>
				    <p class="detail-info">${order.user.uPhone}</p>
				    <p class="detail-label">Địa chỉ:</p>
				    <p class="detail-info">${order.user.address}</p>
				    <p class="detail-label">Thời gian đặt hàng:</p>
				    <p class="detail-info">${order.date}</p>
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
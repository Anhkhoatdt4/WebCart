<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<link rel="stylesheet" href="css/OrderDetailAdmin.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<div class="header">
		<ul
			style="display: flex; margin-left: 300px; margin-top: -8px; font-size: 15px;">
			<li>Trang chủ</li>
			<li>Sản phẩm</li>
			<li>Khuyến mãi</li>
			<li>Liên hệ</li>
		</ul>
		<ul>
			<li><a href="#"><i class="fa-solid fa-right-from-bracket"></i></a></li>
		</ul>
	</div>
	<div class="container">
		<div class="menu">
			<ul>
				<li><a href="#"><img
						src="https://i.pinimg.com/originals/78/46/75/7846752cfd7b02455fa07c42a5ab2f37.jpg"
						class="image" alt=""></img></a></li>
				<br>
				<li>Kong Bẻo</li>
				<li>Chào mừng bạn trở lại</li>
				<br>
				<br>
				<hr>
				<br>
						<h1><a href="ControlManage"><button class="but0"><i class="fa-solid fa-landmark"></i> Bảng điều khiển</button></a></h1>
	                    <h1><a href="manageaccount"><button class="but1"><i class="fa-solid fa-id-card"></i> Quản lý khách hàng</button></a></h1>
	                    <h1><a href="productManage"><button class="but2"><i class="fa-solid fa-box"></i> Quản lý sản phẩm</button></a></h1>
	                    <h1><a href="DHangManage"><button class="but3"><i class="fa-solid fa-money-bill-1"></i> Quản lý đơn hàng</button></a></h1>
	                    <h1><a href="reportManage"><button class="but4"><i class="fa-solid fa-money-check-dollar"></i> Báo cáo doanh thu</button></a></h1>
			</ul>
		</div>
		<div class="main">
			<div class="time">
				<ul style="display: flex; margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 10px; font-weight: bold; font-size: 14px;">Chi
						tiết đơn hàng</li>
				</ul>
				<ul style="display: flex; float: right; margin-right: 30px;">
					<li
						style="list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;">Thứ
						3, 09/04/2024 - 17:05:10</li>
				</ul>
			</div>
		<div class="merge-detail" style="display: flex;">
			<div class="merge" style="width: 840px ; height: 780px;">
				<div class="order">
							<ul>
								<c:set var="order" value="${order}" />
								<li style=" padding-top: 15px;">Sản phẩm</li>
								<id style="margin-left: 20px;  margin-top: 20px; font-size : 18px;" >Mã đơn hàng:
								${order.orderId}</id>
							</ul>


							<c:forEach var="entry" items="${listProduct}">
								<c:set var="product" value="${entry.key}" />
								<div class="product">
									<div class="detail-product">
		
										<div class="product-info">
											<img src="${product.pimage}" alt="${product.pname}">
											<div class="title-quantity">
												<h1 style="font-size: 18px;">${product.pname}</h1>
												<h1>Số lượng : ${entry.value}</h1>
											</div>
											<div class="price">
												<h2 class="price">$ ${product.pprice}</h2>
											</div>
										</div>
		
									</div>
								</div>	
							</c:forEach>
							
							<c:set var="order" value="${order}" />
							<div class="total-price">
								<h2 style="margin-left: 250px; margin-top: 22px;">Tổng tiền</h2>
								<h2 class="tongtien"
									style="width: 192px; height: 50px;   margin-top: -32px; margin-left: 592px;">
									$ ${order.totalMoney}</h2>
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
				    <p class="detail-label">Phương thức thanh toán:</p>
				    <p class="detail-info">Thanh toán khi nhận hàng</p>
				    <p class="detail-label">Thời gian đặt hàng:</p>
				    <p class="detail-info">${order.date}</p>
			</div>
		</div>
	  </div>
	</div>
</body>
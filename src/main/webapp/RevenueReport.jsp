<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Báo cáo doanh thu</title>
<link rel="stylesheet" href="css/RevenueReport.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.umd.min.js"></script>
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
				<h1>
					<a href="ControlManage"><button class="but0">
							<i class="fa-solid fa-landmark"></i> Bảng điều khiển
						</button></a>
				</h1>
				<h1>
					<a href="manageaccount"><button class="but1">
							<i class="fa-solid fa-id-card"></i> Quản lý khách hàng
						</button></a>
				</h1>
				<h1>
					<a href="productManage"><button class="but2">
							<i class="fa-solid fa-box"></i> Quản lý sản phẩm
						</button></a>
				</h1>
				<h1>
					<a href="DHangManage"><button class="but3">
							<i class="fa-solid fa-money-bill-1"></i> Quản lý đơn hàng
						</button></a>
				</h1>
				<h1>
					<a href="reportManage"><button class="but4">
							<i class="fa-solid fa-money-check-dollar"></i> Báo cáo doanh thu
						</button></a>
				</h1>
			</ul>
		</div>
		<div class="main">
			<div class="time">
				<ul style="display: flex; margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 10px; font-weight: bold; font-size: 14px;">Báo
						cáo doanh thu</li>
				</ul>
				<ul id="currentTime"
					style="display: flex; float: right; margin-right: 30px;">
					<li
						style="list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;">Thứ
						3, 09/04/2024 - 17:05:10</li>
				</ul>
				<script type="text/javascript">
					function updateTime() {
						var currentDate = new Date();
						var formattedDate = currentDate.toLocaleString('vi-VN',
								{
									weekday : 'long',
									year : 'numeric',
									month : '2-digit',
									day : '2-digit',
									hour : '2-digit',
									minute : '2-digit',
									second : '2-digit'
								});
						document.getElementById('currentTime').innerHTML = "<li style='list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;'>"
								+ formattedDate + "</li>";
					}

					setInterval(updateTime, 1000);

					updateTime();
				</script>

			</div>

			<div class="sumofproduct" style="display: flex;">
				<ul style="margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px; color: red;">Tổng
						sản phẩm</li>
					<li style="list-style-type: none; font-size: 14px;"><span>${tongsanpham}</span>
						sản phẩm</li>
				</ul>
				<ul>
					<li
						style="list-style-type: none; margin-left: 40px; margin-top: 28px; font-size: 40px; color: #22ad56;"><a><i
							class="fa-solid fa-tag"></i></a></li>
				</ul>
			</div>
			<div class="sumoforder" style="display: flex;">
				<ul style="margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px; color: red;">Tổng
						đơn hàng</li>
					<li style="list-style-type: none; font-size: 14px;"><span>${tongdonhang}</span>
						đơn hàng</li>
				</ul>
				<ul>
					<li
						style="list-style-type: none; margin-left: 40px; margin-top: 28px; font-size: 40px; color: #1d5aab;"><a><i
							class="fa-solid fa-box"></i></a></li>
				</ul>
			</div>
			<div class="sumofmoney" style="display: flex;">
				<ul style="margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px; color: red;">Tổng
						thu nhập</li>
					<li style="list-style-type: none; font-size: 14px;">$
						${tongtien}</li>
				</ul>
				<ul>
					<li
						style="list-style-type: none; margin-left: 40px; margin-top: 28px; font-size: 40px; color: #ff8b07;"><a><i
							class="fa-solid fa-money-bill-1"></i></a></li>
				</ul>
			</div>
			<div class="outofstock" style="display: flex;">
				<ul style="margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px; color: red;">Hết
						hàng</li>
					<li style="list-style-type: none; font-size: 14px;">2 sản phẩm</li>
				</ul>
				<ul>
					<li
						style="list-style-type: none; margin-left: 80px; margin-top: 28px; font-size: 40px; color: #de2222;"><a><i
							class="fa-solid fa-triangle-exclamation"></i></a></li>
				</ul>
			</div>
			<div class="topsales" style="height: 330px;">
				<ul style="display: flex; margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">SẢN
						PHẨM BÁN CHẠY TRONG NGÀY</li>
				</ul>
				<br>
				<hr>
				<br> <br>
				<table class="custom-table" style="margin-left: 30px;">
					<thead>
						<tr>
							<th>Mã sản phẩm</th>
							<th>Tên sản phẩm</th>
							<th>Giá tiền</th>
							<th>Số lượng</th>
							<th>Danh mục</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${sanphambanchaytrongngay}">

							<tr>
								<td>${c.pId}</td>
								<td>${c.pname}</td>
								<td>$ ${c.pprice}</td>
								<td>${c.pquantity}</td>
								<c:forEach var="d" items="${danhmuc}">
									<c:if test="${c.category_id == d.cid}">
										<td>${d.cname}</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="stock" style="height: 510px;">
				<ul style="display: flex; margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">SẢN
						PHẨM BÁN CHẠY TRONG THÁNG</li>
				</ul>
				<br>
				<hr>
				<br> <br>
				<div style="overflow-x: auto; overflow-y: auto; max-height: 400px;">
					<table class="stock-table" style="margin-left: 30px;">
						<thead>
							<tr>
								<th>Mã sản phẩm</th>
								<th>Tên sản phẩm</th>
								<th>Ảnh</th>
								<th>Số lượng</th>
								<th>Giá tiền</th>
								<th>Danh mục</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="entry" items="${sanphamtrongthang}">
								<c:set var="product" value="${entry.key}" />
								<c:set var="quantity" value="${entry.value}" />
								<tr>
									<td>${product.pId}</td>
									<td>${product.pname}</td>
									<td style="width: 200px;"><img alt=""
										src="${product.pimage}" style="width: 55%; height: 48%;">
									</td>

									<td style="width: 100px;">${quantity}</td>
									<td>$ ${product.pprice}</td>
									<c:forEach var="d" items="${danhmuc}">
										<c:if test="${product.category_id == d.cid}">
											<td>${d.cname}</td>
										</c:if>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>


			<div class="sumoforder2" style="height: 520px; margin-left: 20px;">
				<ul style="display: flex; margin-left: 30px;">
					<li
						style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">TỔNG
						ĐƠN HÀNG</li>
				</ul>
				<br>
				<hr>
				<br> <br>
				<div style="overflow-x: auto; overflow-y: auto; max-height: 400px;">
					<table class="order-table" style="margin-left: 30px;">
						<thead>
							<tr>
								<th>ID đơn hàng</th>
								<th>Tên khách hàng</th>
								<th>Đơn hàng</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="DL" items="${dataList}">
								<c:forEach var="khct" items="${dskhachhangchitiet2}">
									<c:if test="${DL[2] == khct.userId}">
										<c:forEach var="dssp" items="${dssanpham2}">
											<c:if test="${DL[4] == dssp.pId}">
												<tr>
													<td style="width: 150px;">${DL[0]}</td>
													<td>${khct.fullname}</td>
													<td>${dssp.pname}</td>
													<td style="width: 100px;">${DL[5]}</td>
													<td>${DL[1]}</td>
												</tr>
											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>
							</c:forEach>
							<td colspan="4" style="font-weight: bold;">Tổng cộng:</td>
							<td>$ ${tongtien}</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="stock"
					style="margin-left: 0px; height: 402px; border-radius: 5px; margin-top: 47px;">
					<ul style="display: flex; margin-left: 30px;">
						<li
							style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">SẢN
							PHẨM HẾT HÀNG</li>
					</ul>
					<br>
					<hr>
					<br> <br>
					<div style="overflow-x: auto; overflow-y: auto; max-height: 400px;">
						<table class="stock-table" style="margin-left: 30px;">
							<thead>
								<tr>
									<th style="width: 18%;">Mã sản phẩm</th>
									<th style="width: 30%;">Tên sản phẩm</th>
									<th>Ảnh</th>
									<th>Số lượng</th>
									<th>Tình trạng</th>
									<th>Giá tiền</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>29</td>
									<td>GIÀY NIKE AIR JORDAN 1 LOW NAM - XANH ĐEN</td>
									<td style="width: 200px;"><img
										style="height: 100px; width: 127px;"
										src="https://myshoes.vn/image/catalog/2023/nike/nike02/giay-air-jordan-1-low-nam-xanh-den-01.jpg"></td>
									<td>0</td>
									<td>Hết hàng</td>
									<td>$ 200</td>
								</tr>
								<tr>
									<td>34</td>
									<td>Giày Nike Dunk Low Retro White Black Panda DD1391-100</td>
									<td style="width: 200px;"><img
										style="height: 100px; width: 127px;"
										src="https://product.hstatic.net/200000581855/product/giay_nike_dunk_low_retro_white_black_panda_dd1391-1007_c9bb92bc44374458a4d6d896a0350d83_master.png"></td>
									<td>0</td>
									<td>Hết hàng</td>
									<td>$ 300</td>
								</tr>
							</tbody>
						</table>
					</div>


					<%
					// Lấy mảng doanh thu từ session
					double[] loinhuan = (double[]) session.getAttribute("loinhuantuannay");

					// Khởi tạo một chuỗi để lưu trữ các giá trị của mảng doanh thu
					StringBuilder loinhuanString = new StringBuilder();
					for (int i = 0; i < loinhuan.length; i++) {
						loinhuanString.append(loinhuan[i]);
						if (i < loinhuan.length - 1) {
							loinhuanString.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="loinhuantuanNay"
						value="<%=loinhuanString.toString()%>" />

<%
					// Lấy mảng doanh thu từ session
					double[] loinhuan2 = (double[]) session.getAttribute("loinhuantuantruoc");

					// Khởi tạo một chuỗi để lưu trữ các giá trị của mảng doanh thu
					StringBuilder loinhuanString2 = new StringBuilder();
					for (int i = 0; i < loinhuan2.length; i++) {
						loinhuanString2.append(loinhuan2[i]);
						if (i < loinhuan2.length - 1) {
							loinhuanString2.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="loinhuantuanTruoc"
						value="<%=loinhuanString2.toString()%>" />


					<%
					//lay ra so luong cua tung hang giay
					int[] loaigiay = (int[]) session.getAttribute("loaigiay");

					// Khởi tạo một chuỗi để lưu trữ các giá trị của mảng doanh thu
					StringBuilder loaigiayString = new StringBuilder();
					for (int i = 0; i < loaigiay.length; i++) {
						loaigiayString.append(loaigiay[i]);
						if (i < loaigiay.length - 1) {
							loaigiayString.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="loaigiay"
						value="<%=loaigiayString.toString()%>" />

					<div class="merge" style="margin-top: 40px; padding-bottom: 60px;">
						<div class="chart" style="margin-left: 4px; height: 400px; co">
							<ul style="display: flex; margin-left: 30px;">
								<li
									style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">SO
									SÁNH LỢI NHUẬN TRONG TUẦN</li>
							</ul>
							<br>
							<hr>
							<br> <br>
							<canvas id="canvas"></canvas>
						</div>
						<!-- <script src="script/script.js"></script> -->

						<div class="chart2" style="height: 400px; position: relative;">
    <ul style="display: flex; margin-left: 30px;">
        <li style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">THỐNG KÊ SỐ GIÀY BÁN ĐƯỢC CỦA CÁC HÃNG</li>
    </ul>
    <br>
    <hr>
    <br>
    <br>
    <canvas id="barne" style="display: block; box-sizing: border-box; height: 30px; width: 300px; position: absolute; left: 100px; top: 75px;"></canvas>
</div>


					
						<!--  <script src="script/newchart.js"></script> -->
					</div>
				</div>
			</div>
		</div>

		<script>
			function createChart() {
				const doubleArrayInput = document.getElementById('loinhuantuanNay');
				const doubleArrayString = doubleArrayInput.value;
				// Chuyển đổi chuỗi thành mảng số
				const doubleArray = doubleArrayString.split(',').map(Number);
				doubleArray.shift();
				const doubleArrayInput1 = document
						.getElementById('loinhuantuanTruoc');
				const doubleArrayString1 = doubleArrayInput1.value;
				// Chuyển đổi chuỗi thành mảng số
				const doubleArray1 = doubleArrayString1.split(',').map(Number);
				doubleArray1.shift();

				const labels = [ 'Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm',
						'Thứ sáu', 'Thứ bảy', 'Chủ nhật' ];
				const data = {
					labels : labels,
					datasets : [ {
						label : 'Tuần này',
						backgroundColor : 'blue',
						borderColor : 'blue',
						data : doubleArray,
						tension : 0.4,
					}, {
						label : 'Tuần trước',
						backgroundColor : 'red',
						borderColor : 'red',
						data : doubleArray1,
						tension : 0.4,
					}, ],
				};
				console.log('Đã tạo biểu đồ và thực hiện các xử lý tùy chỉnh.');

				console.log(doubleArray);
				const config = {
					type : 'line',
					data : data,
				};
				const canvas = document.getElementById('canvas');
				const chart = new Chart(canvas, config);

				console.log('Đã tạo biểu đồ và thực hiện các xử lý tùy chỉnh.');
			}

			
			function createChart1() {
				const intArrayInput = document.getElementById('loaigiay');
				const intArrayString = intArrayInput.value;
				// Chuyển đổi chuỗi thành mảng số
				const intArray = intArrayString.split(',').map(Number);
				intArray.shift();
				
				const labels = ['Nike', 'Adidas','Puma',  'Lacoste'];
				const data = {
				    labels: labels,
				    datasets: [
				        {
				            backgroundColor: ['blue', 'green', 'red', 'orange'],
				            data: intArray,
				        },
				    ],
				};
				console.log(intArray);

				const config = {
				    type: 'pie',
				    data: data,
				};
				const barne = document.getElementById('barne');
				barne.width = 300; 
				barne.height = 300; 
				const chart = new Chart(barne, config);

			}
			window.onload = function() {
				createChart1();
				createChart();

			};
		</script>
</body>
</html>
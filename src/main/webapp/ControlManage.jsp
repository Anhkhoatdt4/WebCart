<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bảng điều khiển</title>
<link rel="stylesheet" href="css/ControlManage.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.umd.min.js"></script>
    
</head>
<body>
        <div class ="header">
            <ul style="
            display: flex;
            margin-left: 300px;
            margin-top: -8px;
            font-size: 15px;">
                <li class = "trangchu">Trang chủ</li>
                <li >Sản phẩm</li>
                <li>Khuyến mãi</li>
                <li>Liên hệ</li>
            </ul>
            <ul>
                <li><a href="#"><i class="fa-solid fa-right-from-bracket"></i></a></li>
            </ul>
        </div>
        <div class ="container">
            <div class ="menu" style="height: auto;">
                <ul>
                    <li><a href="#"><img src="https://i.pinimg.com/originals/78/46/75/7846752cfd7b02455fa07c42a5ab2f37.jpg"  class ="image" alt=""></img></a></li>
                    <br>
            		<li class="fa-solid fa-user" style ="margin-left: 60px; margin-bottom: 10px; margin-right: 5px; color: white; font-size:12px"> ${sessionScope.username}</li> 
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
			            <li style="list-style-type: none; margin-top: 10px; font-weight: bold; font-size: 14px;">Bảng điều khiển</li>
			        </ul>
			        <ul id="currentTime" style="display: flex; float: right; margin-right: 30px;">
			            <li style="list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;">Thứ 3, 09/04/2024 - 17:05:10</li>
			        </ul>
			        <script type="text/javascript">
					function updateTime() {
				        var currentDate = new Date();
				        var formattedDate = currentDate.toLocaleString('vi-VN', { weekday: 'long', year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' });
				        document.getElementById('currentTime').innerHTML = "<li style='list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;'>" + formattedDate + "</li>";
				    }
			
				    setInterval(updateTime, 1000);
			
				    updateTime();
					</script>
			        
                </div>
                <div class="sumofproduct" style="display: flex;">
                    <ul style = "margin-left: 30px; ">
                        <li style ="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px;color: red;">Tổng sản phẩm</li>
                        <li style ="list-style-type: none; font-size: 14px;"><span>${tongsanpham}</span> sản phẩm</li>
                    </ul>
                    <ul>
                        <li style ="list-style-type: none; margin-left: 40px; margin-top: 28px; font-size:40px ;color: #22ad56;"><a><i class="fa-solid fa-tag"></i></a></li>
                    </ul>
                </div>
                <div class="sumoforder" style="display: flex;">
                    <ul style = "margin-left: 30px; ">
                        <li style ="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px; color: red;">Tổng đơn hàng</li>
                        <li style ="list-style-type: none; font-size: 14px;"><span>${tongdonhang}</span> đơn hàng</li>
                    </ul>
                    <ul>
                        <li style ="list-style-type: none; margin-left: 40px; margin-top: 28px; font-size:40px;color: #1d5aab;"><a><i class="fa-solid fa-box" ></i></a></li>
                    </ul>
                </div>
                <div class="sumofmoney" style="display: flex;">
                    <ul style = "margin-left: 10px; ">
                        <li style ="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px;color: red;">Tổng khách hàng</li>
                        <li style ="list-style-type: none; font-size: 14px;"><span>${tongkhachhang}</span> khách hàng</li>
                    </ul>
                    <ul>
                        <li style ="list-style-type: none; margin-left: 30px; margin-top: 28px; font-size:40px;color: #ff8b07;"><a><i class="fa-solid fa-money-bill-1"></i></a></li>
                    </ul>
                </div>
                <div class="outofstock" style="display: flex;">
                    <ul style = "margin-left: 10px; ">
                        <li style ="list-style-type: none; margin-top: 25px; margin-bottom: 10px; font-weight: bold; font-size: 18px;color: red;">Sắp hết hàng</li>
                        <li style ="list-style-type: none; font-size: 14px;">3 sản phẩm</li>
                    </ul>
                    <ul>
                        <li style ="list-style-type: none; margin-left: 60px; margin-top: 28px; font-size:40px;color: #de2222; "><a><i class="fa-solid fa-triangle-exclamation"></i></a></li>
                    </ul>
                </div>
                <div class="merge">
                <div class="order">
				    <ul style="display: flex; margin-left: 30px; ">
				        <li style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">TÌNH TRẠNG ĐƠN HÀNG</li>
				    </ul>
				    <br>
				    <hr>
				    <br>
				    <br>
				    <div style="overflow-x: auto; overflow-y: auto; max-height: 300px;">
				        <table class="custom-table" style="margin-left: 30px;">
				            <thead>
				                <tr>
				                    <th>Mã đơn hàng</th>
				                    <th>Tên khách hàng</th>
				                    <th>Tổng tiền</th>
				                    <th>Trạng thái</th>
				                </tr>
				            </thead>
				            <tbody>
				                <c:forEach var="ds" items="${dsdonhang}">
				                    <c:forEach var="dsct" items="${dskhachhangchitiet}">
				                        <c:if test="${ds.userId eq dsct.userId}">
				                            <tr>
				                                <td style="width: 150px;">${ds.orderId}</td>
				                                <td>${dsct.fullname}</td>
				                                <td>$ ${ds.totalMoney}</td>
				                                <td><b>${ds.status}</b></td>
				                            </tr>
				                        </c:if>
				                    </c:forEach>
				                </c:forEach>
				            </tbody>
				        </table>
				    </div>
				</div>
                <div class="chart">
                    <ul style="display: flex; margin-left: 30px;">
                        <li style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">SO SÁNH DOANH THU TUẦN NÀY VÀ TUẦN TRƯỚC</li>
                    </ul>
                    <br>
                    <hr>
                    <br>
                    <br>
                    
                    <%
					// Lấy mảng doanh thu từ session
					double[] doanhthu = (double[]) session.getAttribute("doanhthu");

					// Khởi tạo một chuỗi để lưu trữ các giá trị của mảng doanh thu
					StringBuilder doanhthuString = new StringBuilder();
					for (int i = 0; i < doanhthu.length; i++) {
						doanhthuString.append(doanhthu[i]);
						if (i < doanhthu.length - 1) {
							doanhthuString.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="doubleArray"
						value="<%=doanhthuString.toString()%>" />
					<%
					double[] doanhthu1 = (double[]) session.getAttribute("doanhthu1");
					StringBuilder doanhthuString1 = new StringBuilder();
					for (int i = 0; i < doanhthu1.length; i++) {
						doanhthuString1.append(doanhthu1[i]);
						// Thêm dấu phẩy nếu không phải là phần tử cuối cùng
						if (i < doanhthu1.length - 1) {
							doanhthuString1.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="doubleArray1"
						value="<%=doanhthuString1.toString()%>" />


					<%
					double[] doanhthu2 = (double[]) session.getAttribute("doanhthumonth");
					StringBuilder doanhthuString2 = new StringBuilder();
					for (int i = 0; i < doanhthu2.length; i++) {
						doanhthuString2.append(doanhthu2[i]);
						// Thêm dấu phẩy nếu không phải là phần tử cuối cùng
						if (i < doanhthu2.length - 1) {
							doanhthuString2.append(",");
						}
					}
					%>

					<!-- Input ẩn để lưu trữ mảng doanh thu -->
					<input type="hidden" id="doubleArray2"
						value="<%=doanhthuString2.toString()%>" />
                    
                    
                    <canvas id="canvas"></canvas>
                </div>
                
                script
            </div>
	            <div class="merge2" ">
					    <div class="cus" style=" height:520px;" >
					        <ul style="display: flex; margin-left: 30px;">
					            <li style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">KHÁCH HÀNG MỚI</li>
					        </ul>
					        <br>
					        <hr>
					        <br>
					        <br>
					      <div style="overflow-x: auto; overflow-y: auto; max-height: 400px;">
					        <table class="cus-table" style="margin-left: 30px;">
					            <thead>
					                <tr>
					                    <th>ID khách hàng</th>
			                            <th>Tên khách hàng</th>
			                            <th>Địa chỉ</th>
			                            <th>Số điện thoại</th>
					                </tr>
					            </thead>
					            <tbody>
					                <c:forEach var="k1o" items="${dskhachhang}">
					                    <c:forEach var="k2p" items="${dskhachhangchitiet}">
					                        <c:if test="${k1o.userid eq k2p.userId}">
					                            <tr>
					                                <td>${k1o.userid}</td>
					                                <td style="font-size: 15px;">${k2p.fullname}</td>
					                                <td>${k1o.address}</td>
					                                <td>${k1o.uPhone}</td>
					                            </tr>
					                        </c:if>
					                    </c:forEach>
					                </c:forEach>
					            </tbody>
					        </table>
					        </div>
					    </div>
					

                <div class="chart2" style=" height:520px;">
                    <ul style="display: flex; margin-left: 30px;">
                        <li style="list-style-type: none; margin-top: 20px; font-weight: bold; font-size: 20px;">THỐNG KÊ DOANH THU 6 THÁNG GẦN ĐÂY</li>
                    </ul>
                    <br>
                    <hr>
                    <br>
                    <br>
                    <canvas id="barne"></canvas>
                     <!-- <script src="script/controlnewchar.js"></script>  -->
                </div>
            </div>              
            </div>
        </div>
        </div>
        
        <footer style="padding: 60px;"></footer>
        
</body>

<script type="text/javascript">
	document.querySelector(".trangchu").addEventListener("click",function(){
		window.location.href = "home";
	});
</script>


<script type="text/javascript">
function createChart() {
	const doubleArrayInput = document.getElementById('doubleArray');
	const doubleArrayString = doubleArrayInput.value;
	// Chuyển đổi chuỗi thành mảng số
	const doubleArray = doubleArrayString.split(',').map(Number);
	doubleArray.shift();
	const doubleArrayInput1 = document.getElementById('doubleArray1');
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
	const doubleArrayInput2 = document.getElementById('doubleArray2');
	const doubleArrayString2 = doubleArrayInput2.value;
	// Chuyển đổi chuỗi thành mảng số
		

	const doubleArray2 = doubleArrayString2.split(',').map(Number);
	//doubleArray2.shift();
			console.log( doubleArray2[3]);

	// Tạo một đối tượng Date đại diện cho thời gian hiện tại
	const currentDate = new Date();

	// Lấy ra tháng hiện tại (tính từ 0)
	const currentMonth = currentDate.getMonth() + 1; // Thêm 1 vì tháng tính từ 0 đến 11

	// Lấy ra năm hiện tại
	const currentYear = currentDate.getFullYear();
	
	console.log( currentMonth);
	console.log( currentYear);
	let labels=new Array();
	let data2=new Array();
	if (currentMonth>=6) 
		for (let i = 0; i <= 5; i++)
		{
			data2.push(doubleArray2[i]);
		labels.unshift('Tháng'+(currentMonth-i));
		console.log("cc" + currentMonth - i);
		}
	else 
		for (let i = 0; i <= 5; i++)
		{
			if (currentMonth-i>0)
			{
				data2.unshift(doubleArray2[currentMonth-i])
				console.log("a1");
				labels.unshift('Tháng'+(currentMonth-i));
				console.log("cc1" + (currentMonth - i));
				}
			else
				{
				data2.unshift(doubleArray2[12+(currentMonth-i)])
				console.log("a2");
				labels.unshift('Tháng'+(12+(currentMonth-i)));
				console.log("cc2" + (12+(currentMonth-i))-1);
				}
		}
	console.log(data2);

	const data = {
		labels : labels,
		datasets : [ {
			label : 'Doanh thu theo tháng',
			backgroundColor : 'blue',
			borderColor : 'blue',
			data : data2,
			tension : 0.4,
		}/* , {
			label : 'Thử 2 tí',
			backgroundColor : 'red',
			borderColor : 'red',
			data : [ 23, 45, 78, 69, 14, 32, 87, 56, 90, 18, 42, 61 ],
			tension : 0.4,
		}, */ ],
	}
	const config2 = {
		type : 'bar',
		data : data,
	}
	const barne = document.getElementById('barne')
	const chart = new Chart(barne, config2)
}
window.onload = function() {
	createChart();
	createChart1();

};
</script>

</html>
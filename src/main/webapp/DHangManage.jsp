<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý đơn hàng</title>
<link rel="stylesheet" href="css/DHang.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<body>
        <div class ="header">
            <ul style="
            display: flex;
            margin-left: 300px;
            margin-top: -8px;
            font-size: 15px;">
                <li>Trang chủ</li>
                <li>Sản phẩm</li>
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
	                    <h1><a href="manageaccount"><button class="but1"><i class="fa-solid fa-id-card"></i> Quản lý tài khoản</button></a></h1>
	                    <h1><a href="productManage"><button class="but2"><i class="fa-solid fa-box"></i> Quản lý sản phẩm</button></a></h1>
	                    <h1><a href="DHangManage"><button class="but3"><i class="fa-solid fa-money-bill-1"></i> Quản lý đơn hàng</button></a></h1>
	                    <h1><a href="reportManage"><button class="but4"><i class="fa-solid fa-money-check-dollar"></i> Báo cáo doanh thu</button></a></h1>
                </ul>
            </div>
        <div class =" mainn" style="margin-top: 45px;">
                <div class="button" >
                    
                    <button onclick="exportToExcel()"
					style="background-color: #008c04; border: #008c04; color: #a2ecb5; width: 100px; height: 40px;">
					<i class="fa-solid fa-file-excel"></i> Xuất Excel
				</button>
                   <button id = "save"
					style="background-color: rgb(235 25 25); border: #008c04; color: #a2ecb5; width: 100px; height: 40px;">
					<i class="fa-solid fa-floppy-disk"></i></i> Lưu thay đổi
				</button>
                </div>
                <br>
                <hr class ="line">
                <br>
                <div class=" find">
                    <li>Tìm kiếm:</li>
                    <li><input id = "searchInput" type="text" style=" border-radius: 8px; height: 25px; margin-top: -30px; background-color: rgb(234, 233, 233); " required placeholder="Kong Bẻo"></li>
                </div>
                <br>
                <br>
                <br>
                <br>
                <div>
                
                   <div class = "option" 
                  style=" 
                  display: flex;
					    text-align: center;
					    position: relative;
					    width: 30%;
					    height: 29px;
					    top: -55px;
					">
					<p style="    
										text-align: center;
					    margin: 3px;
					    margin-right: 25px;
					    font-size: 19px;
					    font-weight: 700;
					    color: #0e66c0;
					    text-decoration: underline;">Danh mục trạng thái</p>
               			 <select id = "statusSelect" style="border-radius: 7px;">
							<option>Tất cả</option>
                          	<option>Chờ xác nhận</option>
	      					<option>Đang vận chuyển</option>
						    <option>Đã giao hàng</option>
							<option>Đã hủy</option>
                         </select>
                  </div>      
                            
                            
                    <table class="custom-table">
                        <thead>
                          <tr style="height: 53px;">
                            <th style="width: 12%;">Mã đơn hàng</th>
                            <th style="width: 16%;">Tên khách hàng</th>
                            <th style="font-size: 15px;  width: 31%;"> Sản phẩm</th>
                            <th style="width: 9%;">Số lượng</th>
                            <th style="width: 10%;">Thành tiền</th>
                            <th style="width: 12%;">Tình trạng</th>
                            <th style="width: 9%;">Chức năng</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach var = "DL" items ="${dataList}">
                        <c:forEach var = "khct" items = "${khachhangchitiet1}">
                        	 <c:if test="${DL[2] == khct.userId}">
	                        	 <c:forEach var = "dssp" items = "${dssanpham1}">
	                        	 <c:if test="${DL[4] == dssp.pId}">
                          <tr>
	                            <td style="width: 150px;">${DL[0]}</td>
	                            <td>${khct.fullname}</td>
	                            <td>${dssp.pname }</td>
	                            <td style="width: 100px;">${DL[5]}</td>
	                            <td>${DL[1]}</td>
	                            <td>${DL[3]}</td>
	                             <td style="width: 100px;">
	                                <!-- <a href="#" class= "delete-btn"><i class="fa-solid fa-trash" style="padding : 0 5px;"></i></a> -->
						            <a href="#" class= "edit-btn"  ><i class="fa-solid fa-pen-to-square" style="padding : 0 5px;"></i></a>
	                            	<a href="#" class= "detail-btn"  ><i class="fa-solid fa-magnifying-glass" style="padding : 0 5px;"></i></a>
	                            </td>
                            </tr>
                            	</c:if>
                            </c:forEach>
                            </c:if>
                            </c:forEach>
                           </c:forEach>
                        </tbody>
                      </table>
                </div>
        </div>
    </div>
   

   
</body>

<!-- <script>
    // Hàm để cập nhật thời gian vào thẻ <li>
    function updateTime() {
        var currentDate = new Date();
        var formattedDate = currentDate.toLocaleString('vi-VN', { weekday: 'long', year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' });
        document.getElementById('currentTime').innerHTML = "<li style='list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;'>" + formattedDate + "</li>";
    }

    setInterval(updateTime, 1000);

    updateTime();
</script> -->

<script type="text/javascript">

function exportToExcel() {
   
    var month = prompt("Nhập tháng muốn xuất (VD: 1 - tháng 1, 2 - tháng 2, ...):");
    if (month !== null && month !== "") {
        window.location.href = "XuatExcelOrder?month=" + month;
        alert("Đã xuất file Excel thành công!");
    } else {
        alert("Bạn đã hủy việc xuất file Excel.");
    }
}


	document.getElementById("statusSelect").addEventListener("change",function(){
		var selectedStatus = this.value;
		console.log(selectedStatus);
		document.querySelectorAll(".custom-table tbody tr").forEach(function(row){
			var statusCell = row.querySelector("td:nth-child(6)").textContent.trim();
			
			console.log("Giá trị statusCell:", statusCell);
			
			if (selectedStatus === "Tất cả" || statusCell === selectedStatus) {
	            row.style.display = "table-row";
	        } else {
	            row.style.display = "none";
	        }
		});
	});



	document.querySelectorAll(".edit-btn").forEach(function(button) {
	    button.addEventListener("click", function() {
	        var row = button.closest("tr");
	        var spans = row.querySelectorAll("td");

	        spans.forEach(function(span , index) {
	            if ( index == 0 || index == 5) {
	                var text = span.textContent; 
	                var input = document.createElement("input");
	                input.type = "text";
	                input.style.textAlign = "center";
	                input.style.border = "none";
	                input.style.padding = "4px 8px";
	                input.value = text.trim(); 
	                
	                span.innerHTML = '';
	                span.appendChild(input);
	                
	                if (index === 5) {
	                    var select = document.createElement("select");
	                    select.id = "mySelect";
	                    var options = [];
	                    if (text.trim() === "Chờ xác nhận") {
	                        options = ["Chờ xác nhận", "Đang vận chuyển", "Đã hủy"];
	                    } else if (text.trim() === "Đang vận chuyển") {
	                        options = ["Đang vận chuyển", "Đã giao hàng", "Đã hủy"];
	                    } else {
	                        var optionElement = document.createElement("option");
	                        optionElement.text = text.trim();
	                        select.add(optionElement);
	                        select.disabled = true;
	                    }

	                    options.forEach(function(option) {
	                        var optionElement = document.createElement("option");
	                        optionElement.text = option;
	                        select.add(optionElement);
	                    });

	                    span.innerHTML = '';
	                    span.appendChild(select);
	                    select.value = text.trim();
	                } else {
	                    span.innerHTML = '';
	                    span.appendChild(input);
	                }

	            }
	            row.classList.add("editing-row");
	        });
	    });
	});





document.getElementById("save").addEventListener("click", function() {
    document.querySelectorAll(".custom-table tbody tr").forEach(function(row) {         
        if (row.classList.contains("editing-row")) {
            var inputs = row.querySelectorAll("input");
           
            var selects = row.querySelectorAll("select");
			
            var editDatas = {};
            editDatas["orderId"] = inputs[0].value; 
            editDatas["status"] = selects[0].value;
            
            console.log("Edited data:");
            for (var key in editDatas) {
                console.log(key + ": " + editDatas[key]);
            }

            fetch('http://localhost:8082/WebCart/editOrder',{
                method : 'POST' , 
                headers: {
                    'Content-Type': 'application/json ; charset=utf-8'
                },
                body: JSON.stringify(editDatas)
            })
            .then(function(response) {
                if (!response.ok) {
                    throw new Error('Server response lỗi');
                }
                console.log('Successful response:', response);
                return response.json();
            })
            .then(function(data) {
                if (data.error) {
                    alert("Dữ liệu không hợp lệ.Vui lòng kiểm tra lại"); 
                } else if (data.message === "success") {
                    alert('Dữ liệu cập nhật thành công');
                    window.location.href="DHangManage";
                }
                else
                	{
                	alert('Dữ liệu cập nhật thành công');
                	window.location.reload();
                	}
            })
            .catch(function(error) {
                console.error('ERROR:', error);
            });

            row.classList.remove("editing-row");
        }
    });
});

		


	
	
	
	document.querySelectorAll(".delete-btn").forEach(function(button){
		button.addEventListener("click",function(){
			var row = button.closest("tr");
			var spans = row.querySelectorAll("td");
			
			console.log("row " + row.textContent);
			console.log("spans " + spans.textContent);
			
			spans.forEach(function(span){
				row.classList.add("deleting-row");
			});
			
			var result = confirm("Bạn có muốn xóa bản ghi này không");
			if (result)
			{
				var orderId = row.querySelector("td").textContent;
				console.log("giá trị orderId " + orderId);
				fetch('http://localhost:8082/WebCart/DHangManage',{
					method : 'POST',
					headers : {
						'Content-Type' : 'application/json ; charset=utf-8'
					},
					body: JSON.stringify({ID : orderId})
				})
				.then(function(response) {
                    if (!response.ok) {
                        throw new Error('Server response error');
                    }
                    return response.json();
                })
                .then(function(data) {
                    if (data.message === "Xóa đơn hàng thành công") {
                        row.remove();
                    }
                    alert(data.message); // Hiển thị thông báo từ máy chủ
                })
                .catch(function(error) {
                    console.error('ERROR:', error);
                });

			}
		else
			{
				row.classList.remove("deleting-row"); 
	            alert("Bạn không xóa");
			}
			
			
		});
		
	});
	
	
	document.getElementById("searchInput").addEventListener("input", function(){
	    var keyword = this.value.trim().toLowerCase();
	    console.log(keyword);
	    var rows = document.querySelectorAll(".custom-table tbody tr");
	    
	    rows.forEach(function(row){
	        var id = row.querySelector("td:first-child").textContent.trim().toLowerCase(); 
	        var name = row.querySelector("td:nth-child(2)").textContent.trim().toLowerCase(); 
	        var nameOrder = row.querySelector("td:nth-child(3)").textContent.trim().toLowerCase(); 
	        var status = row.querySelector("td:nth-child(6)").textContent.trim().toLowerCase(); 

	        
	        if (id.includes(keyword) || name.includes(keyword) || nameOrder.includes(keyword) || status.includes(keyword)) {
	            row.style.display = "table-row"; 
	        } else {
	            row.style.display = "none"; 
	        }
	    });
	});
	
	document.querySelectorAll(".detail-btn").forEach(function(button){
	    button.addEventListener("click", function(){
	        var row = button.closest("tr");
	        
	        row.classList.add("detail-row");

	        var orderId = row.querySelector("td").textContent;
	        console.log("giá trị orderId " + orderId);
	        fetch('http://localhost:8082/WebCart/OrderDetailAdminServlet',{
	            method : 'POST',
	            headers : {
	                'Content-Type' : 'application/json ; charset=utf-8'
	            },
	            body: JSON.stringify({ID : orderId})
	        })
	        .then(function(response) {
	            if (!response.ok) {
	                throw new Error('Server response error');
	            }
	            return response.json();
	        })
	        .then(function(data) {
	        	console.log("phan hoi data");
	        	if (data.message1 === "OK") {
                    
                
	        	alert("Xem chi tiet don hang");
	            window.location.href = "DetailOrderAdmin.jsp";
	        	}
	        })
	        .catch(function(error) {
	            console.error('ERROR:', error);
	            console.error('STACK TRACE:', error.stack);
	        });

	    });

	});
	
</script>


</html>
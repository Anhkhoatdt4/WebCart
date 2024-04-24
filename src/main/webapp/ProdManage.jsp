<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý sản phẩm</title>
<link rel="stylesheet" href="css/ProManage.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

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
		<div class="menu" style="height: auto;">
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
		<div class=" mainn">
			<div class="button">
				<button
					style="background-color: #9df99d; border: #9df99d; color: #003c00; width: 150px; height: 40px;"
					onclick="showForm(event)">
					<i class="fa-solid fa-plus"></i> Tạo sản phẩm mới
				</button>
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
			<hr class="line">
			<br>
			<div class=" find">
				<li>Tìm kiếm:</li>
				<li>
				<input id = "searchInput" type="text" style=" border-radius: 8px; height: 25px; margin-top: -30px; background-color: rgb(234, 233, 233); " required placeholder="Nike Air Force 1">
				</li>

			</div>
			<br> <br> <br> <br>
			<div>
				<table class="custom-table">
					<thead>
						<tr>
							<th>Mã sản phẩm</th>
							<th>Tên sản phẩm</th>
							<th>Ảnh</th>
							<th>Số lượng</th>
							<th>Tình trạng</th>
							<th>Giá tiền</th>
							<th>Danh mục</th>
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product1" items="${ListProduct}">
					    <c:forEach var="category2" items="${ListCate}">
					        <c:if test="${product1.category_id == category2.cid}">
					        <c:if test="${product1.psize ne 0 }">
					            <tr>
					                <td>${product1.pId}</td>
					                <td>${product1.pname}</td>
					                <td style="width: 200px;"><img style="width: 80%; height: 105px;" src="${product1.pimage}"></td>
					                <td style="width: 100px;">${product1.pquantity}</td>
					                <td style="width: 120px;"><b>Còn hàng</b></td>
					                <td>${product1.pprice}</td>
					                <td>${category2.cname}</td>
					                <td style="width: 100px;">
					                    <a href="deleteproduct?ProID=${product1.pId}"><i class="fa-solid fa-trash" style="padding: 0 5px; color : blue"></i></a>
					                    <a href="#" class= "edit-btn"  ><i class="fa-solid fa-pen-to-square" style="padding : 0 5px; color: blue;"></i></a>
					                </td>
					            </tr>
					            </c:if>
					        </c:if>
					    </c:forEach>
					</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
		<div class="time" style="margin-top: -4570px;">
                    <ul style="display: flex; margin-left: 30px;">
			            <li style="list-style-type: none; margin-top: 10px; font-weight: bold; font-size: 14px;">Danh sách sản phẩm</li>
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
                
	<div class="overlay"></div>
	<div class="form">
		<ul>
		<li
			style="list-style-type: none; font-size: 22px; font-weight: bold; color: #e80eb9;
			 margin-top: 10px; margin-left: 140px; font-weight: 700;">
			 Thông tin sản phẩm
			</li>
			</ul>
		<form id="myForm" action="addProductServlet" method="post" accept-charset="UTF-8">
		
			<div class="form_gr">
				<label for="Name">Tên sản phẩm:</label> <input type="text" id="Name"
					name="Name" required placeholder="Giày Lacosete ...">
			</div>
			<div class="form_gr">
				<label for="Photo">Đường dẫn ảnh sản phẩm:</label> 
    			<input type="text" id="Photo" name="Photo" required>
			</div>
			<div class="merge">
				<div class="form_gr">
					<label for="Quantity" style="margin-right: 50px;">Số lượng:</label>
					<input type="number" id="Quantity" name="Quantity" required
						placeholder="10">
				</div>
				<div class="form_gr">
					<label for="Size">Size:</label> <input type="number" id="Size"
						name="Size" required placeholder="42">
				</div>
			</div>
			<div class="merge">
				<div class="form_gr">
					<label for="State">Trạng thái:</label> <select id="State"
						name="State" required>
						<option value="have">Còn hàng</option>
						<option value="haven't">Hết hàng</option>
					</select>
				</div>
				<div class="form_gr">
					<label for="Price">Giá tiền: (đơn vị: USD)</label> <input
						type="number" id="Price" name="Price" required placeholder="199">
				</div>
			</div>
			<div class="form_gr">
				<label for="Type">Danh mục</label> <input type="text" id="Type"
					name="Type" required placeholder="Nike">
			</div>
			<div class="form_gr">
				<label for="Description">Mô tả:</label>
				<textarea id="Description" name="Description" rows="4" required
					placeholder="Mô tả sản phẩm ở đây"></textarea>
			</div>
			<button class="but" onclick="cancelForm()" style="float: right;">Cancel</button>
			<input type="submit" onclick="submitForm()" value="Submit">
		</form>
	</div>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			var form = document.getElementById("myForm");
			var formContainer = document.querySelector(".form");
			var overlay = document.querySelector(".overlay");
			form.style.display = "none";
			formContainer.style.display = "none";
			overlay.style.display = "none";
		});

		function showForm(event) {
		    event.preventDefault();
			var form = document.getElementById("myForm");
			var formContainer = document.querySelector(".form");
			var overlay = document.querySelector(".overlay");
			form.style.display = "block";
			formContainer.style.display = "block";
			overlay.style.display = "block";
			console.log('Đã tạo form');

		}
		function cancelForm() {
			event.preventDefault();
			var form = document.getElementById("myForm");
			var formContainer = document.querySelector(".form");
			var overlay = document.querySelector(".overlay");
			form.reset();
			form.style.display = "none";
			formContainer.style.display = "none";
			overlay.style.display = "none";
		}
		function submitForm() {
		    var form = document.getElementById("myForm");
		    var formContainer = document.querySelector(".form");
		    var overlay = document.querySelector(".overlay");
		    
		    // Lấy giá trị của các trường trong form
		     var idValue = form.elements["ID"].value.trim();
		    var nameValue = form.elements["Name"].value.trim();
		    var photoValue = form.elements["Photo"].value.trim();
		    var quantityValue = form.elements["Quantity"].value.trim();
		    var sizeValue = form.elements["Size"].value.trim();
		    var priceValue = form.elements["Price"].value.trim();
		    var typeValue = form.elements["Type"].value.trim();
		    var descriptionValue = form.elements["Description"].value.trim();
		    
		    if (!idValue || !nameValue || !photoValue || !quantityValue || !sizeValue || !priceValue || !typeValue || !descriptionValue) {
		        alert("Vui lòng điền đầy đủ thông tin sản phẩm.");
		        return;
		    }
	
		    form.style.display = "none";
		    formContainer.style.display = "none";
		    overlay.style.display = "none";
		   
		    
		    alert("Đã thêm sản phẩm thành công");
		}

		function exportToExcel() {
			// Gọi servlet tại đây
			window.location.href = "XuatExcelProduct";
			alert("Đã xuất file Excel thành công!");
		}
		function deleteAll() {
			// Gọi servlet tại đây
			window.location.href = "deleteproduct?ProID=-1";
		}
		function searchFunction(event) {
		    if (event.keyCode == 13) {
		        var query = event.target.value;
		        window.location.href = "adminsearch?query=" + query;
		    }
		}
	</script>
	
	<script type="text/javascript">
	document.querySelectorAll(".edit-btn").forEach(function(button) {
	    button.addEventListener("click", function() {
	        var row = button.closest("tr");
	        var spans = row.querySelectorAll("td");

	        spans.forEach(function(span, index) {
	            if (index > 0 && index !== 2 && index !== 6 &&index !== 7) { 
	                var text = span.textContent;
	                var input = document.createElement("input");
	                input.type = "text";
	                input.style.textAlign = "center";
	                input.style.border = "none";
	                input.style.padding = "4px 8px";
	                input.value = text;
					input.style.fontSize = "15px";
	                span.innerHTML = '';
	                span.appendChild(input);
	            }

	            row.classList.add("editing-row");
	        });
	        console.log('con cac');
	    });
	});




	document.getElementById("save").addEventListener("click", function() {
	    document.querySelectorAll(".custom-table tbody tr").forEach(function(row) {         
	        if (row.classList.contains("editing-row")) {
	            var inputs = row.querySelectorAll("input");
	           
	            
	            var editDatas = {};
	            editDatas["name"] = inputs[0].value; 
	            editDatas["quantity"] = inputs[1].value;
	            editDatas["status"] = inputs[2].value; 
	            editDatas["price"] = inputs[3].value; 
	            editDatas["id"]  = row.querySelector("td").textContent.trim();
	            console.log("Edited data:");
	            for (var key in editDatas) {
	                console.log(key + ": " + editDatas[key]);
	            }

	            fetch('http://localhost:8082/WebCart/editProduct',{
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
	
	</script>
	
	<script type="text/javascript">
	document.getElementById("searchInput").addEventListener("input", function(){
	    var keyword = this.value.trim().toLowerCase();
	    console.log(keyword);
	    var rows = document.querySelectorAll(".custom-table tbody tr");
	    
	    rows.forEach(function(row){
	        var id = row.querySelector("td:first-child").textContent.trim().toLowerCase(); 
	        var name = row.querySelector("td:nth-child(2)").textContent.trim().toLowerCase(); 
	        var nameOrder = row.querySelector("td:nth-child(6)").textContent.trim().toLowerCase(); 
	        var status = row.querySelector("td:nth-child(7)").textContent.trim().toLowerCase(); 

	        console.log('ID:', id);
	        console.log('Name:', name);
	        
	        
	        if (id.includes(keyword) || name.includes(keyword) || nameOrder.includes(keyword) || status.includes(keyword)) {
	            row.style.display = "table-row"; 
	        } else {
	            row.style.display = "none"; 
	        }
	    });
	});
	</script>
	
</body>
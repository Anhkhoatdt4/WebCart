<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý tài khoản</title>
<link rel="stylesheet" href="css/customerManage.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<div class="header">
		<ul
			style="display: flex; margin-left: 300px; margin-top: -8px; font-size: 15px;">
			 <li class = "trangchu">Trang chủ</li>
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
				<li class="fa-solid fa-user"
					style="margin-left: 60px; margin-bottom: 10px; margin-right: 5px; color: white; font-size: 12px">
					${sessionScope.username}</li>

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
							<i class="fa-solid fa-id-card"></i> Quản lý tài khoản
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
		<div class=" mainn">
			<div class="button">
			 
			<!-- 	<button
					style="background-color: #bfbeef; border: #bfbeef; color: #03009a; width: 100px; height: 40px;">
					<i class="fa-solid fa-print"></i> In dữ liệu
				</button> -->
				<button onclick="exportToExcel()"
					style="background-color: #008c04; border: #008c04; color: #a2ecb5; width: 100px; height: 40px;">
					<i class="fa-solid fa-file-excel"></i> Xuất Excel
				</button>

				<button id="accept"
					style="background-color: #14a3cf; border: #d0d0d0; width: 100px; height: 40px;">
					<i class="fa-solid fa-check"></i> Xác nhận
				</button>
				<button id="save"
					style="background-color: rgb(235, 25, 25); border: #008c04; color: #a2ecb5; width: 100px; height: 40px;">
					<i class="fa-solid fa-floppy-disk"></i></i> Lưu thay đổi
				</button>
			</div>
			<br>
			<hr class="line">
			<br>
			<div class=" find">
				<li>Tìm kiếm:</li> <input type="text" id="searchInput"
					style="border-radius: 6px; height: 25px; margin-top: -4px; background-color: rgb(234, 233, 233); margin-left: 5px;"
					placeholder="Nhập từ khóa tìm kiếm">
			</div>

			<div>
				<table class="custom-table">
					<thead>
						<tr>
							<th style="width: 15%;">Mã khách hàng</th>
							<th style="width: 19%;">Tên khách hàng</th>
							<th>Username</th>
							<th>Password</th>
							<th>Số điện thoại</th>
							<th style="width: 15%;">Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="userDetail" items="${listUserDetail}">
							<c:forEach var="user" items="${ListUser}">
								<c:if test="${user.userid eq userDetail.userId}">
									<tr>
										<td><span>${userDetail.userId}</span></td>
										<td><span>${userDetail.fullname}</span></td>
										<td><span>${user.username}</span></td>
										<td><span>${user.password}</span></td>
										<td><span>${user.uPhone}</span></td>
										<td style="width: 100px;"><a href="#" class="delete-btn"><i
												class="fa-solid fa-trash" style="padding: 0 15px;"></i></a> <a
											href="#" class="edit-btn"><i
												class="fa-solid fa-pen-to-square" style="padding: 0 20px;"></i></a>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="time">
		<ul style="display: flex; margin-left: 30px;">
			<li
				style="list-style-type: none; margin-top: 10px; font-weight: bold; font-size: 14px;">Danh
				sách tài khoản</li>
		</ul>
		<ul id="currentTime"
			style="display: flex; float: right; margin-right: 30px;">
			<li
				style="list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;">Thứ
				3, 09/04/2024 - 17:05:10</li>
		</ul>
	</div>
</body>
<script>
    function deleteUser(userId) {
       var option=confirm('Bạn có chắc chắn muốn xóa?'+userId);
       if (option === true)
    	   {
    	   		window.location.href='deleteaccount?userId'+userId;
    	   }
    }
    
    function updateTime() {
        var currentDate = new Date();
        var formattedDate = currentDate.toLocaleString('vi-VN', { weekday: 'long', year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' });
        document.getElementById('currentTime').innerHTML = "<li style='list-style-type: none; margin-top: -16px; font-weight: bold; font-size: 14px;'>" + formattedDate + "</li>";
    }

    setInterval(updateTime, 1000);

    updateTime();
    
    
    function createInput(type, placeholder) {
        var input = document.createElement("input");
        input.type = type;
        input.placeholder = placeholder;
        input.style.textAlign = "center";
        input.style.border = "none";
        input.style.padding = "4px 8px";
        input.style.fontSize = "14px";
        input.style.color = "#000";
        input.style.backgroundColor = "white";
        return input;
    }

    /* document.getElementById("add").addEventListener("click", function(){
        var newRow = document.createElement("tr");
        var IdCell = document.createElement("td");
        var NameCell = document.createElement("td");
        var usernameCell = document.createElement("td");
        var passwordCell = document.createElement("td");
        var phoneNumberCell = document.createElement("td");

        var idInput = createInput("text", "Nhập ID");
        var nameInput = createInput("text", "Nhập tên khách hàng");
        var usernameInput = createInput("text", "Nhập username");
        var passwordInput = createInput("text", "Nhập mật khẩu");
        var phoneNumberInput = createInput("tel", "Nhập số điện thoại");

        IdCell.appendChild(idInput);
        NameCell.appendChild(nameInput);
        usernameCell.appendChild(usernameInput);
        passwordCell.appendChild(passwordInput);
        phoneNumberCell.appendChild(phoneNumberInput);

        newRow.appendChild(IdCell);
        newRow.appendChild(NameCell);
        newRow.appendChild(usernameCell);
        newRow.appendChild(passwordCell);
        newRow.appendChild(phoneNumberCell);

        var funCell = document.createElement("td");
        funCell.innerHTML = '<td style="width: 100px;"><a href="#"><i class="fa-solid fa-trash" style="padding: 0 18px;"></i></a><a href="#"><i id="i-edit" class="fa-solid fa-pen-to-square" style="padding: 0 22px;"></i></a></td>';
        newRow.appendChild(funCell);

        document.querySelector(".custom-table tbody").appendChild(newRow);
    }); */

    
    document.getElementById("accept").addEventListener("click", function() {
        var newRow = document.querySelector(".custom-table tbody tr:last-child");
        var inputs = newRow.querySelectorAll("input");
        var inputValues = {};

        inputs.forEach(function(input) {
            var inputType = input.getAttribute("placeholder");
            var inputValue = input.value;
            inputValues[inputType] = inputValue;
            input.disabled = true;
        });

        console.log("Giá trị đã nhập:");
        for (var key in inputValues) {
            console.log(key + ": " + inputValues[key]);
        }

        fetch('http://localhost:8082/WebCart/addAccount', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json ; charset=utf-8'
            },
            body: JSON.stringify({
            	id : inputValues["Nhập ID"],
            	name : inputValues["Nhập tên khách hàng"],
            	username: inputValues["Nhập username"],
            	password : inputValues["Nhập mật khẩu"],
            	phone :		inputValues["Nhập số điện thoại"],
            })
        })
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Lỗi phản hồi từ máy chủ');
            }
            console.log('Phản hồi thành công:', response);
            return response.json();
        })
        .then(function(data) {
        	if (data.error) {
                alert("Dữ liệu bị trùng lặp. Vui lòng kiểm tra lại."); 
                window.location.reload();
            } else if (data.message === "success") {
                alert('Dữ liệu đã được cập nhật thành công');
            }
		})
        .catch(function(error) {
            console.error('LỖI:', error);
        });
    });
    
    document.querySelectorAll(".edit-btn").forEach(function(button) {
        button.addEventListener("click", function() {
            var row = button.closest("tr");
            var spans = row.querySelectorAll("span"); 
			console.log(row);
            spans.forEach(function(span) {
                var text = span.textContent; 
                var input = document.createElement("input");
                input.type = "text";
                input.style.textAlign = "center";
                input.style.border = "none";
                input.style.padding = "4px 8px";
                input.value = text; 
                if (span.id !== "user" && span.id !== "pass") {
                    span.parentNode.replaceChild(input, span); 
                }
                
                row.classList.add("editting-row");
            });
            console.log('con cac');
        });
    });
    
    
    
    document.querySelectorAll(".delete-btn").forEach(function(button) {
        button.addEventListener("click", function() {
            var row = button.closest("tr");
            var spans = row.querySelectorAll("span");
            spans.forEach(function(span) {
                row.classList.add("deleting-row");
            });
            
            var result = confirm("Bạn có muốn xóa bản ghi này?");
            if (result == true) {
                var cartID = row.querySelector("span").textContent;
                console.log("gia tri " + cartID);
                fetch('http://localhost:8082/WebCart/deleteAccount', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json ; charset=utf-8'
                    },
                    body: JSON.stringify({ ID: cartID }) // Sửa tên key thành ID
                })
                .then(function(response) {
                    if (!response.ok) {
                        throw new Error('Server response error');
                    }
                    console.log('Successful response:', response);
                    return response.json();
                })
                .then(function(data) {
				    if (data.error) {
				        alert("Không xóa được."); 
				    } else if (data.message === "success") {
				        alert('Dữ liệu đã được cập nhật thành công');
				        
				        setTimeout(function() {
				            window.location.reload();
				        }, 1000);
				    }
				    else 
				    	{
				    	window.location.reload();
				    	}
				})
                .catch(function(error) {
                    console.error('ERROR:', error);
                });
            } else {
                row.classList.remove("deleting-row"); // Xóa class "deleting-row"
                alert("Bạn không xóa");
            }
        });
    });  

    

    
    document.getElementById("save").addEventListener("click", function() {
        document.querySelectorAll(".custom-table tbody tr").forEach(function(row) {         
            if (row.classList.contains("editting-row")) {
            	
                var inputs = row.querySelectorAll("input");
                var user = row.querySelector("#user");
                var pass = row.querySelector("#pass");
                
                var userData = user.textContent;
                var passData = pass.textContent;
                
                console.log("user:" + user);
                console.log("pass:" + pass);
                console.log("userdata:" + userData);
                console.log("passdata:" + passData);
                var editDatas = {};


                    editDatas["id"] = inputs[0].value; 
                    console.log("h1");
                    editDatas["name"] = inputs[1].value; 
                    console.log("h2");
                    editDatas["username"] = userData; 
                    console.log("h3");
                    editDatas["password"] = passData; 
                    console.log("h4");
                    editDatas["phone"] = inputs[2].value;
                	
                    console.log("Edited data:");
                    for (var key in editDatas) {
                        console.log(key + ": " + editDatas[key]);
                    }

                // Send edited data to server
                fetch('http://localhost:8082/WebCart/editAccount',{
                    method : 'POST' , 
                    headers: {
                        'Content-Type': 'application/json ; charset=utf-8'
                    },
                    body: JSON.stringify(editDatas)
                })
                .then(function(response) {
                    if (!response.ok) {
                        throw new Error('Server response error');
                    }
                    console.log('Successful response:', response);
                    return response.json();
                })
                .then(function(data) {
                    if (data.error) {
                        alert("Dữ liệu Id bị trùng lặp.Vui lòng kiểm tra lại"); 
                    } else if (data.message === "success") {
                        alert('Dữ liệu cập nhật thành công');
                    }
                })
                .catch(function(error) {
                    console.error('ERROR:', error);
                });

                row.classList.remove("editting-row");
            }
        });
    });
    
    var buttons = document.querySelectorAll(".button button");
    	buttons.forEach(function(button){
    		button.addEventListener("mouseenter", () => {
    			 	button.style.backgroundColor = "#5cb85c";
    	            button.style.borderColor = "#4cae4c";
    	            button.style.color = "#";
    		});
    		
    		button.addEventListener("mouseleave", function() {
               
                button.style.backgroundColor = button.dataset.normalBgColor;
                button.style.borderColor = button.dataset.normalBorderColor;
                button.style.color = button.dataset.normalColor;
            });

            button.dataset.normalBgColor = button.style.backgroundColor;
            button.dataset.normalBorderColor = button.style.borderColor;
            button.dataset.normalColor = button.style.color;
    	});
    	
    	
    	document.getElementById("searchInput").addEventListener("input", function() {
            var keyword = this.value.trim().toLowerCase();
            var rows = document.querySelectorAll(".custom-table tbody tr");

            rows.forEach(function(row) {
                var userId = row.querySelector("td:first-child").textContent.trim().toLowerCase(); 
                var userName = row.querySelector("td:nth-child(2)").textContent.trim().toLowerCase(); 
                
                if (userId.includes(keyword) || userName.includes(keyword)) {
                    row.style.display = ""; 
                } else {
                    row.style.display = "none"; 
                }
            });
        });
    	
    	function exportToExcel() {
    	    var confirmExport = confirm("Bạn muốn xuất file Excel không?");

    	    if (confirmExport) {
    	    	window.location.href = "XuatExcelAccountServlet";
    	        alert("Đã xuất file Excel thành công!");
    	    } else {
 
    	        alert("Bạn đã hủy việc xuất file Excel.");
    	    }
    	}
    	
    	document.querySelector(".trangchu").addEventListener("click",function(){
    		window.location.href = "home";
    	});
    	
    	
</script>
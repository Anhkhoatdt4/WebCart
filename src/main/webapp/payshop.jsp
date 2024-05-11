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
    <nav>


        <ul style="float: left; margin-left: 125px;">
            <li style=" font-size: 26px;
            color: #c72092;
            margin: 4px 14px;
            cursor: pointer;
            
            "><span> BKN</span> Shoes</span></li>
            <li><a href="home.jsp" style="font-size: 16px; color: #fff;">Trang chủ</a></li>

             <li><a href="cart.jsp" style="font-size: 16px; color: #fff;">Giỏ hàng</a></li>
            

        </ul>

        <ul style="float: right;     margin-right: 100px; ">

            <li><a href="https://wearebraindead.com/collections/oakley-factory-team?gad_source=1&gclid=Cj0KCQjwztOwBhD7ARIsAPDKnkBCuBFU-y6NpWZOfEMNrAHu8sAo-2yvJPSZpzXiwEopG1aEe_H6V0MaAht2EALw_wcB" style="font-size: 16px; color: #fff;">Giới thiệu</a></li>
            <li><a href="https://www.facebook.com/dut.itf" style="font-size: 16px; color: #fff;">Liên hệ</a></li>
            <li><a href="logout"style="font-size: 16px;" >Đăng xuất</a></li>
        </ul>
    </nav>

    <div class="title">
        <img class="form-img" src="https://www.mungbaobao.com/upload/news/2019/05/19/12/08/14/icon-thanh-toan-1.png?v=1"
            alt="">
        <br>
        <h2>Thanh toán</h2>
        <br>
        <p class="content-title">Vui lòng kiểm tra thông tin khách hàng và sản phẩm trước khi <strong
                style="color: rgb(201, 15, 15);">Đặt hàng</strong></p>
    </div>

    <div class="content" style="display: flex;">

        <div class="product-form" style="
            flex-grow: 6;
            max-width: calc(60% - 40px); /* 70% của không gian trống trong .content, trừ đi margin */
            margin-right: -17px;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-left: 100px;
        
        ">
            <div class="customer-info">
                <h1><span style="color: #c72092;">BKN</span> Shop</h1>
                <ul style="
               			 margin-top: 13px;
    					 text-align: center;">
                    <li >Giỏ hàng</li>
                    
                    
                 </ul>
                    <div class="products" style=" margin-top: 35px;">
                        <div class="detail-product">
                       
                        <c:forEach var="p" items="${listInPayEvent}">
                            <div class="product-info">
                                <img src="${p.pimage}" style="width: 110px; height: 110px;"
                                    alt="">
                                <div class="title-quantity">
                                    <h1>${p.pname}</h1>
                                    <h1>Số lượng : ${p.pquantity}</h1>
                                </div>
                                <div class="price">
                                    <h2 class="total-priceh2">
                                        $ ${p.pprice * p.pquantity}
                                    </h2>
                                </div>
                            </div>
                            <!-- <div class="product-info">
                                <img src="http://www.astudio.si/preview/blockedwp/wp-content/uploads/2012/08/5.jpg"
                                    alt="">
                                <div class="title-quantity">
                                    <h1>Lorem ipsum dolor ipsdu</h1>
                                    <h1>Số lượng : 3</h1>
                                </div>
                                <div class="price">
                                    <h2 class="price">
                                        $ 350
                                    </h2>
                                </div>
                            </div> -->
                            
						</c:forEach>
                            <div class="total-price">
                                <h1 style="margin-left: 355px; margin-top: 9px;">Tổng tiền</h1>
                                <h2 class="tongtien" style="width: 192px;
                                height: 50px;    margin-top: 14px;">
                                    $ 700
                                </h2>
                            </div>

                        </div>

                    </div>


                </ul>
              
            </div>
        </div>

        <div class="account-form">
            <li style="font-size: 22px;
            color: #e80eb9;
            font-weight: 700;
            list-style: none;
            margin-bottom: 15px;">Thông tin mua hàng
            </li>

            <div class="checkout-form">
				<c:set var="user" value="${sessionScope.user}" />
                <form action="" method="post">
                    <div class="form-group">
                        <label for="name">Họ và tên:</label>
                       <input type="text" id="name" name="name" required placeholder="${sessionScope.username}" value="${sessionScope.username}"
                            style="   border: 2px solid #9b1261;">
                    </div>
                    <div class="form-group">
                        <label for="phone">Số điện thoại:</label>
                        <input type="tel" id="phone" name="phone" required placeholder="${sessionScope.UserPhone}" value = "${sessionScope.username}">
                    </div>
                     <div class="form-group">
                        <label for="address">Địa chỉ giao hàng:</label>
                       <textarea id="address" name="address" required placeholder="${sessionScope.UserAddress}">${sessionScope.UserAddress}</textarea>

                        <input type="hidden" id="sessionAddress" value = "${sessionScope.UserAddress}">
                        
                    </div>
                    <div class="form-group">
                        <label for="delivery" style="">Chọn hình thức giao hàng:</label>
                        <select id="delivery11" name="delivery" required style="    border: 2px solid #9b1261;">
                            <option value="standard11">Giao hàng tiêu chuẩn ($2)</option>
                            <option value="express11">Giao hàng nhanh ($4)</option>
                            <option value="self-pickup11">Tự đến lấy hàng</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="delivery" style="">Chọn hình thức thanh toán:</label>
                        <select id="delivery" name="delivery" required style="    border: 2px solid #9b1261;">
                            <option value="express">Thanh toán bằng tiền mặt</option>
                            <option value="self-pickup">Thanh toán bằng VN PAY</option>
                        </select>
                    </div>
                    <button class="btn-submit" type="submit" onclick="submitForm()">Đặt hàng</button>
                </form>
            </div>
        </div>

    </div>

    <script>
    
    function createData(products, name, phone, address, oldAddress, totalPrice) {
        return { 
            products: products ,
            name : name ,
            phone : phone , 
            address: address,
            oldaddress: oldAddress,
            totalPrice : totalPrice
        };  
    }
     
    
    document.addEventListener("DOMContentLoaded", function() {

    	console.log("TIME OUT ");
        window.setTimeout(function() {
            window.location.reload();

            setInterval(function() {

                window.location.reload();
            }, 5 * 60 * 1000); 
        }, 60 * 1000); 
    });
    
    function submitForm() {
        event.preventDefault(); 
        
        // Lấy giá trị của phương thức thanh toán
        var deliveryMethod = document.getElementById("delivery").value;
        
        var products = [];
        var productInfos = document.querySelectorAll(".product-info");
        
        productInfos.forEach(function(productInfo) {
            var productName = productInfo.querySelector("h1").textContent;
            var product = { name: productName };
            products.push(product);
        });
        
        var totalPriceElement = document.querySelector(".total-price h2");
        var totalPriceText = totalPriceElement.textContent.trim(); 
        var totalPrice = parseFloat(totalPriceText.replace("$", ""));
        console.log(totalPrice);
        console.log(totalPriceElement);
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        var address = document.getElementById("address").value;
        var sessionAddress = document.getElementById("sessionAddress").value;
        console.log(sessionAddress);
        var data={};

        if (address !== sessionAddress) { // So sánh địa chỉ mới với địa chỉ trong session
            if (confirm("Bạn có muốn lưu thay đổi địa chỉ không?")) { // Hiển thị thông báo hỏi người dùng
                data = createData(products, name, phone, address, sessionAddress, totalPrice, "");
            }
            else {
                data = createData(products, name, phone, address, "", totalPrice, "");
            }
        }
        else {
            data = createData(products, name, phone, address, "", totalPrice, "");
        }

        console.log(data);
        
        // Gửi yêu cầu đặt hàng đến máy chủ
        fetch("http://localhost:8082/WebCart/orderDatabaseEvent", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Lỗi phản hồi từ máy chủ. Mã trạng thái: ' + response.status);
            }
            return response.json(); 
        })
        .then(function(data) {
            console.log(data);
            alert('Đặt hàng thành công!');
            
            // Kiểm tra phương thức thanh toán và chuyển hướng tương ứng
            if (deliveryMethod === "express") {
                // Thanh toán khi nhận hàng
                alert('Thanh toán khi nhận hàng');
                // Chuyển hướng về trang chủ
                window.location.href = "home";
            } else if (deliveryMethod === "self-pickup") {
                window.location.href = "processPayment";
            }
        })
        .catch(function(error) {
            console.error('Error:', error); 
            alert('Đặt hàng thất bại!');
        });
    }
        
        
        
        
        

        
        
	// tong tien 
 	var documentPrice = document.querySelectorAll(".total-priceh2");
 	var totalMoney = 0 ;
 	documentPrice.forEach(function(totalPrice){
 		var priceText = totalPrice.innerText.trim();
 		var price = parseFloat(priceText.replace("$",""));
 		totalMoney += price;
 	})
 	
 	var documentTotalPrice = document.querySelector(".total-price h2");
 	documentTotalPrice.textContent = "$ " + totalMoney.toFixed(1);
    </script>


	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
        $(document).ready(function() {
            $.ajax({
                url: "http://localhost:8082/WebCart/updateCart.jsp", 
                method: "POST",
                success: function(data) {
                    console.log("Thông tin giỏ hàng đã được cập nhật!");
                },
                error: function(xhr, status, error) {
                    console.error("Lỗi khi cập nhật thông tin giỏ hàng:", error);
                }
            });
        });
    </script> -->
</body>

</html>
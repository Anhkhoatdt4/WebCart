<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="css/forgotPass.css">
	
  
<body>
	
		 <div class="container">
	        <div class="illustration">
	          
	        </div>
	        <h2>Yêu cầu đặt lại mật khẩu</h2>
	        <p>Vui lòng nhập email của bạn:</p>
	        <input type="email" class="email-input"  placeholder="Nhập email">
	        <button id="confirmButton" class="btn-reset">Xác nhận</button>
	        <p><strong>Bạn có câu hỏi?</strong></p>
	        <p>Xin vui lòng liên hệ với chúng tôi nếu bạn cần hỗ trợ.</p>
	    </div>

	 
</body>
</html>

<script>
document.getElementById("confirmButton").addEventListener("click", function() {
	
	var emailInput = document.querySelector('input[type="email"].email-input');
	var email = emailInput.value;
	
	console.log("hhhuhu  " + email);
	
    fetch('http://localhost:8082/WebCart/forgotPass', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            email: email,
        }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(function(data) {
        var errorCode = data.errorCode;
        console.log(errorCode);
        if (errorCode === "101" || errorCode == 101) {
            alert("Email không tồn tại!");
            window.location.href = "forgotPass.jsp";
        } else if (errorCode === "202" || errorCode == 202 ) {
            alert("Đã gửi OTP tới email của bạn!");
            window.location.href = "OTP.jsp";
        } else {
            alert("Mã lỗi không xác định: " + errorCode);
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
</script>
 
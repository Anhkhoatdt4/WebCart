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
	         <h2>Nhập mã OTP</h2>
	        <input name = "otp" type="text" class="otp-input" placeholder="Nhập mã OTP">
	        <button id="confirmButton" class="btn-submit">Xác nhận</button> 
	        <p><strong>Bạn có câu hỏi?</strong></p>
	        <p>Xin vui lòng liên hệ với chúng tôi nếu bạn cần hỗ trợ.</p>
	    </div>
	    
	
</body>
</html>

<script>
document.getElementById("confirmButton").onclick = function() {
    var OTP = document.querySelector(".otp-input").value;
    
    fetch('http://localhost:8082/WebCart/checkOTP', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            OTP: OTP,
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
            alert("Mã OTP bạn nhập không chính xác");
            window.location.href = "OTP.jsp";
        } else if (errorCode === "202" || errorCode == 202) {
            alert("Đã gửi OTP tới email của bạn!");
            window.location.href = "resetPass.jsp";
        } else {
            alert("Mã lỗi không xác định: " + errorCode);
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
};
</script>
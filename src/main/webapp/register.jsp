<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BKN - SHOES</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="image/logo.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    
<div class="login_form" id="register_form">
    <div class="left">
        <img src="image/shoes4.png" style="width:90%; height: auto;">
    </div>
    <div class="right" >
        <h1>Đăng kí tài khoản!</h1>
        
         <p style="color: red">${sessionScope.DKMessage}</p>
        
        <form action="register" method="post" onsubmit="return validateForm()">
            <p>Tên người dùng</p>
            <div class="user">
                <i class="fa-solid fa-user"></i>
                <input type="text" name="user" placeholder="Tên người dùng" class="username">
            </div>
            <p class="passworg_tag">Mật khẩu</p>
            <div class="password">
                <i class="fa-solid fa-lock"></i>
                <input type="password" id="password" name="password" placeholder="Mật khẩu">
            </div>	
            <p style="padding-top: 10px">Xác nhận mật khẩu </p>
            <div class="password">
            	<i class="fa-solid fa-lock"></i>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="Xác nhận mật khẩu">
            </div>
            <p id="password_error" style="color: red; display: none;">Mật khẩu không khớp.</p>
            <button type="submit">Đăng kí</button>
        </form>
        <p style="margin-top: 10px;">Bạn đã có tài khoản? <a href="login.jsp" style="color: red; margin-left:25px ; font-size: 18px">Đăng nhập ngay</a></p>
    </div>
</div>

<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirm_password = document.getElementById("confirm_password").value;

        if (password.length < 6) {
            document.getElementById("password_error").innerText = "Mật khẩu phải có ít nhất 6 ký tự.";
            document.getElementById("password_error").style.display = "block";
            return false;
        } else if (password != confirm_password) {
            document.getElementById("password_error").innerText = "Mật khẩu không khớp.";
            document.getElementById("password_error").style.display = "block";
            return false;
        } else {
            document.getElementById("password_error").style.display = "none";
            return true;
        }
    }
</script>


</body>
</html>

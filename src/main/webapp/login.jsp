<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
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
</head>
<body>

<!-- Login Form -->
<div class="login_form" id="login_form">
    <div class="left">
        <img src="image/logshoes.png">
    </div>

    <div class="right">
        <h1>Đăng nhập!</h1>

                <p style="color: red">${sessionScope.errorMessage}</p>
            

        <form action="login" method="post">
            <p>Tên người dùng</p>
            <div class="user">
                <i class="fa-solid fa-user"></i>
                <input type="text" name="user" placeholder="Tên đăng nhập" class="username">
            </div>

            <p class="passworg_tag">Mật khẩu</p>
            <div class="password">
                <i class="fa-solid fa-lock"></i>
                <input type="password" name="password" placeholder="Mật khẩu">
            </div>

            <p class="forget"><a href = "forgotPass.jsp" style="color: red;"> Quên mật khẩu? </a></p>

      		
            
            <button type="submit">Đăng nhập</button>
            <div class="loging_icon">
                <a href="#"><img src="image/google.png"></a>
                <a href="#"><img src="image/facebook.png"></a>
                <a href="#"><img src="image/twitter.png"></a>
            </div>
     
            
            
        </form>

        <p style="margin-top:10px">Bạn chưa có tài khoản? <a href="register.jsp" style="color: red; margin-left:40px ; font-size: 18px" class="register-link">Đăng ký</a></p>
    </div>
</div>


<!-- <script>
	document.querySelector('.register-link').addEventListener('click', function() {
    document.getElementById('login_form').style.display = 'none';
    document.getElementById('registration_form').style.display = 'block';
});
</script> -->

</body>
</html>

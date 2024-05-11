<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thay đổi mật khẩu</title>
    <link rel="stylesheet" href="css/resetPass.css">
<body>	
	<div class="container" style="margin-top: 40px;">
        <div class="row">
          <div class="col-sm-12">
            <div class="horizontal-container">
              <div class="progress-bar-container">
                <div class="custom-progress-line" style="
                left: 39px;
				    margin: -12px;
				    width: 25%;"></div>
                <div class="custom-progress-line" style="  
                  left : 391px;
				    margin: -12px;
				    width: 25%;"></div>
                <ul class="custom-progress-bar clearfix">
                
                  <li class="finish-line"></li>
                </ul>
              </div>
              <div class="horizontal-form-box">
                <div class="horizontal-info-container text-center">
                  <img src="https://static.stayjapan.com/assets/top/icon/values-7dd5c8966d7a6bf57dc4bcd11b2156e82a4fd0da94a26aecb560b6949efad2be.svg" />
                  <p class="horizontal-heading">Thiết lập lại mật khẩu</p>
                  <p class="horizontal-subtitle">Mật khẩu của bạn phải có ít nhất 8 kí tự.</p>
                </div>
                <form class="horizontal-form" action="resetPass" method = "POST">
                  <div class="o3-form-group">
                    <label for="new_password">Mật khẩu mới</label>
                    <input type="password" class="o3-form-control o3-input-lg" id="new_password" name = "password">
                  </div>
                  <div class="o3-form-group">
                    <label for="confirm_password">Xác nhận mật khẩu</label>
                    <input type="password" class="o3-form-control o3-input-lg" id="confirm_password">
                  </div>
                  <button class="o3-btn o3-btn-primary o3-btn-block">Xác nhận</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div id="error" style="display: none;">${error}</div>
</body>
</html>

<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.o3-btn-primary').addEventListener('click', function(event) {
        var newPassword = document.getElementById('new_password').value;
        var confirmPassword = document.getElementById('confirm_password').value;

        if (newPassword !== confirmPassword) {
            alert('Mật khẩu nhập lại không khớp với mật khẩu mới.');
            event.preventDefault(); 
            return;
        }

        if (newPassword.length < 8) {
            alert('Mật khẩu mới phải có ít nhất 8 ký tự.');
            event.preventDefault(); 
            return;
        }
        
        var error = document.getElementById("error").innerText;
        console.log(error);
        if ( error != null && error !== null ) 
        	{
        	alert("Thay đổi mật khẩu thành công");
        	}
        
    });
});
</script>

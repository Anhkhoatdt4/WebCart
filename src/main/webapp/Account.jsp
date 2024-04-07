<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BKN - SHOES</title>
    <link rel="stylesheet" href="css/account.css">
    <link rel="shortcut icon" href="image/logo.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	  <div class="form-style-10" 
	  	style=" position: relative;
        display: flex;
        justify-content: center;
        align-items: center;
        background-image: url('https://i.pinimg.com/736x/4d/ef/ab/4defab87bb669dbe3ce8d88d78e6570b.jpg');
        background-size: contain;
        background-position: center;
        height: 100vh;
        width: 100%;
        padding: 0px;
        margin: 0px;
    }
        
        ">
        
		  <div class="form-style-ss" 
		 style="position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 1; 
        background-color: rgb(131 116 116 / 80%); 
        padding: 0px;
        ">
    	
    	

	   <form action="Account" method="POST" style="border: 2px solid #726767; border-radius: 10px;">
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 45px;" ><span style="background: #a65a5a;">1</span>Tên đầy đủ và địa chỉ</div>
	        <div class="inner-wrap" style="padding : 10px ; background: #9d9d9d;">
	            <label>Tên đầy đủ<input type="text" name="user" value="${sessionScope.username}" /></label>
	            <label>Địa chỉ<textarea name="address" lang="vi"></textarea></label>
	
	        </div>
	    
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 45px;" ><span style="background: #a65a5a;">2</span>Số điện thoại</div>
	        <div class="inner-wrap" style="background: #9d9d9d;padding : 10px;">
	            <label>Phone Number <input type="text" name="phone" /></label>
	        </div>
	    
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 45px;" ><span style="background: #a65a5a;">3</span>Mật khẩu</div>
	            <div class="inner-wrap" style="background: #9d9d9d;padding : 10px;">
	            <label>Mật khẩu<input type="text" name="password" value="${sessionScope.password}"/></label>
	        </div>
	        <div class="button-section" >
	         <input type="submit" name="Sign Up" style="background: #c40f28;"  />
	         <span class="privacy-policy">
	         </span>
	        </div>
	        <c:if test="${not empty sessionScope.message}">
			    <div class="message" style="font-size: 18px; color : red ; padding: 2px 2px">
			        ${sessionScope.message}
			    </div>
			</c:if>
			
			<input style="background: #c40f28;" type="button" value="Quay về trang home" onclick="window.location.href='home'"  style="background-color: #06c4ec"/>
	    </form>
	    </div>
    </div>
   
</body>
</html>
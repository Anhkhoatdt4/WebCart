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
	  <div class="container" style="background-color: #f5f5f5;">
		<div class="form-style-10" style="position: relative; display: flex; height: 100vh; width: 100%;">
			<img src="https://thuhiensport.com/wp-content/uploads/2021/07/Nike-Mercurial-Gi%C3%A0y-nike-Mercurial-F1-t%E1%BA%A1i-%C4%90%C3%A0-N%E1%BA%B5ng.jpeg" style="width: 39.3%; height: 100%; position: absolute; left: 0; top: 0; bottom: 0;" alt="Nike Mercurial">
			<img src="https://thuhiensport.com/wp-content/uploads/2021/07/Nike-Mercurial-Gi%C3%A0y-nike-Mercurial-F1-t%E1%BA%A1i-%C4%90%C3%A0-N%E1%BA%B5ng.jpeg" style="width: 39.3%; height: 100%; position: absolute; right: 0; top: 0; bottom: 0;" alt="Nike Mercurial">
		</div>
		
		
        
		<div class="form-style-ss" 
		 style="position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 1; 
        padding: 0px;
        ">


	   <form action="Account" method="POST" style="border: 2px solid rgb(166, 80, 241); border-radius: 10px;">
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 10px; "><span>1</span> Tên đầy đủ</div>
	        <div class="inner-wrap" style="padding : 10px ; width: 300px;">
	           <input type="text"  name="user" style="width: 290px; border-radius: 4px; border: 2px solid rgb(166, 80, 241); height: 30px;" required placeholder="Điền tên vào đây" value = "${sessionScope.FullName}">
	            
	        </div>
            <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 10px;" ><span>2</span> Địa chỉ</div>
            <div class="inner-wrap" style="padding : 10px ; width: 300px; ">
	            <textarea name="address" rows="3" style="width: 290px; border-radius: 4px;border: 2px solid rgb(166, 80, 241); font-family:Arial, Helvetica, sans-serif;" lang="vi" required placeholder="Điền địa chỉ vào đây" >${sessionScope.UserAddress}</textarea>           
	        </div>
            
	    
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 10px;" ><span>3</span> Số điện thoại</div>
	        <div class="inner-wrap" style="padding : 10px; width: 300px;">
	            <input type="text" name="phone" style="width: 290px;border-radius: 4px;border: 2px solid rgb(166, 80, 241);height: 30px;" value = "${sessionScope.UserPhone}" required placeholder="Điền SĐT vào đây" />
	        </div>
	    
	        <div class="section" style="font-size: 18px; color :#000; font-weight: 1000; padding: 10px ; margin-left: 10px;" ><span>4</span> Email</div>
	            <div class="inner-wrap" style="padding : 10px; width: 300px;">
	            <input type="text" name="password" style="width: 290px;border-radius: 4px;border: 2px solid rgb(166, 80, 241); height: 30px;" required placeholder="Điền email vào đây" value = "${sessionScope.UserEmail}">
	        </div>
	        <div class="button-section" >
	         <input type="submit" name="Sign Up" value="Submit" style="background: linear-gradient(to right, #c72092, #983dff); margin-left: 5px; margin-top: 10px; border-radius: px; width: 80px; height: 30px;"  />
			 <input style="background: linear-gradient(to right, #c72092, #983dff);height: 30px; margin-right: 5px;margin-top: 10px; float: right ; border-radius: 4px;" type="button" value="Quay về trang home" onclick="window.location.href='home'"  style="background-color: #06c4ec; "/>
	         <span class="privacy-policy">
	         </span>
	        </div>
			    <div class="message" style="font-size: 18px; color : red ; padding: 2px 2px">
			    </div>
	    </form>
    	</div>
</div>
   
</body>
</html>
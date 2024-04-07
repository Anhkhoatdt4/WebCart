<%@page contentType="text/html" pageEncoding="UTF-8"  %>
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

    <section>
        <nav>
            <div class="logo">
                <h1><span> BKN</span> Shoes</span></h1>
            </div>

			<div class="banner" style="width: 21%; ">
                <ul class="ul-header">
                    <li><a href="home">Home</a></li>
                    <li><a href="#Nike" class="a_header">Products</a>
                        <div class="banner_header" style="right: 135px">
                            <ul>
                                <li><a href="Nike">Nike</a></li>
                                <li><a href="Adidas">Adidas</a></li>
                                <li><a href="Puma">Puma</a></li>
                                <li><a href="Lacoste">Lacoste</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="#About">About</a></li>
                    <li><a href="#Services">Services</a></li>
                </ul>
            </div>
            
            
             <div class="search-container">
		        <form action="search" method="get">
                    <input type="text" name="query" placeholder="Search...">
                    <button type="submit">Search</button>
                </form>
   			 </div>
            
            

            <div class="icons">
	    <i class="fa-solid fa-heart"></i>
	    <i class="fa-solid fa-cart-shopping"></i>
	    <c:choose>
	        <c:when test="${empty sessionScope.username}">
	            <!-- Nếu không có sessionScope.username, chuyển hướng đến trang login.jsp -->
	            <a href="login.jsp" style="text-decoration: none; color :black">
	                <i class="fa-solid fa-user"></i> Đăng nhập
	            </a>
	        </c:when>
	        <c:otherwise>
	            <!-- Nếu có sessionScope.username, chuyển hướng đến trang account.jsp -->
	            <a href="Account.jsp" style="text-decoration: none; color :black">
	                <i class="fa-solid fa-user"></i> ${sessionScope.username}
	            </a>
	        </c:otherwise>
	    </c:choose>
	</div>

        </nav>

        <div class="main" id="Home">
            <div class="main_content">
                <div class="main_text">
                    <h1>NIKE<br><span>Collection</span></h1>
                    <p>
                        <strong>Chào mừng bạn đến với cửa hàng giày BKN Shoes. </strong>Chúng tôi tự hào là địa chỉ tin cậy để bạn có thể tìm kiếm những đôi giày phong cách và chất lượng.
                        Chúng tôi cung cấp một loạt các sản phẩm từ các thương hiệu nổi tiếng như <strong>Nike</strong>, <strong>Adidas</strong>, <strong>Puma</strong> và  <strong>Lacoste</strong>.
                        Khám phá bộ sưu tập giày mới nhất của chúng tôi và đừng quên tham gia cùng chúng tôi trong hành trình khám phá phong cách của bạn!
                    </p>
                </div>
                <div class="main_image">
                    <img src="image/shoes.png">
                </div>
            </div>
            <div class="social_icon">
                <i class="fa-brands fa-facebook-f"></i>
                <i class="fa-brands fa-twitter"></i>
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-brands fa-linkedin-in"></i>
            </div>
            <div class="button">
                <a href="home">SHOP NOW</a>
                <i class="fa-solid fa-chevron-right"></i>
            </div>
        </div>

    </section>
</body>
</html>
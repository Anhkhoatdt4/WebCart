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

	<style>
		.pagination {
        display: inline-block;
    }

    .pagination a {
        color: red;
        font-size: 22px;
        float: left;
        padding: 4px 16px;
        text-decoration: none;
        background-color: #cebcbc;
    }

    .pagination a .active {
        background-color: #fff;
        color: white;
    }

    .pagination a:hover:not(.active) {
        background-color: chocolate;
    }
	</style>

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
                    <h1>Nike<br><span>Collection</span></h1>
                    <p>
                        <strong>Chào mừng bạn đến với cửa hàng giày BKN Shoes. </strong>Chúng tôi tự hào là địa chỉ tin cậy để bạn có thể tìm kiếm những đôi giày phong cách và chất lượng.
                        Chúng tôi cung cấp một loạt các sản phẩm từ các thương hiệu nổi tiếng như <strong>Nike</strong>, <strong>Adidas</strong>, <strong>Puma</strong> và  <strong>Lacoste</strong>.
                        Khám phá bộ sưu tập giày mới nhất của chúng tôi và đừng quên tham gia cùng chúng tôi trong hành trình khám phá phong cách của bạn!
                    </p>
                </div>
                <div class="main_image">
                    <img src="image/shoes4.png">
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
    
    <!--Products-->

    <div class="products" id="Products">
    <h1>Products</h1>
    	<div class="box">
    	
    	<c:forEach var="p" items="${data}"> 
        	<div class="card">
            	<div class="small_card" style="z-index: 1">
                	<i class="fa-solid fa-heart"></i>
                	<i class="fa-solid fa-share"></i>
            	</div>
            
                    <div class="image">
                        <img src="${p.pimage}" style="width: 220px" ; height="190px";>
                    </div>
                
            
	            <div class="products_text">
	                <h2 style="font-size: 16px; width: 250px; height: 46px;">${p.pname}</h2>
	                <%-- <p>${p.pdesc}</p> --%>
	                <h3>$ ${p.pprice}</h3>
	                <div class="products_star">
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-regular fa-star-half-stroke"></i>
	                </div>
	                <a href="detailproduct?pid=${p.pId}" class="btn">Add To Cart</a>
	            </div>
	        </div>
        </c:forEach>
    </div>
    
    
    
   <!--  Pagination -->
      <div class="pagination" style=" border-radius:10px 20px ; margin-top: 15px; margin-left: 70px">
        <c:if test="${num > 1}">
            <c:forEach var="pageNumber" begin="1" end="${num}">
                <c:url var="pageURL" value="/Nike">
                    <c:param name="page" value="${pageNumber}"/>
                </c:url>
                <a href="${pageURL}">${pageNumber} ${size}</a>
            </c:forEach>
        </c:if>
    </div>
    
    
    
</div>

        <div class="about" id="About">
            
            <h1>Web<span>About</span></h1>

            <div class="about_main">
                <div class="about_image">
                 
                    <div class="image_contaner">
                        <img src="image/red_shoes1.png" id="imagebox">
                    </div>

                </div>

                <div class="about_text">
                        <h1>Giới Thiệu Về Nike</h1>
                        <p>
                            Nike là một trong những thương hiệu thể thao nổi tiếng hàng đầu trên toàn cầu. Công ty được thành lập vào năm 1964 bởi Bill Bowerman và Phil Knight dưới tên "Blue Ribbon Sports", và sau đó đổi tên thành Nike vào năm 1971.
                            Được biết đến với việc sản xuất giày thể thao, quần áo và đồ dùng thể thao khác, Nike đã trở thành biểu tượng của văn hóa thể thao và phong cách sống đẳng cấp.
                            Sản phẩm của Nike không chỉ nổi tiếng về chất lượng và thiết kế hiện đại, mà còn đưa ra những ảnh hưởng sâu rộng trong cộng đồng thể thao và xã hội toàn cầu.
                            Với khẩu hiệu "Just Do It", Nike thúc đẩy sự đam mê và nỗ lực, khuyến khích mọi người vượt qua giới hạn và hoàn thành mục tiêu của họ.
                        </p>
                    </div>
                </div>

            </div>

    
        <!--Services-->

        <div class="services" id="Services">
            <h1>our<span>services</span></h1>

            <div class="services_cards">
                <div class="services_box">
                    <i class="fa-solid fa-truck-fast"></i>
                    <h3>Giao hàng nhanh</h3>
                    <p style="padding : 0 20px">
                        Giao hàng nhanh chóng, tiết kiệm thời gian.
                    </p>
                </div>

                <div class="services_box">
                    <i class="fa-solid fa-rotate-left"></i>
                    <h3>10 ngày hoàn trả</h3>
                     <p style="padding : 0 20px">
                        Hoàn trả sản phẩm nếu không hài lòng,uy tín tạo nên thương hiệu.
                    </p>
                </div>

                <div class="services_box">
                    <i class="fa-solid fa-headset"></i>
                    <h3>24 x 7 Hỗ trợ</h3>
                    <p>
                        Luôn sẵn sàng, nhiệt tình hỗ trợ bạn 24/7. Liên hệ chúng tôi !!
                    </p>
                </div>
            </div>

        </div>



        


		<jsp:include page="footer.jsp"></jsp:include>

       
        
    </body>
    </html>
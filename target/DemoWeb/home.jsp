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
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>


    <!--Products-->

    <div class="products" id="Products">
    <h1>Products</h1>
    	<div class="box">
    	<c:forEach var="p" items="${data}">
        	<div class="card">
            	<div class="small_card">
                	<i class="fa-solid fa-heart"></i>
                	<i class="fa-solid fa-share"></i>
            	</div>
            
                    <div class="image">
                        <img src="${p.pimage}" style="width: 150px" ; height="150px";>
                    </div>
                
            
	            <div class="products_text">
	                <h2 style="font-size: 20px">${p.pname}</h2>
	                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</p>
	                <h3>${p.pprice}</h3>
	                <div class="products_star">
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-solid fa-star"></i>
	                    <i class="fa-regular fa-star-half-stroke"></i>
	                </div>
	                <a href="#" class="btn">Add To Cart</a>
	            </div>
	        </div>
        </c:forEach>
    </div>
</div>




    <!--About-->

        <div class="about" id="About">
            
            <h1>Web<span>About</span></h1>

            <div class="about_main">
                <div class="about_image">
                    <!-- <div class="about_small_image">
                        <img src="image/red_shoes1.png" onclick="functio(this)">
                        <img src="image/red_shoes2.png" onclick="functio(this)">
                        <img src="image/red_shoes3.png" onclick="functio(this)">
                        <img src="image/red_shoes4.png" onclick="functio(this)">
                    </div> -->

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

            <!-- <a href="#" class="about_btn">Shop Now</a> -->

            <!-- <script>
                function functio(small){
                    var full = document.getElementById("imagebox")
                    full.src = small.src
                }
            </script> -->
            
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
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
	<link rel="stylesheet" href="css/detail.css">
</head>
<body>

    <section style="height: 90px;">
        <nav>
            <div class="logo">
                <h1><span> BKN</span> Shoes</span></h1>
            </div>

            <div class="banner" style="width: 31%">
                <ul class="ul-header">
                    <li><a href="home">Home</a></li>
                    <li><a href="#Nike" class="a_header">Products</a>
                        <div class="banner_header">
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

    </section>


    <h1 style="text-align: center; font-size: 30px; color: red; text-decoration: underline;">Detail Products</h1>


    	<%-- <c:forEach var="p" items="${product}">  --%>
        	<main class="container">
	    <div class="left-column">
	         
	          <img src="${p.pimage}" alt="" style="border: 4px solid  hwb(319 42% 18%);border-radius: 25px">

	    </div>
    
        <div class="right-column">   
	          <div class="product-description">
	            <span> <strong style="color : red">Shoes</strong></span>
	            <h1 style="color: #d01313;">${p.pname}</h1>
	            <p style="font-size: 16px; color : #040003">${p.pdesc}</p>
	          </div>

	           <div class="product-configuration">
	           
	            <div class="product-color">
	              <span>Size</span>
	       
	               <div class="color-choose">
	                <div>
	                    <input data-size="40" type="radio" id="size40" name="size" value="40" checked>
	                    <label for="size40"><span>40</span></label>
	                </div>
	                <div>
	                    <input data-size="41" type="radio" id="size41" name="size" value="41">
	                    <label for="size41"><span>41</span></label>
	                </div>
	                <div>
	                    <input data-size="42" type="radio" id="size42" name="size" value="42" checked>
	                    <label for="size42"><span>42</span></label>
	                </div>
	                <div>
	                    <input data-size="43" type="radio" id="size43" name="size" value="43">
	                    <label for="size43"><span>43</span></label>
	                </div>
	                
	                </div>
	            </div>
	          
	        </div>    
		          <div class="product-price">
				    <span>$ ${p.pprice}</span>
				    <form action="cart" method="post">
				        <input type="hidden" name="productId" value="${p.pId}">
				        <input type="submit" class="cart-btn" onclick= "buy('${p.pId}')"   value="Add Product" style="background: hwb(319 30% 18%)">
				    </form>
				  </div>
		    </div>
    </main>
       <%--  </c:forEach> --%>

       


		<jsp:include page="footer.jsp"></jsp:include>

       
        
    </body>
    </html>
    
<script type="text/javascript">
    function buy(id) {
        var url = "buy?id=" + id;
        
        window.location.href = url;
    }
</script>
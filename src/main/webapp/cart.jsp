<%@page contentType="text/html" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@page import="model.CartDetail"%>
<%@page import="java.util.List"%>
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
    <link rel="stylesheet" href="css/cart.css">
</head>
<body>
    <header id="site-header">
        <div class="container">
            <a href="home" style="display: inline-block; font-size: 20px ; margin-right: 155px">
                <i class="fas fa-home"></i> Home
            </a>
            <h1 style="display: inline-block; font-size: 27px ; color:red">Shopping cart <span> in BKN Shoes</span></h1>
        </div>
    </header>

    <div class="container">
        <section id="cart"> 
       
            <c:forEach var="cartDetail" items="${cartDetail}">
                <article class="product">
                    <div class="product-content">
                        <header>
                           <a class="remove">
							    <img style="width: 240px;height: 192px" src="${cartDetail.product.pimage}" alt="">
							    <h3>Remove product</h3>
							</a>
                        </header>
                        <div class="content">    
                            <h1>${cartDetail.product.pname}</h1>     
                            <h1 style="font-size: 15px">${cartDetail.product.pdesc}</h1> 
                        </div>
                        <footer class="content" style="height: 45px;">              
                            <button class="qt-minus" style="background: #1cc1e4; font-size: 15px;">-</button>
                            <span class="qt">${cartDetail.quantity}</span>
                            <button class="qt-plus" style="background: #1cc1e4; font-size: 15px;">+</button>     
                            <c:forEach var="product" items="${listProd}">
                                <%-- So sánh pId của sản phẩm trong cartDetail với id của sản phẩm trong listProd --%>
                                <c:if test="${cartDetail.product.pId eq product.pId}">
                                    <h2 class="full-price">$ ${product.pprice * cartDetail.quantity}</h2>  
                                    <input type="hidden" class="hidden-price" value="${product.pprice}">
                                    <input type="checkbox" class="product-checkbox" 
                                        data-product-id="${cartDetail.product.pId}" 
                                        data-price="${product.pprice}"
                                        data-id="${IDCart}"
                                        style=" 
                                            margin-left: 22px;
                                            vertical-align: middle;
                                            float: right;
                                            display: block;
                                            text-align: center;
                                            width: 37px;
                                            height: 18px;
                                            /* align-items: center; */
                                            margin-top: 13px;">  
                                </c:if>
                            </c:forEach>
                        </footer>                     
                    </div>
                </article>
            </c:forEach>
        </section>
    </div>

    <footer id="site-footer" style="background-color: #eee">
        <div class="container clearfix">
            <div class="left">
                <h2 class="subtotal">Tổng sản phẩm: <span></span></h2>
            </div>

            <div class="right">
                <h1 class="total">Tổng tiền: <span></span></h1>
                <a class="btn" href="payshop.jsp">Thanh toán</a>
            </div>
        </div>
    </footer>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
	
/* 	var removeButtons = document.querySelectorAll('.product-content a');
    console.log(removeButtons);
    removeButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            var productId = button.dataset.productIdA;
            console.log('Product ID:', productId);
            // Gửi productId trong fetch API
        });
    }); */
	
	
	
	
    var minusButtons = document.querySelectorAll('footer .qt-minus');
    var quantityElements = document.querySelectorAll('footer .qt');
    var plusButtons = document.querySelectorAll('footer .qt-plus');
    var priceElements = document.querySelectorAll('footer .full-price');
    var hiddenPriceElements = document.querySelectorAll('footer .hidden-price');
    var cartItems = document.querySelectorAll('.product');
    var itemCountElement = document.querySelector('.subtotal span');
    var totalMoneyElement = document.querySelector('.total span');
    var checkboxes = document.querySelectorAll('.product-checkbox');

    var prices = [];
    var totalMoney = 0;
    totalMoneyElement.style.display = 'none';

    
    
    hiddenPriceElements.forEach(function(hiddenPriceElement) {
        var hiddenPriceValue = parseFloat(hiddenPriceElement.value);
        prices.push(hiddenPriceValue);
    });

    function updatePrice(index, currentQuantity) {
        var price = prices[index];
        var totalPrice = currentQuantity * price;
        priceElements[index].textContent = "$ " + totalPrice.toFixed(1);
        console.log('khong cap nhat ');
    }

    function calculateTotal() {
        totalMoney = 0;
        checkboxes.forEach(function(checkbox, index) {
            if (checkbox.checked) {
                totalMoney += prices[index] * parseInt(quantityElements[index].textContent);
            }
        });
        totalMoneyElement.textContent = "$ " + totalMoney.toFixed(1);
        totalMoneyElement.style.display = 'inline-block';
    }

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            calculateTotal();
        });	
    });

    minusButtons.forEach(function(minusButton, index) {
        minusButton.addEventListener('click', function() {
            var currentQuantity = parseInt(quantityElements[index].textContent);
            if (currentQuantity > 1) {
                quantityElements[index].textContent = currentQuantity - 1;
                calculateTotal();
                updatePrice(index , currentQuantity - 1 );
            } else {
                var productToRemove = minusButton.closest('.product');
                productToRemove.remove();
                cartItems = document.querySelectorAll('.product');
                itemCountElement.textContent = cartItems.length;
                totalMoney -= prices[index]; 
                totalMoneyElement.textContent = "$ " + totalMoney.toFixed(1);
                updatePrice(index , currentQuantity);
            }
        });
    });

    plusButtons.forEach(function(plusButton, index) {
        plusButton.addEventListener('click', function() {
            var currentQuantity = parseInt(quantityElements[index].textContent);
            quantityElements[index].textContent = currentQuantity + 1;
            calculateTotal();
            updatePrice(index , currentQuantity + 1);
        });
    });
    itemCountElement.textContent = cartItems.length;
});

function updateCart(cartID, productID, newQuantity, priceP) {
    console.log('cartID:', cartID);
    console.log('productID:', productID);
    console.log('so luong :', newQuantity);
    console.log('gia :', priceP);
    
    cartID = parseInt(cartID);
    productID = parseInt(productID);
    
    fetch('http://localhost:8082/WebCart/cartEvent', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            cartID: cartID,
            productID: productID,
            newQuantity: newQuantity,
            price: priceP
        })
    })
    .then(function(response) {
        if (!response.ok) {
            throw new Error('Lỗi phản hồi từ máy chủ');
        }
        console.log('Phản hồi thành công:', response);
        return response.json();
    })
    .then(function(data) {
        console.log('Dữ liệu đã được cập nhật:', data);
    })
    .catch(function(error) {
        console.error('LỖI:', error);
    });
}

const checkboxes = document.querySelectorAll('.product-checkbox');

checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
        if (this.checked) {
            const cartID = this.dataset.id;
            const productID = this.dataset.productId; 
            const priceP = this.dataset.price; 
            const quantityElement = this.closest('.product').querySelector('.qt');
            const newQuantity = quantityElement.textContent;
            updateCart(cartID, productID, newQuantity, priceP);
        }
    });
});


document.addEventListener('DOMContentLoaded', function(){
    const checkButton = document.querySelector('.btn');
    const checkBoxes = document.querySelectorAll('.product-checkbox');
    const selectedProducts = []; 

    checkButton.addEventListener('click', function() {
        const selectProducts = [];
        checkBoxes.forEach(function(checkbox) {
            if (checkbox.checked) {
            	const cartID = checkbox.dataset.id;
            	console.log(cartID);
                const productID = parseInt(checkbox.dataset.productId); 
                const priceP = parseFloat(checkbox.dataset.price);
                const quantityElement = checkbox.closest('.product').querySelector('.qt');
                const newQuantity = parseInt(quantityElement.textContent); 
                selectedProducts.push({ cartID: cartID, productID: productID, price: priceP, quantity: newQuantity });
            }
        });
        console.log(selectedProducts); 

        if (selectedProducts.length > 0) {
            fetch('http://localhost:8082/WebCart/payshop', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body:  JSON.stringify(selectedProducts)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Lỗi khi gửi dữ liệu đến máy chủ');
                }
               
                return response.json();
            })
            .then(data => {
   
                console.log('Dữ liệu phản hồi từ máy chủ:', data);
                
               /*  window.location.href = 'http://example.com/payment-success'; */
            })
            .catch(error => {
                console.error('Lỗi:', error);
            });
        } else {
            alert('Vui lòng chọn ít nhất một sản phẩm để thanh toán.');
        }
    });
});
	 
	


</script>

    </body>
</html>

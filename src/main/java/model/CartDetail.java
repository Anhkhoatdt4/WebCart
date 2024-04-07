package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartDetail implements Serializable{
    private int cartDetailId; // Khóa chính của CartDetail
    private int cartId; // Khóa ngoại liên kết với Cart
    private Product product;
    private int quantity;
    private double totalMoney;

    public CartDetail()
    {
    	
    }
    
    public CartDetail(int cartDetailId, int cartId, Product product, int quantity) {
        this.cartDetailId = cartDetailId;
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
        this.totalMoney = product.getPprice() * quantity; // Tính tổng tiền khi khởi tạo
    }

    // Các phương thức getter và setter

    public int getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(int cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalMoney = product.getPprice() * quantity;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    

	@Override
	public String toString() {
		return "CartDetail [cartDetailId=" + cartDetailId + ", cartId=" + cartId + ", product=" + product
				+ ", quantity=" + quantity + ", totalMoney=" + totalMoney + "]";
	}
    
	public static void main(String[] args) {
		List<CartDetail> cartDetails = new ArrayList<>();

   
        List<Double> productPrices = new ArrayList<>();

        for (CartDetail cartDetail : cartDetails) {
         
            double price = cartDetail.getQuantity() * cartDetail.getProduct().getPprice();
            productPrices.add(price);
        }

        // Print the list of product prices
        System.out.println("List of product prices:");
        for (double price : productPrices) {
            System.out.println("$" + price);
        }
    }
	
}



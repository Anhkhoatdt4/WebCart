package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Cart {
    private int cartId;
    private int user_Id;
    private List<CartDetail> list;

    public Cart() {
        list = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public List<CartDetail> getList() {
        return list;
    }

    public void setList(List<CartDetail> list) {
        this.list = list;
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Sản phẩm không hợp lệ.");
            return;
        }

        boolean existed = false;
        for (CartDetail cartDetail : list) {
            if (cartDetail.getProduct().getpId() == product.getpId()) {
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                existed = true;
                break;
            }
        }

        if (!existed) {
            CartDetail newDetail = new CartDetail();
            newDetail.setProduct(product);
            newDetail.setQuantity(1);
            list.add(newDetail);
        }
    }

    public void remove(int productId) {
        Iterator<CartDetail> iterator = list.iterator();
        while (iterator.hasNext()) {
            CartDetail cartDetail = iterator.next();
            if (cartDetail.getProduct().getpId() == productId) {
                iterator.remove();
                break;
            }
        }
    }

    public double getTotalMoney() {
        double totalMoney = 0;
        for (CartDetail cartDetail : list) {
            totalMoney += cartDetail.getProduct().getPprice() * cartDetail.getQuantity();
        }
        return totalMoney;
    }
    
    public void addOrUpdateCartDetail(List<CartDetail> cartDetails, CartDetail newCartDetail) {
        boolean existed = false;
        for (CartDetail cartDetail : cartDetails) {
            if (cartDetail.getProduct().getpId() == newCartDetail.getProduct().getpId()) {
                cartDetail.setQuantity(cartDetail.getQuantity() + newCartDetail.getQuantity());
                existed = true;
                break;
            }
        }
        if (!existed) {
            cartDetails.add(newCartDetail);
        }
    }


    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", user_Id=" + user_Id + ", list=" + list + "]";
    }
}
package io.github.vzer.factory.model.shopping;

/**
 * 购物车商品Model
 *
 * @author: Vzer.
 * @date: 2017/8/8. 22:05
 * @email: vzer@qq.com
 */

public class ShoppingModel {
    private int pId;//商品id
    private int count;//商品数量
    private double price;//合计总价

    public ShoppingModel(int pId, int count, double price) {
        this.pId = pId;
        this.count = count;
        this.price = price;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

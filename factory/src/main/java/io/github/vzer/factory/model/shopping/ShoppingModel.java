package io.github.vzer.factory.model.shopping;

import java.io.Serializable;

/**
 * @author: Vzer.
 * @date: 2017/8/3. 19:27
 * @email: vzer@qq.com
 */

public class ShoppingModel implements Serializable {
    private int pId; //商品id
    private String name; //商品名字
    private double price; //商品价格
    private String standard; //商品规格
    private String pictureUri;  //商品图片
    private int amount;  //商品数量

    public ShoppingModel(int pId, String name, double price, String standard, String pictureUri, int amount) {
        this.pId = pId;
        this.name = name;
        this.price = price;
        this.standard = standard;
        this.pictureUri = pictureUri;
        this.amount = amount;
    }
    public ShoppingModel(){}

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingModel{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", standard='" + standard + '\'' +
                ", pictureUri='" + pictureUri + '\'' +
                ", amount=" + amount +
                '}';
    }
}

package io.github.vzer.factory.model.vegetable;

/**
 * @author: Vzer.
 * @date: 2017/8/1. 13:50
 * @email: vzer@qq.com
 */

public class VegetableModel {
    private int pId; //商品id
    private String name; //商品名字
    private String type; //商品类型
    private double price; //商品价格
    private String standard; //商品规格
    private String picture;  //商品图片

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

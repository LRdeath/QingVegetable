package io.github.vzer.factory.model.vegetable;

import java.io.Serializable;

/**
 * @author: Vzer.
 * @date: 2017/8/1. 13:50
 * @email: vzer@qq.com
 */

public class VegetableModel implements Serializable{
    private int pId; //商品id
    private String name; //商品名字
    private int type; //商品类型
    private double price; //商品价格
    private String standard; //商品规格
    private String pictureUri;  //商品图片
    private String des; //商品描述
    private int count =0;//当前商品选择数量
    private int sales =0;//月销量

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }
}

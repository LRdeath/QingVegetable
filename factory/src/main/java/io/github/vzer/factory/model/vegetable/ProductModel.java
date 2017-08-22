package io.github.vzer.factory.model.vegetable;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/22.
 * email yangcihang@hrsoft.net
 */

public class ProductModel implements Serializable {
    //    {
//        "description": "驱蚊器翁",
//            "id": 1,
//            "name": "香菜",
//            "picture": "http://avatar.csdn.net/9/3/D/3_dafeige8.jpg",
//            "price": 100,
//            "sales": 1000,
//            "standard": "克",
//            "stock": 100,
//            "type": 1
//    }
    private String description;
    private int id;
    private String name;
    private String picture;
    private int price;
    private int sales;
    //单位
    private String standard;
    private int stock;
    private int type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

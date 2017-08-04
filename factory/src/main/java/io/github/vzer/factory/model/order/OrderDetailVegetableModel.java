package io.github.vzer.factory.model.order;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailVegetableModel implements Serializable {
    private String vegetableName;
    private int num;
    private int price;

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

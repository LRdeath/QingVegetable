package io.github.vzer.sharevegetable.vegetable.adapter;

import java.io.Serializable;

import io.github.vzer.factory.model.vegetable.VegetableModel;

/**
 * 商品详情页数据类
 * @author: Vzer.
 * @date: 2017/8/5. 22:37
 * @email: vzer@qq.com
 */

public class DetailData implements Serializable {
    private int position;
    private int type;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}

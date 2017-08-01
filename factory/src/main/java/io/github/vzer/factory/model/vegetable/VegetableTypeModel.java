package io.github.vzer.factory.model.vegetable;

/**
 * 商品类型表
 * @author: Vzer.
 * @date: 2017/8/1. 16:43
 * @email: vzer@qq.com
 */

public class VegetableTypeModel {
    private int type;//类型id
    private String name;//类型名字
    public VegetableTypeModel() {
        this(0,null);
    }

    public VegetableTypeModel(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

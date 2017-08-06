package io.github.vzer.sharevegetable.vegetable;

import java.util.ArrayList;
import java.util.List;

import io.github.vzer.factory.model.vegetable.VegetableModel;

/**
 * 选购商品 管理类
 *
 * @author: Vzer.
 * @date: 2017/8/5. 18:01
 * @email: vzer@qq.com
 */
public class ShoppingManager {
    private static ShoppingManager instance;
    private List<VegetableModel> shoppingList = new ArrayList<>();//购物车列表
    private int total = 0;
    public static VegetableModel model;

    private ShoppingManager() {
    }

    /**
     * 获取当前实例
     */
    public static ShoppingManager getInstance() {
        //双重校验
        if (instance == null) {
            synchronized (ShoppingManager.class) {
                if (instance == null) {
                    instance = new ShoppingManager();
                }
            }
        }
        return instance;
    }

    /**
     * 获取当前商品总数
     */
    public int getTotal() {
        return total;
    }

    /**
     * 添加一个商品
     */
    public int add(VegetableModel model) {
        int count = model.getCount();
        if (count == 0) shoppingList.add(model);
        count++;
        total++;
        model.setCount(count);
        return count;
    }

    /*
     * 减少一个商品
     */
    public int sub(VegetableModel model) {
        int count = model.getCount();
        if (count == 1) shoppingList.remove(model);
        count--;
        total--;
        model.setCount(count);
        return count;
    }

    /**
     * 清空一个商品
     */
    public void clearOneModel(VegetableModel model) {
        int cur = model.getCount();
        total-=cur;
        model.setCount(0);
        shoppingList.remove(model);
    }

    /*
     * 清空当前购物车
     */
    public void clearShopping() {
        for (VegetableModel model :
                shoppingList) {
            model.setCount(0);
        }
        shoppingList.clear();
        total = 0;
    }

    /**
     * 得到当前选购蔬菜表
     */
    public List<VegetableModel> getShoppingList() {
        return shoppingList;
    }

}

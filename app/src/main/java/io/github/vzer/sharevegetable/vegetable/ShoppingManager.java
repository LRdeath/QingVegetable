package io.github.vzer.sharevegetable.vegetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    private HashMap<Integer, VegetableModel> shoppingMap = new HashMap<>();//坐标系
    private int total = 0;
    public static VegetableModel model;
    public static List<VegetableModel> modelList;

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
        int pId = model.getpId();

        if (count == 0) shoppingMap.put(pId, model);
        count++;
        total++;
        model.setCount(count);
        return count;
    }

    /**
     * 获取当前商品数量
     */
    public int getCount(VegetableModel model) {
        int pId = model.getpId();
        int count = model.getCount();
        if (shoppingMap.containsKey(pId)) {
            VegetableModel curModel = shoppingMap.get(pId);
            if (model != curModel) {
                count = curModel.getCount();
                shoppingMap.remove(pId);
                shoppingMap.put(pId, model);
            }
        }
        model.setCount(count);
        return count;
    }

    /*
     * 减少一个商品
     */
    public int sub(VegetableModel model) {
        int count = model.getCount();
        count--;
        if (count == 0) shoppingMap.remove(model.getpId());
        total--;
        model.setCount(count);
        return count;
    }

    /**
     * 清空一个商品
     */
    public void clearOneModel(VegetableModel model) {
        int count = model.getCount();
        total -= count;
        model.setCount(0);
        shoppingMap.remove(model.getpId());
    }

    /*
     * 清空当前购物车
     */
    public void clearShopping() {
        List<VegetableModel> shoppingList = getShoppingList();
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
        List<VegetableModel> shoppingList = new ArrayList<>();
        Iterator iterator = shoppingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            VegetableModel model = (VegetableModel) entry.getValue();
            shoppingList.add(model);
        }
        return shoppingList;
    }

}

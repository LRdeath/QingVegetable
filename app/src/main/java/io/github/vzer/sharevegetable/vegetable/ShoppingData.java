package io.github.vzer.sharevegetable.vegetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;

/**
 * 选购商品 管理类
 *
 * @author: Vzer.
 * @date: 2017/8/5. 18:01
 * @email: vzer@qq.com
 */

public class ShoppingData {
    private static ShoppingData instance;
    private ArrayList<ArrayList<VegetableModel>> mList = new ArrayList<>();
    private HashMap<VegetableModel, Integer> shoppingMap = new HashMap<>();//购物车列表
    private int total = 0;

    private ShoppingData() {
    }

    /**
     * 获取当前实例
     */
    public static ShoppingData getInstance() {
        //双重校验
        if (instance == null) {
            synchronized (ShoppingData.class) {
                if (instance == null) {
                    instance = new ShoppingData();
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
    public int add(int type, int position) {
        int count = 0;
        VegetableModel cur = mList.get(type).get(position);
        if (shoppingMap.containsKey(cur)) {
            count = shoppingMap.get(cur);
        }
        count++;
        shoppingMap.put(cur, count);
        total++;
        return count;
    }

    /**
     * 添加一个商品
     */
    public int add(VegetableModel model) {
        int count = 0;
        VegetableModel cur = model;
        if (shoppingMap.containsKey(cur)) {
            count = shoppingMap.get(cur);
        }
        count++;
        total++;
        shoppingMap.put(cur, count);
        return count;
    }

    /**
     * 减少一个商品
     */
    public int sub(int type, int position) {
        int count = 0;
        VegetableModel cur = mList.get(type).get(position);
        if (shoppingMap.containsKey(cur)) {
            count = shoppingMap.get(cur);
        }
        count--;
        total--;
        shoppingMap.put(cur, count);
        return count;
    }

    /**
     * 减少一个商品
     */
    public int sub(VegetableModel model) {
        int count = 0;
        VegetableModel cur = model;
        if (shoppingMap.containsKey(cur)) {
            count = shoppingMap.get(cur);
        }
        count--;
        total--;
        shoppingMap.put(cur, count);
        return count;
    }

    /**
     * 添加并替换商品列表
     */
    public void replaceList(int type, List<VegetableModel> list) {
        if (type >= mList.size()) return;
        mList.get(type).clear();
        mList.get(type).addAll(list);

    }

    /**
     * 添加商品列表
     */
    public void addList(List<VegetableModel> list) {
        mList.add((ArrayList<VegetableModel>) list);
    }

    /**
     * 得到当前列表
     */
    public List<VegetableModel> getList(int type) {
        if (type >= mList.size()) return null;
        return mList.get(type);
    }

    /**
     * 清空当前购物车
     */
    public void clearShopping() {
        shoppingMap.clear();
        total = 0;
    }

    /**
     * 得到当前选购蔬菜表
     */
    public HashMap<VegetableModel, Integer> getVegetableList() {
        return shoppingMap;
    }

    /**
     * 得到当前购物车表
     */
    public List<ShoppingModel> getShoppingList() {
        if (shoppingMap.isEmpty()) return null;
        Iterator<Map.Entry<VegetableModel, Integer>> iterator = shoppingMap.entrySet().iterator();
        List<ShoppingModel> list = new ArrayList<>();
        //遍历选择的商品信息,打包
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int total = (int) entry.getValue();
            //如果商品数量有效,添加进购物车
            if (total > 0) {
                VegetableModel model = (VegetableModel) entry.getKey();
                list.add(new ShoppingModel(model.getpId(), model.getName(),
                        model.getPrice(), model.getStandard(), model.getPictureUri(), total));
            }
        }
        return list;
    }
}

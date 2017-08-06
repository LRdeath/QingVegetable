package io.github.vzer.sharevegetable.vegetable;

/**
 * @author: Vzer.
 * @date: 2017/8/3. 12:09
 * @email: vzer@qq.com
 */

public interface ShoppingChange {
    //添加与减少商品
    void updateSumTip();
    //获取购物车坐标位置
    int[] getShoppingCoord();
}

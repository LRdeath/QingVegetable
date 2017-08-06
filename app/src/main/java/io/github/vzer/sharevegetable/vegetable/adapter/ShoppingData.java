package io.github.vzer.sharevegetable.vegetable.adapter;

import java.io.Serializable;

/**
 * 商品数据 统计类
 *
 * @author: Vzer.
 * @date: 2017/8/5. 22:37
 * @email: vzer@qq.com
 */

public class ShoppingData implements Serializable {
    private int position; //商品所在位置
    private int page;  //商品所在页
  /*  private int count; //商品数量

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }*/

    public ShoppingData(int page,int position) {
        this.position = position;
        this.page = page;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object obj) {
        ShoppingData cur = (ShoppingData) obj;
        return position == cur.getPosition() && page == cur.getPage();
    }

    @Override
    public int hashCode() {
        return page << 10 + position;
    }
}

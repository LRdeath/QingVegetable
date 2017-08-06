package io.github.vzer.sharevegetable.vegetable.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 商品添加,减少 接口
 * @author: Vzer.
 * @date: 2017/8/5. 23:23
 * @email: vzer@qq.com
 */

public interface VegetableListener {
    void onClickSub(TextView txtAcount, int position, ImageView imgeSub);

    void onClickAdd(TextView txtAcount, View imgeAdd, ImageView imgeSub, int position);
}

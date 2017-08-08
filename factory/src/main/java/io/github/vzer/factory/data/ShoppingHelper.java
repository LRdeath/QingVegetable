package io.github.vzer.factory.data;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;
import io.github.vzer.factory.network.NetWork;

/**
 * @author: Vzer.
 * @date: 2017/8/8. 22:34
 * @email: vzer@qq.com
 */

public class ShoppingHelper {

    public static void CreateOrder(ShoppingOrderModel model, DataCallback.Callback<Integer> callback) {
        //NetWork.getService().
        // TODO: 2017/8/8  进行网络请求
        callback.onDataLoaded(778888);
    }
}

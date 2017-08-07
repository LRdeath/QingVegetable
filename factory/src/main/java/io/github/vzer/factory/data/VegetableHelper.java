package io.github.vzer.factory.data;

import java.util.ArrayList;
import java.util.List;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.model.vegetable.VegetableEvaModel;

/**
 * 蔬菜选购模块 网络请求层
 *
 * @author: Vzer.
 * @date: 2017/8/4. 17:47
 * @email: vzer@qq.com
 */

public class VegetableHelper {

    /**
     * 加载商品数据
     */
    public static void LoadDatas(int typeId, DataCallback.Callback callback) {

    }

    /**
     * 加载商品类型
     */
    public static void LoadType(DataCallback.Callback callback) {

    }

    /**
     * 加载商品评价表
     */
    public static void LoadEva(int pId, DataCallback.Callback<List<VegetableEvaModel>> callback) {
        //进行网络请求,获取数据
        // TODO: 2017/8/4
        List<VegetableEvaModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            VegetableEvaModel model = new VegetableEvaModel();
            model.setPortraitUri("http://img1.2345.com/duoteimg/qqTxImg/2013/12/ql_2/11-023953_804.jpg");
            model.setContent("香菜超级好吃！！！！！！！希望下次也一样新鲜哦哦哦哦！给店主笔芯！！！然后再凑一下字数，不知道够不够，测试一下xxxx的……");
            model.setSatisfdegree(i % 2 + 1);
            model.setName("小芳");
            model.setDate("2017-08-01");
            model.setpId(101);
            list.add(model);
        }
        callback.onDataLoaded(list);
    }
}

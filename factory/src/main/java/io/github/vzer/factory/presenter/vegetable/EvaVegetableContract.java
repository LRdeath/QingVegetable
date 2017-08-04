package io.github.vzer.factory.presenter.vegetable;

import java.util.List;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.vegetable.VegetableEvaModel;

/**
 * @author: Vzer.
 * @date: 2017/8/4. 17:56
 * @email: vzer@qq.com
 */

public interface EvaVegetableContract {
    interface Presenter extends BaseContract.Presenter{
        /**
         * 加载商品评价表
         * @param pId 商品id
         */
        void LoadEva(int pId);
    }
    interface View extends BaseContract.View<Presenter>{

        /**
         * 商品评价表 加载成功
         */
        void LoadEvaSuccess(List<VegetableEvaModel> evaModels);
    }
}

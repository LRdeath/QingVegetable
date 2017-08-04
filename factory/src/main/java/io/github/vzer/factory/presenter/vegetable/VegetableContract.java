package io.github.vzer.factory.presenter.vegetable;

import android.widget.ListView;

import java.util.List;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.vegetable.VegetableEvaModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;

/**
 * 商品选购模块的 公约
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public interface VegetableContract {
    interface View extends BaseContract.View<Presenter> {
        /**
         * 商品数据 加载成功
         */
        void LoadDatasSuccess(List<VegetableModel> vegetableModels);
        /**
         * 商品类型 加载成功
         */
        void LoadTypeSuccess(List<VegetableTypeModel> typeModels);

    }

    interface Presenter extends BaseContract.Presenter {
        /**
         * 加载商品数据
         */
        void LoadDatas(int typeId);
        /**
         * 加载商品类型
         */
        void LoadType();


    }
}

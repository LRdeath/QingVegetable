package io.github.vzer.factory.presenter.vegetable;

import java.util.List;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.VegetableHelper;
import io.github.vzer.factory.model.vegetable.VegetableEvaModel;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.Utility;

/**
 * @author: Vzer.
 * @date: 2017/8/4. 17:56
 * @email: vzer@qq.com
 */

public class EvaVegetablePresenter extends BasePresenter<EvaVegetableContract.View> implements EvaVegetableContract.Presenter,DataCallback.Callback<List<VegetableEvaModel>> {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public EvaVegetablePresenter(EvaVegetableContract.View mView) {
        super(mView);
    }

    @Override
    public void LoadEva(int pId) {
        VegetableHelper.LoadEva(pId,this);
    }

    @Override
    public void onDataLoaded(List<VegetableEvaModel> evaModels) {
        //数据加载成功,传递给V层
        mView.LoadEvaSuccess(evaModels);
    }

    @Override
    public void onFailedLoaded(final int error) {
        //显示错误信息
        ToastUtil.showToast(error);
    }
}

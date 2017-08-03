package io.github.vzer.factory.presenter.vegetable;

import java.util.ArrayList;
import java.util.List;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */
public class VegetablePresenter extends BasePresenter<VegetableContract.View>
        implements VegetableContract.Presenter, DataCallback {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public VegetablePresenter(VegetableContract.View mView) {
        super(mView);
    }

    @Override
    public void LoadDatas(int typeId) {
        List<VegetableModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            VegetableModel model = new VegetableModel();
            model.setName("香菜");
            model.setPrice(18);
            model.setStandard("500g/份");
            model.setSales(56);
            model.setPictureUri("http://www.cnlvying.com/upfiles/2014-3-18-15-47-12.jpg");
            model.setType(0);
            models.add(model);
        }
        mView.LoadDatasSuccess(models);
    }

    @Override
    public void LoadType() {
        List<VegetableTypeModel> typeModels = new ArrayList<>();
        VegetableTypeModel model = new VegetableTypeModel(1,"海鲜类");
        typeModels.add(model);
        mView.LoadTypeSuccess(typeModels);
    }
}

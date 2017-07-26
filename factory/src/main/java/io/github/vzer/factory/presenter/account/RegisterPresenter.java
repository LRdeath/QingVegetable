package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * 用户注册Presenter层
 * @author: Vzer.
 * @date: 2017/7/25. 20:56
 * @email: vzer@qq.com
 */

public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter,DataCallback.Callback<User> {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public RegisterPresenter(RegisterContract.View mView) {
        super(mView);
    }

    @Override
    public void register(String phone, String password, String code) {

    }


    /**
     * 数据加载失败
     * @param error 错误信息id
     */
    @Override
    public void onFailedloaded(int error) {
        //拿到V层,V层不存在,不做任何操作;
        RegisterContract.View view = mView;
        if (view ==null)return;

        //提示错误信息
        ToastUtil.showToast(error);
    }

    /**
     * 注册成功
     * @param user 返回的User
     */
    @Override
    public void onDataLoaded(User user) {

    }
}

package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.AccountHelper;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 16:52
 * @email: vzer@qq.com
 */

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter, DataCallback.Callback<User> {


    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public LoginPresenter(LoginContract.View mView) {
        super(mView);
    }

    @Override
    public void login(String phone, String password) {
        // TODO: 2017/7/25 对登陆信息的格式进行判断
        start();
        LoginModel model = new LoginModel(phone,password);
        //调用M层对登陆请求进行处理
        AccountHelper.login(model,this);


    }


    @Override
    public void onDataLoaded(User user) {
        LoginContract.View view = mView;
        //如果view不存在,不做任何操作
        if (view == null) return;

        //通知V层登录成功
        mView.loginSuccess();
    }


    @Override
    public void onFailedLoaded(int error) {
        LoginContract.View view = mView;
        //如果view不存在,不做任何操作
        if (view == null) return;
        view.showError(error);
        //提示错误信息
        ToastUtil.showToast(error);
    }
}

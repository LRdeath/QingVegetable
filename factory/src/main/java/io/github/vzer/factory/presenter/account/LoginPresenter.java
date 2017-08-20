package io.github.vzer.factory.presenter.account;

import android.text.TextUtils;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.R;
import io.github.vzer.factory.data.AccountHelper;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.RegexUtil;

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
        start();
        final LoginContract.View view = mView;
        //判断账号密码是否填写正确

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            //账号密码为空
            view.showError(R.string.data_account_login_invalid_parameter);
        } else if (!RegexUtil.checkMobile(phone) ) {
            //手机号格式错误
            view.showError(R.string.data_account_register_invalid_parameter_mobile);
        } else if (password.length() < 6){
            //密码不能小于6位
            view.showError(R.string.data_account_register_invalid_parameter_password);
        }
            else{
            //对数据进行封装
            LoginModel model = new LoginModel(phone, password);
            //网络请求
            //传递数据,进行登录操作
            AccountHelper.login(model, this);
        }

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
        //ToastUtil.showToast(error);
    }
}

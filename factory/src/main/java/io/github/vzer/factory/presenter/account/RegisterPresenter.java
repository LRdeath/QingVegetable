package io.github.vzer.factory.presenter.account;

import android.text.TextUtils;

import java.util.regex.Pattern;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.R;
import io.github.vzer.factory.constant.CommonConstant;
import io.github.vzer.factory.data.AccountHelper;
import io.github.vzer.factory.model.account.RegisterModel;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * 用户注册Presenter层
 *
 * @author: Vzer.
 * @date: 2017/7/25. 20:56
 * @email: vzer@qq.com
 */

public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter, DataCallback.Callback<User> {
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
    public void register(String phone, String password, String rePassword, String code) {
        //P层启动方法
        start();

        //得到view接口
        final RegisterContract.View view = mView;
        //判断账号密码是否为空
        if (!checkMobile(phone)) {
            //提示
            view.showError(R.string.data_account_register_invalid_parameter_mobile);
        } else if (code.length() < 4) {
            //验证码大于4位
            view.showError(R.string.data_account_register_invalid_parameter_code);
        } else if (!password.equals(rePassword)) {
            //俩次输入的密码不一致
            view.showError(R.string.data_account_register_invalid_parameter_repassword);
        } else if (password.length() < 6) {
            //密码需要大于6位
            view.showError(R.string.data_account_register_invalid_parameter_password);
        } else {
            //对数据进行封装
            RegisterModel model = new RegisterModel(phone, password, code);
            //传递给Model层,进行注册操作
            AccountHelper.register(model, this);
        }
    }

    private boolean checkMobile(String phone) {
        //手机号不为空,并且满足格式
        return !TextUtils.isEmpty(phone) && Pattern.matches(CommonConstant.REGEX_MOBILE, phone);
    }

    @Override
    public void postVerify(String phone) {

    }

    /**
     * 注册成功
     *
     * @param user 返回的User
     */
    @Override
    public void onDataLoaded(User user) {
        RegisterContract.View view = mView;
        if (view == null) return;

        //通知注册成功
        //view.registerSuccess();
    }

    /**
     * 数据加载失败
     *
     * @param error 错误信息id
     */
    @Override
    public void onFailedLoaded(int error) {
        //拿到V层,V层不存在,不做任何操作;
        RegisterContract.View view = mView;
        if (view == null) return;

        //提示错误信息
        ToastUtil.showToast(error);
    }


}

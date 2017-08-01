package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.R;
import io.github.vzer.factory.data.AccountHelper;
import io.github.vzer.factory.model.account.RegisterModel;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.RegexUtil;

/**
 * @author: Vzer.
 * @date: 2017/7/29. 13:31
 * @email: vzer@qq.com
 */

public class RetrivePresenter extends BasePresenter<RetriveContract.View>
        implements RetriveContract.Presenter, DataCallback.Callback<User> {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public RetrivePresenter(RetriveContract.View mView) {
        super(mView);
    }

    /**
     *
     * @param phone
     */
    @Override
    public void postVerify(String phone) {
        final RetriveContract.View view =mView;
        AccountHelper.postVerify(phone);

    }

    /**
     * 对输入格式进行判断
     */
    @Override
    public void resetPassword(String phone, String password, String rePassword, String code) {

        start();//P层开始工作
        //得到view接口
        final RetriveContract.View view =mView;
        //判断账号密码是否为空
        if (!RegexUtil.checkMobile(phone)) {
            //提示手机号格式不对
            view.showError(R.string.data_account_register_invalid_parameter_mobile);
        } else if (code.length() < 4) {
            //验证码大于4位
            view.showError(R.string.data_account_register_invalid_parameter_code);
        } else if (!password.equals(rePassword)){
            //俩次输入的密码不一致
            view.showError(R.string.data_account_register_invalid_parameter_repassword);
        } else if (password.length() < 6) {
            //密码需要大于6位
            view.showError(R.string.data_account_register_invalid_parameter_password);
        } else {
            //对数据进行封装
            RegisterModel model = new RegisterModel(phone, password, code);
            //传递给Model层,进行注册操作
            AccountHelper.resetPassword(model, this);
        }
    }



    @Override
    public void onDataLoaded(User user) {
        RetriveContract.View view = mView;
        if (view == null) return;
        //数据加载成功
        ToastUtil.showToast(R.string.data_account_retrive_reset_success);
        mView.resetSuccess();
    }

    @Override
    public void onFailedLoaded(int error) {
        RetriveContract.View view = mView;
        if (view == null) return;
        //加载失败,提示错误信息
        ToastUtil.showToast(error);
        mView.showError(error);
    }
}

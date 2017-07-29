package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.R;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.utils.ToastUtil;

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

    @Override
    public void postVerify(String phone) {
        // TODO: 2017/7/29 网络请求 发送短信验证码
    }

    @Override
    public void resetPassword(String phone, String password, String rePassword, String code) {
        // TODO: 2017/7/29 网络请求重置密码
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

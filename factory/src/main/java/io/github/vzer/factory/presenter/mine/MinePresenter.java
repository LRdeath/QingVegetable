package io.github.vzer.factory.presenter.mine;


import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.MineHelper;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter, DataCallback {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public MinePresenter(MineContract.View mView) {
        super(mView);
    }

    @Override
    public void goLogin() {
        // TODO: 17/7/29 完成退出登录
        ToastUtil.showToast("用户已经退出登录了...");
    }

    @Override
    public boolean changeSex(boolean sex) {
        // TODO: 17/8/10 在缓存区改变用户信息
        return MineHelper.updateSexRequest(this);
    }


    @Override
    public boolean changeUserName(String newUserName) {
        return MineHelper.updateUserNameRequest(this);
    }

    @Override
    public boolean changeTrueName(String newTrueName) {
        return MineHelper.updateUserTrueNameRequest(this);
    }

    @Override
    public boolean changeAvatar(String uri) {
        return MineHelper.updateAvatarRequest(this);
    }
}

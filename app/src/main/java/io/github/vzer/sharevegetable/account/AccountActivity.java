package io.github.vzer.sharevegetable.account;

import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.widget.FrameLayout;

import butterknife.BindView;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.Fragment;
import io.github.vzer.factory.utils.FragmentUtil;
import io.github.vzer.sharevegetable.R;

public class AccountActivity extends BaseActivity implements AccountTrigger {

    private Fragment mCurFragment;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;

    @BindView(R.id.account_container)
    FrameLayout mContainer;

    public static void show(Context context) {
        context.startActivity(new Intent(context, AccountActivity.class));
    }
    @Override
    public void initWidget() {
        //初始化当前加载的 Fragment
        mCurFragment = mLoginFragment = new LoginFragment();
        FragmentUtil.add(this, R.id.account_container, mCurFragment);
    }
    @Override
    protected void initWindows() {

    }

    @Override
    protected void initData() {
    }
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_account;
    }


    /**
     * Fragment切换回调此方法
     */
    @Override
    public void triggerView() {
        //判断当前的Fragment
        if (mCurFragment == mLoginFragment) {
            //RegisterFragment不存在就创建,只会创建一次
            if (mRegisterFragment == null) {
                mRegisterFragment = new RegisterFragment();
            }
            mCurFragment = mRegisterFragment;

        } else mCurFragment = mLoginFragment;

        //切换显示Fragment
        FragmentUtil.replace(this, R.id.account_container, mCurFragment);
    }
}

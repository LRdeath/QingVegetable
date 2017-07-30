package io.github.vzer.sharevegetable.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import butterknife.BindView;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.Fragment;
import io.github.vzer.factory.utils.FragmentUtil;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

public class AccountActivity extends BaseActivity implements AccountTrigger {
    private boolean isReCreate = false;
    private Fragment mCurFragment;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;
    private final String TAG_LOGIN = "login";
    private final String TAG_REGISTER = "register";
    private String mCurTag;
    @BindView(R.id.account_container)
    FrameLayout mContainer;

    public static void show(Context context) {
        context.startActivity(new Intent(context, AccountActivity.class));
    }

    @Override
    public void initWidget() {
        //初始化当前加载的 Fragment
        if (isReCreate) {
            mLoginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(TAG_LOGIN);
            mRegisterFragment = (RegisterFragment) getSupportFragmentManager().findFragmentByTag(TAG_REGISTER);
            if (mLoginFragment == null) {
                changFragment(TAG_REGISTER, mRegisterFragment);
            } else changFragment(TAG_LOGIN, mLoginFragment);
        } else {
            mCurFragment = mLoginFragment = new LoginFragment();
            mCurTag = TAG_LOGIN;

            FragmentUtil.add(this, R.id.account_container, mCurFragment, mCurTag);
        }

    }

    private void changFragment(String tag, Fragment fragment) {
        mCurFragment = fragment;
        mCurTag = tag;
        FragmentUtil.replace(this, R.id.account_container, mCurFragment, mCurTag);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) isReCreate = true;
        else isReCreate = false;
        super.onCreate(savedInstanceState);
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
            mCurTag = TAG_REGISTER;
        } else {
            mCurFragment = mLoginFragment;
            mCurTag = TAG_LOGIN;
        }

        //切换显示Fragment
        FragmentUtil.replace(this, R.id.account_container, mCurFragment, mCurTag);
    }

    private long exit_time = 0;

    /**
     * 返回键监听
     */
    @Override
    public void onBackPressed() {
        long cur = System.currentTimeMillis();
        if (cur - exit_time < 2000) {
            super.onBackPressed();
        } else {
            ToastUtil.showToast(R.string.toast_exit);
            exit_time = cur;
        }
    }
}

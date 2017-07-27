package io.github.vzer.sharevegetable.account;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.account.RegisterContract;
import io.github.vzer.factory.presenter.account.RegisterPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.main.MainActivity;

/**
 * 注册Fragment V层
 * @author: Vzer.
 * @date: 2017/7/25. 21.01
 * @email: vzer@qq.com
 */
public class RegisterFragment extends FragmentPresenter<RegisterContract.Presenter> implements RegisterContract.View {


    private AccountTrigger mTrigger;

    @BindView(R.id.edit_account_phone)
    EditText phoneEdit;
    @BindView(R.id.edit_account_verify)
    EditText verifyEdit;
    @BindView(R.id.edit_account_password)
    EditText passwordEdit;
    @BindView(R.id.edit_account_confirm_password)
    EditText rePasswordEdit;
    @BindView(R.id.progress_loading)
    ProgressBar loadingProgress;
    @BindView(R.id.txt_go_login)
    TextView goLoginTxt;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //获取到AccountActivity的引用
        mTrigger = (AccountTrigger) context;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register;
    }


    @OnClick(R.id.txt_go_login)
    void go_login() {
        mTrigger.triggerView();
    }

    @OnClick(R.id.btn_account_submit)
    void submit() {
        String phone = phoneEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        String verifi = verifyEdit.getText().toString();
        String rePassword = rePasswordEdit.getText().toString();
        //通知P层进行注册
        mPresenter.register(phone, password, verifi, rePassword);
    }
    /**
     * 注册成功的处理方法
     * P层回调此方法
     */
    @Override
    public void registerSuccess() {
        //进入主页面,结束当前
        MainActivity.show(getActivity());
        getActivity().finish();
    }

    /**
     * 注册时显示一个Loading
     */
    @Override
    public void showLoading() {
        passwordEdit.setEnabled(false);
        phoneEdit.setEnabled(false);
        verifyEdit.setEnabled(false);
        rePasswordEdit.setEnabled(false);
        goLoginTxt.setEnabled(false);
        loadingProgress.setVisibility(View.VISIBLE);
    }

    /**
     * 显示提示信息后,恢复控件使用
     */
    @Override
    public void showError(int strId) {
        super.showError(strId);
        passwordEdit.setEnabled(true);
        phoneEdit.setEnabled(true);
        verifyEdit.setEnabled(true);
        rePasswordEdit.setEnabled(true);
        goLoginTxt.setEnabled(true);
        loadingProgress.setVisibility(View.GONE);
    }

    @Override
    protected RegisterContract.Presenter initPresenter() {
        //创建P层
        return new RegisterPresenter(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }


}

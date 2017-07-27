package io.github.vzer.sharevegetable.account;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.account.LoginContract;
import io.github.vzer.factory.presenter.account.LoginPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.main.MainActivity;

/**
 * 登录Fragment V层
 * @author: Vzer.
 * @date: 2017/7/25. 17.01
 * @email: vzer@qq.com
 */
public class LoginFragment extends FragmentPresenter<LoginContract.Presenter>
        implements LoginContract.View {

    private AccountTrigger mTrigger;

    @BindView(R.id.edit_account_phone)
    EditText phoneEdit;
    @BindView(R.id.edit_account_password)
    EditText passwordEdit;
    @BindView(R.id.txt_go_register)
    TextView goRegisterTxt;
    @BindView(R.id.btn_account_submit)
    Button submitBtn;
    @BindView(R.id.progress_loading)
    ProgressBar loadingProgress;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //获取到AccountActivity的引用
        mTrigger = (AccountTrigger) context;
    }

    //登录点击事件
    @OnClick(R.id.btn_account_submit)
    void submit() {
        String phone = phoneEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        Log.d("TAG", "OnClick");
        //通知P层进行登录
        mPresenter.login(phone, password);
    }

    @OnClick(R.id.txt_go_register)
    void goRegister() {
        Log.d("TAG", "OnClick");
        mTrigger.triggerView();
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_login;
    }

    /**
     * 登陆成功后,进入主页面,结束当前页面
     */
    @Override
    public void loginSuccess() {
        MainActivity.show(getActivity());
        getActivity().finish();
    }

    @Override
    protected LoginContract.Presenter initPresenter() {
        //创建P层
        return new LoginPresenter(this);
    }

    /**
     * 显示进度条,使其他控件失效
     */
    @Override
    public void showLoading() {
        passwordEdit.setEnabled(false);
        phoneEdit.setEnabled(false);
        goRegisterTxt.setEnabled(false);
        submitBtn.setEnabled(false);
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
        goRegisterTxt.setEnabled(true);
        submitBtn.setEnabled(true);
        //loadingProgress.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        Log.d("TAG", String.valueOf(passwordEdit.getId()));
    }


    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
    }

    @Override
    protected void initArgs(Bundle arguments) {
    }
}

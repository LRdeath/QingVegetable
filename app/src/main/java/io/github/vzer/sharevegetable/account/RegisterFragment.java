package io.github.vzer.sharevegetable.account;


import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.account.RegisterContract;
import io.github.vzer.factory.presenter.account.RegisterPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.RegexUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.main.MainActivity;

/**
 * 注册Fragment V层
 *
 * @author: Vzer.
 * @date: 2017/7/25. 21.01
 * @email: vzer@qq.com
 */
public class RegisterFragment extends FragmentPresenter<RegisterContract.Presenter> implements RegisterContract.View, TextWatcher {


    private AccountTrigger mTrigger;
    private VerifyDownTimer timerVerify; //验证码倒计时器
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
    @BindView(R.id.btn_account_submit)
    Button submitBtn;
    @BindView(R.id.txt_go_login)
    TextView goLoginTxt;
    @BindView(R.id.btn_account_get_verify)
    Button getVerifyBtn;

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


    /**
     * 跳转到登录界面
     */
    @OnClick(R.id.txt_go_login)
    void go_login() {
        mTrigger.triggerView();
    }

    /**
     * 注册点击事件处理
     */
    @OnClick(R.id.btn_account_submit)
    void submit() {
        String phone = phoneEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        String verify = verifyEdit.getText().toString();
        String rePassword = rePasswordEdit.getText().toString();
        //通知P层进行注册
        mPresenter.register(phone, password, rePassword, verify);
    }

    @OnClick(R.id.btn_account_get_verify)
    void getVerify() {
        String phone = phoneEdit.getText().toString();

        if (!RegexUtil.checkMobile(phone)) {
            //提示手机号格式不对
            showError(io.github.vzer.factory.R.string.data_account_register_invalid_parameter_mobile);
        } else {
            mPresenter.postVerify(phone);
            getVerifyBtn.setEnabled(false);
            isWaiting = true;//更新等待读秒状态
            timerVerify = new VerifyDownTimer(60000, 1000);
            timerVerify.start();
        }

    }

    /**
     * 注册成功的处理方法
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
        submitBtn.setEnabled(false);
        getVerifyBtn.setEnabled(false);
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
        submitBtn.setEnabled(true);
        //提示错误信息
        ToastUtil.showToast(strId);
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
        passwordEdit.addTextChangedListener(this);
        verifyEdit.addTextChangedListener(this);
        phoneEdit.addTextChangedListener(this);
        rePasswordEdit.addTextChangedListener(this);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    private boolean isWaiting = false;

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //设置获取验证码 btn能否点击,等待读秒中不进行判断
        if (!isWaiting) {
            if (phoneEdit.getText().toString().isEmpty()) {
                getVerifyBtn.setEnabled(false);
                submitBtn.setEnabled(false);
                return;
            } else getVerifyBtn.setEnabled(true);
        }
        //设置重置Btn 能否点击
        if (phoneEdit.getText().toString().isEmpty() ||
                verifyEdit.getText().toString().isEmpty() ||
                passwordEdit.getText().toString().isEmpty() ||
                rePasswordEdit.getText().toString().isEmpty()) {
            submitBtn.setEnabled(false);
        } else submitBtn.setEnabled(true);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timerVerify ==null)return;
        timerVerify.onFinish();
        timerVerify.cancel();//关闭倒计时器
    }

    /**
     * 验证码倒计时器
     */
    class VerifyDownTimer extends CountDownTimer {

        public VerifyDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            int i = (int) (l / 1000);
            getVerifyBtn.setText("还剩" + i + "秒");
        }

        @Override
        public void onFinish() {
            isWaiting = false;
            if (getVerifyBtn==null)return;
            getVerifyBtn.setEnabled(true);
            getVerifyBtn.setText("重新获取");
        }
    }
}

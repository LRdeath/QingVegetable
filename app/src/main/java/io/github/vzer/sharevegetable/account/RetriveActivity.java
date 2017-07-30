package io.github.vzer.sharevegetable.account;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.presenter.account.RetriveContract;
import io.github.vzer.factory.presenter.account.RetrivePresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/7/28. 15:56
 * @email: vzer@qq.com
 */

public class RetriveActivity extends ToolbarActivityPresenter<RetriveContract.Presenter>
        implements RetriveContract.View, TextWatcher {
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
    @BindView(R.id.btn_account_get_verify)
    Button getVerifyBtn;

    public static void show(Context context) {
        context.startActivity(new Intent(context, RetriveActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        this.setActivityTitle(getResources().getString(R.string.label_retrive));
        submitBtn.addTextChangedListener(this);
        phoneEdit.addTextChangedListener(this);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_retrive;
    }

    /**
     * 注册点击事件处理
     */
    @OnClick(R.id.btn_account_submit)
    void submit() {
        String phone = phoneEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        String verifi = verifyEdit.getText().toString();
        String rePassword = rePasswordEdit.getText().toString();
        //通知P层进行注册
        mPresenter.resetPassword(phone, password, verifi, rePassword);
    }

    /**
     * 获取短信验证码
     */
    @OnClick(R.id.btn_account_get_verify)
    void getVerify() {
        String phone = phoneEdit.getText().toString();
        mPresenter.postVerify(phone);
        getVerifyBtn.setEnabled(false);

        isWaiting = true;//更新等待读秒状态
        Handler handler = new Handler();
        for (int i = 59; i > 0; i--) {
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getVerifyBtn.setText("还剩" + finalI + "秒");
                    if (finalI == 1) {
                        getVerifyBtn.setText("重新获取");
                        isWaiting = false;
                        getVerifyBtn.setEnabled(true);
                    }
                }
            }, (60 - i) * 1000);
        }

    }

    /**
     * 密码重置成功
     */
    @Override
    public void resetSuccess() {
        ToastUtil.showToast("密码重置成功!请重新登录");
    }

    /**
     * 加载失败显示错误信息
     */
    @Override
    public void showError(int strId) {
        //提示错误信息
        ToastUtil.showToast(strId);
        passwordEdit.setEnabled(false);
        phoneEdit.setEnabled(false);
        verifyEdit.setEnabled(false);
        rePasswordEdit.setEnabled(false);
        loadingProgress.setVisibility(View.GONE);
    }

    /**
     * 展示加载进度条
     */
    @Override
    public void showLoading() {
        passwordEdit.setEnabled(false);
        phoneEdit.setEnabled(false);
        verifyEdit.setEnabled(false);
        rePasswordEdit.setEnabled(false);
        loadingProgress.setVisibility(View.VISIBLE);
    }


    /**
     * V与P之间互相绑定
     */
    @Override
    public RetriveContract.Presenter initPresenter() {
        return new RetrivePresenter(this);
    }

    /**
     * 监听EditText输入
     */
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    private boolean isWaiting = false;//等待读秒状态

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //设置 获取验证码 btn能否点击,等待读秒中不进行判断
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
}

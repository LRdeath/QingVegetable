package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.sharevegetable.R;

/**
 * 订单备注Activity
 *
 * @author: Vzer.
 * @date: 2017/8/8. 16:55
 * @email: vzer@qq.com
 */

public class RemarkActivity extends ToolbarActivity {
    @BindView(R.id.edit_shopping_remark)
    EditText remarkEdit;


    @OnClick(R.id.btn_remark_submit)
    void submit() {
        String res = remarkEdit.getText().toString();
        if (!TextUtils.isEmpty(res))
            this.setResult(3, new Intent().putExtra(FirmOrderActivity.REMARK_CODE, res));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle(getString(R.string.title_remark));
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_remark;
    }
}

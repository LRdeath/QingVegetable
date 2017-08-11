package io.github.vzer.common.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import io.github.vzer.common.R;

/**
 * @author: Vzer.
 * @date: 2017/7/26. 16:44
 * @email: vzer@qq.com
 */

public abstract class ToolbarActivity extends AppCompatActivity {

    /**
     * activity 页面Toolbar
     */
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            LinearLayout root = (LinearLayout) getToolbarView();
            setContentView(root);
            ButterKnife.bind(this, root);
            initData();
            initWidget();
        } else {
            finish();
        }

    }

    /**
     * 初始化相关参数
     * 需要则重写
     *
     * @param extras 参数bundle
     * @return 参数正确返回true，错误返回false
     */
    protected boolean initArgs(Bundle extras) {
        return true;
    }

    /**
     * 初始化窗口
     */
    protected void initWindows() {
    }

    /**
     * 获取带toolbar的基类页面View
     *
     * @return View
     */
    private View getToolbarView() {
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") LinearLayout viewRoot = (LinearLayout) inflater.inflate(R.layout.base_toolbar_layout, null);
        FrameLayout viewContainer = viewRoot.findViewById(R.id.view_container);
        viewContainer.addView(inflater.inflate(getContentLayoutId(), null));
        initToolbar(viewRoot);
        return viewRoot;
    }

    /**
     * 初始化控件
     */
    protected abstract void initWidget();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 返回当前的布局id
     *
     * @return 当前布局id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化设置toolbar.
     *
     * @param root 页面rootView
     */
    private void initToolbar(View root) {
        toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackBtnOnclick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 获取当前页面的toolbar.
     *
     * @return toolbar
     */
    protected Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * 设置activity 页面标题
     *
     * @param charSequence 页面标题
     */
    protected void setActivityTitle(CharSequence charSequence) {
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
            toolbar.setTitleTextColor(getResources().getColor(R.color.textPrimary));
        }
    }

    /**
     * Toolbar返回按钮的监听事件
     */
    protected void onBackBtnOnclick() {
        this.finish();
    }


}

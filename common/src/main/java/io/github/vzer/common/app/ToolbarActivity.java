package io.github.vzer.common.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import io.github.vzer.common.R;

/**
 * @author: Vzer.
 * @date: 2017/7/26. 16:44
 * @email: vzer@qq.com
 */

public abstract class ToolbarActivity extends BaseActivity {

    /**
     * activity 页面Toolbar
     */
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getToolbarView());
    }

    /**
     * 获取带toolbar的基类页面View
     *
     * @return View
     */
    private View getToolbarView() {
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") RelativeLayout viewRoot = (RelativeLayout) inflater.inflate(R.layout.base_toolbar_layout, null);
        FrameLayout viewContainer = viewRoot.findViewById(R.id.view_container);
        viewContainer.addView(inflater.inflate(getContentLayoutId(), null));
        initToolbar(viewRoot);
        ButterKnife.bind(this, viewRoot);
        initWidget();
        return viewRoot;
    }

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
